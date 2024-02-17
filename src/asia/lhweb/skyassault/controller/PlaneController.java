package asia.lhweb.skyassault.controller;

import asia.lhweb.skyassault.Util.BoomUtils;

import asia.lhweb.skyassault.Util.DialogUtils;
import asia.lhweb.skyassault.Util.ImageUtils;
import asia.lhweb.skyassault.Util.MusicUtils;
import asia.lhweb.skyassault.View.RightJPanel;
import asia.lhweb.skyassault.View.UI;
import asia.lhweb.skyassault.config.GameConfig;
import asia.lhweb.skyassault.constant.GameConstant;
import asia.lhweb.skyassault.controller.time.BackGroundTime;
import asia.lhweb.skyassault.controller.time.FlyObjTime;
import asia.lhweb.skyassault.dao.EnemyPlaneFactory;
import asia.lhweb.skyassault.model.bean.*;
import asia.lhweb.skyassault.model.bean.fly.*;
import asia.lhweb.skyassault.model.bean.plane.BossPlane;
import asia.lhweb.skyassault.model.bean.plane.EnemyPlane;
import asia.lhweb.skyassault.model.bean.plane.HeroPlane;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 飞机控制器
 *
 * @author 罗汉
 * @date 2024/01/25
 */
public class PlaneController {
    private static PlaneController instance;
    private UI ui;
    private RightJPanel rightJPanel;// 右侧信息面板
    private BackGround backGround1;// 背景1
    private BackGround backGround2;// 背景2  用来移动画布
    private Radar radar;// 背景2  用来移动画布
    private BackGroundTime backGroundTime;// 背景监听器
    private FlyObjTime flyObjTime;// 飞行物监听器
    private Player player;// 玩家
    private boolean allowMovement = false;// 是否鼠标移动
    private List<HeroPlane> heroPlaneList;// 玩家飞机列表
    private List<FlyingObj> flyingObjectList = new ArrayList<>();
    ; // 存储所有飞行物 敌机、奖励物
    private List<FlyingObj> boomObjectList = new ArrayList<>(); // 存储爆炸效果
    private List<Bullet> myPlaneBulletList = new ArrayList<>();// 英雄飞机子弹
    private List<Bullet> enemyPlaneBulletList = new ArrayList<>();// 敌机子弹
    private List<Bullet> bossBulletList = new ArrayList<>();// 敌机子弹
    private List<FlyingObj> cleanList = new ArrayList<>();// 敌机子弹销毁池

    private PlaneController() {
        // 各种初始化
        init();
    }

    /**
     * 初始化
     */
    public void init() {
        // 各种初始化
        backGround1 = new BackGround();
        backGround2 = new BackGround();
        backGround2.setBackY(-GameConstant.GAME_WINDOW_HEIGHT);

        radar = new Radar();
        player = new Player();

        heroPlaneList = player.getHeroPlaneList();
        backGroundTime = new BackGroundTime(this);
        flyObjTime = new FlyObjTime(this);
        ui = new UI(this);
        rightJPanel = ui.getGameJFrame().getRightJPanel();// 右侧信息面板

    }

    // 获取唯一实例的静态方法
    public static PlaneController getInstance() {
        if (instance == null) {
            instance = new PlaneController();
        }
        return instance;
    }

    /**
     * 初始化
     */
    public static void run() {
        getInstance();
    }

    /**
     * 清理数据
     */
    public void clear() {
        flyingObjectList.clear();
        myPlaneBulletList.clear();
        enemyPlaneBulletList.clear();
        bossBulletList.clear();
        cleanList.clear();
    }
    /**
     * 开始游戏
     */
    public void startGame() {
        System.out.println("开始游戏执行了1次");
        // todo 清理屏幕
        GameConfig.setGameState(1);
        generateRandomFlyingObject();// 初始化随机生成物
        setAllowMovement(true);// 设置鼠标是否可以点击
        getUi().getGameJFrame().getGameJPanel().setListener();// 开启监听器
        backGroundTime.startTimer();// 开启背景定时器
        flyObjTime.startTimer();// 开启飞行物定时器
        MusicUtils.getBgMusicThread().setStop(false);

        // 初始化右侧面板数据
        GameConfig.startGame(this);
    }

    /**
     * 继续游戏
     */
    public void resumeGame() {
        GameConfig.setGameState(1);
        backGround1.setBackImage(GameConfig.getBackImage());
        backGround2.setBackImage(GameConfig.getBackImage());

        MusicUtils.getBgMusicThread().setStop(false);// 关闭音乐
        backGroundTime.resumeTimer();
        flyObjTime.resumeTimer();

    }

    /**
     * 重新开始游戏
     */
    public void restartGame() {
        //清理数据
        clear();
        //复位右侧面板数据
        getUi().getGameJFrame().getRightJPanel().resetPanelData();

        // 重新初始化游戏状态和数据
        generateRandomFlyingObject();// 初始化随机生成物
        setAllowMovement(true);// 设置鼠标是否可以点击
        getUi().getGameJFrame().getGameJPanel().setListener();// 开启监听器

        // 开启定时器和音乐
        backGroundTime.startTimer();// 开启背景定时器
        flyObjTime.startTimer();// 开启飞行物定时器
        MusicUtils.getBgMusicThread().setStop(false);
        GameConfig.startGame(this);
        GameConfig.setGameState(1);
    }

    /**
     * 暂停游戏
     */
    public void pauseGame() {
        MusicUtils.getBgMusicThread().setStop(true);// 关闭音乐
        backGroundTime.pauseTimer();
        flyObjTime.pauseTimer();
    }

    /**
     * 结束游戏
     */
    public void endGame() {
        backGroundTime.stopTimer();
        flyObjTime.stopTimer();
        getUi().endGame();
    }

    /**
     * 初始化生成随机飞行物
     */
    public void generateRandomFlyingObject() {
        System.out.println("生成了随机生成物");
        double random;
        FlyingObj flyingObj;
        for (int i = 0; i < GameConfig.getEnemyPlanes(); i++) {
            random = Math.random();
            // 计算y轴偏移量
            int yOffset = (i == 0) ? -100 : -i * 150;
            if (random < 0.7) {
                // 70%的概率生成敌机
                flyingObj = EnemyPlaneFactory.createEnemyPlane(getRandomX(), yOffset);
            } else if (random < 0.8) {
                // 10%的概率生成小蜜蜂
                flyingObj = EnemyPlaneFactory.createBee(getRandomX(), yOffset);
            } else if (random < 0.9) {
                // 10%的概率生成双倍火力奖励
                flyingObj = EnemyPlaneFactory.createDoubleFirePower(getRandomX(), yOffset);
            } else {
                // 10%的概率生成核弹奖励
                flyingObj = EnemyPlaneFactory.createNuclearBomb(getRandomX(), yOffset);
            }
            flyingObjectList.add(flyingObj);
        }
        // 添加Boss敌机
        FlyingObj lastEnemyPlane = flyingObjectList.get(flyingObjectList.size() - 1);
        BossPlane bossPlane = new BossPlane();
        bossPlane.setFlyX(GameConstant.GAME_WINDOW_LEFT_WIDTH / 4);
        bossPlane.setFlyY(lastEnemyPlane.getFlyY() + 50);
        flyingObjectList.add(bossPlane);
    }

    /**
     * 玩家飞机发射子弹-键盘玩家
     */
    public void myPlaneFireLeft() {
        myPlaneBulletList.add(new Bullet(player.getHeroPlaneList().get(1).getFlyX() + player.getHeroPlaneList().get(1).getFlyW() / 2 - GameConstant.ZIDAN_W / 2, player.getHeroPlaneList().get(1).getFlyY()));
    }

    /**
     * 玩家飞机发射子弹-鼠标玩家
     */
    public void myPlaneFireRight() {
        if (player.getHeroPlaneList().get(0).getFireLevel() == GameConstant.FIRE_LEVEL1) {// 发送一枚子弹 在飞机的中心 飞机x+ w/2 - 子弹/2 这句是中心
            Bullet bullet = new Bullet(player.getHeroPlaneList().get(0).getFlyX() + player.getHeroPlaneList().get(0).getFlyW() / 2 - GameConstant.ZIDAN_W / 2, player.getHeroPlaneList().get(0).getFlyY());
            bullet.setFlyImage(ImageUtils.getHeroBullet());
            myPlaneBulletList.add(bullet);
        } else if (player.getHeroPlaneList().get(0).getFireLevel() == GameConstant.FIRE_LEVEL2) {// 发射三枚子弹 中心加上中心的左方和右方
            Bullet bulletLeft = new Bullet(player.getHeroPlaneList().get(0).getFlyX() + player.getHeroPlaneList().get(0).getFlyW() / 2 - GameConstant.ZIDAN_W * 2, player.getHeroPlaneList().get(0).getFlyY());
            bulletLeft.setBulletMoveType(GameConstant.BULLET_MOVETYPE2);
            bulletLeft.setFlyImage(ImageUtils.getHeroBullet());
            Bullet bullet = new Bullet(player.getHeroPlaneList().get(0).getFlyX() + player.getHeroPlaneList().get(0).getFlyW() / 2 - GameConstant.ZIDAN_W / 2, player.getHeroPlaneList().get(0).getFlyY());
            bullet.setFlyImage(ImageUtils.getHeroBullet());
            Bullet bulletRight = new Bullet(player.getHeroPlaneList().get(0).getFlyX() + player.getHeroPlaneList().get(0).getFlyW() / 2 + GameConstant.ZIDAN_W, player.getHeroPlaneList().get(0).getFlyY());
            bulletRight.setFlyImage(ImageUtils.getHeroBullet());
            bulletRight.setBulletMoveType(GameConstant.BULLET_MOVETYPE3);
            myPlaneBulletList.add(bulletLeft);
            myPlaneBulletList.add(bullet);
            myPlaneBulletList.add(bulletRight);
        } else if (player.getHeroPlaneList().get(0).getFireLevel() == GameConstant.FIRE_LEVEL3) {// 发送核弹  开启自动跟踪
            Bullet bulletLeft = new Bullet(player.getHeroPlaneList().get(0).getFlyX() + player.getHeroPlaneList().get(0).getFlyW() / 2 - GameConstant.ZIDAN_W * 2, player.getHeroPlaneList().get(0).getFlyY());
            bulletLeft.setBulletMoveType(GameConstant.BULLET_MOVETYPE2);
            bulletLeft.setTrack(true);
            bulletLeft.setFlyImage(ImageUtils.getHeroBullet());
            Bullet bullet = new Bullet(player.getHeroPlaneList().get(0).getFlyX() + player.getHeroPlaneList().get(0).getFlyW() / 2 - GameConstant.ZIDAN_W / 2, player.getHeroPlaneList().get(0).getFlyY());
            bullet.setFlyImage(ImageUtils.getHeroBullet());
            Bullet bulletRight = new Bullet(player.getHeroPlaneList().get(0).getFlyX() + player.getHeroPlaneList().get(0).getFlyW() / 2 + GameConstant.ZIDAN_W, player.getHeroPlaneList().get(0).getFlyY());
            bulletRight.setBulletMoveType(GameConstant.BULLET_MOVETYPE3);
            bulletRight.setTrack(true);
            bulletRight.setFlyImage(ImageUtils.getHeroBullet());
            myPlaneBulletList.add(bullet);
            myPlaneBulletList.add(bulletLeft);
            myPlaneBulletList.add(bulletRight);
        }
    }

    /**
     * 敌人炮火
     */
    public void enemyFire() {
        // 敌机飞机发射子弹
        Bullet bullet;
        for (FlyingObj flyingObj : flyingObjectList) {
            if (flyingObj instanceof EnemyPlane) {
                EnemyPlane enemyPlane = (EnemyPlane) flyingObj;
                bullet = new Bullet(enemyPlane.getFlyX() + enemyPlane.getFlyW() / 2 + GameConstant.ZIDAN_W / 2, enemyPlane.getFlyY() + enemyPlane.getFlyH());
                bullet.setBulletMoveType(GameConstant.BULLET_MOVETYPE0);// 设置向下移动
                enemyPlaneBulletList.add(bullet);
            }
        }
    }

    /**
     * boss开火
     */
    public void bossFire() {
        bossBulletList.add(new Bullet(player.getHeroPlaneList().get(0).getFlyX() + player.getHeroPlaneList().get(0).getFlyW() / 2 - GameConstant.ZIDAN_W / 2, player.getHeroPlaneList().get(0).getFlyY()));
    }

    /**
     * 获取随机的 X 坐标
     */
    private int getRandomX() {
        int x = (int) (Math.random() * (GameConstant.GAME_WINDOW_LEFT_WIDTH - GameConstant.Enemy_WIDTH));
         return x;
    }

    /**
     * 爆炸效果爆炸
     */
    public void processExplosions() {
        for (Iterator<FlyingObj> iterator = getboomObjectList().iterator(); iterator.hasNext(); ) {
            FlyingObj flyingObj = iterator.next();
            if (flyingObj instanceof BoomUtils) {
                BoomUtils explosion = (BoomUtils) flyingObj;
                if (!explosion.explosive()) {
                    iterator.remove(); // 移除爆炸效果
                }
            }
        }
    }

    /**
     * 检查敌人被命中
     *
     * @return boolean
     */
    public boolean checkEnemyHit() {
        Iterator<Bullet> myBulletIterator = myPlaneBulletList.iterator();
        while (myBulletIterator.hasNext()) {
            Bullet myBullet = myBulletIterator.next();
            Rectangle bulletBounds = myBullet.getBounds();
            Iterator<FlyingObj> enemyIterator = flyingObjectList.iterator();
            while (enemyIterator.hasNext()) {
                FlyingObj flyingObj = enemyIterator.next();
                if (flyingObj instanceof EnemyPlane) {
                    EnemyPlane enemyPlane = (EnemyPlane) flyingObj;
                    Rectangle enemyBounds = enemyPlane.getBounds();
                    if (bulletBounds.intersects(enemyBounds)) {

                        // 减少敌机生命值
                        int currentHealth = enemyPlane.getHealth();
                        enemyPlane.setHealth(currentHealth - 1);

                        // 处理敌机被击中的逻辑
                        if (currentHealth - 1 <= 0) {
                            // 击毁效果
                            BoomUtils explosion2 = new BoomUtils(enemyPlane.getFlyX(), enemyPlane.getFlyY(), GameConstant.ENEMYPLANE_OVER);
                            boomObjectList.add(explosion2);
                            enemyIterator.remove();
                            rightJPanel.setScore(rightJPanel.getScore() + 100);
                            int flyType = enemyPlane.getFlyType();
                            if (flyType == GameConstant.Enemy_TYPE1) {
                                rightJPanel.setBasicEnemyNums(rightJPanel.getBasicEnemyNums() - 1);// 敌机lv1数量

                            } else if (flyType == GameConstant.Enemy_TYPE2) {
                                rightJPanel.setIntermediateEnemyNums(rightJPanel.getIntermediateEnemyNums() - 1);// 敌机lv2数量
                            }
                        } else {
                            BoomUtils explosion = new BoomUtils(enemyPlane.getFlyX(), enemyPlane.getFlyY(), GameConstant.ZIDANTO_ENEMYPLANE);
                            boomObjectList.add(explosion);
                        }
                        myBulletIterator.remove(); // 移除我方飞机的子弹
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * 检查BOSS被命中
     *
     * @return boolean
     */
    public boolean checkBossHit() {
        Iterator<Bullet> myBulletIterator = myPlaneBulletList.iterator();
        while (myBulletIterator.hasNext()) {
            Bullet myBullet = myBulletIterator.next();
            Rectangle bulletBounds = myBullet.getBounds();
            Iterator<FlyingObj> enemyIterator = flyingObjectList.iterator();
            while (enemyIterator.hasNext()) {
                FlyingObj flyingObj = enemyIterator.next();
                if (flyingObj instanceof BossPlane) {
                    BossPlane boosPlane = (BossPlane) flyingObj;
                    Rectangle bossBounds = boosPlane.getBounds();
                    if (bulletBounds.intersects(bossBounds)) {

                        // 减少敌机生命值
                        int currentHealth = boosPlane.getHealth();
                        boosPlane.setHealth(currentHealth - 1);

                        // 处理敌机被击中的逻辑
                        if (currentHealth - 1 <= 0) {
                            // System.out.println("敌机已被击毁");
                            // 击毁效果
                            MusicUtils.startBossOverMusicThread();
                            BoomUtils explosion2 = new BoomUtils(boosPlane.getFlyX(), boosPlane.getFlyY(), GameConstant.ENEMYPLANE_OVER);
                            boomObjectList.add(explosion2);
                            enemyIterator.remove();
                            rightJPanel.setScore(rightJPanel.getScore() + boosPlane.getHealth() * 100);
                            rightJPanel.setBossEnemyNums(rightJPanel.getBossEnemyNums()-1);
                            // todo 临时切换第二关 后续更改
                            GameConfig.initLv2();
                            GameConfig.setBackImage(ImageUtils.getBgImage2());
                            startGame();
                            System.out.println("切换了第二关");
                        } else {
                            BoomUtils explosion = new BoomUtils(boosPlane.getFlyX(), boosPlane.getFlyY(), GameConstant.ZIDANTO_ENEMYPLANE);
                            boomObjectList.add(explosion);
                        }
                        myBulletIterator.remove(); // 移除我方飞机的子弹
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * 检查我方飞机被命中
     *
     * @return boolean
     */
    public boolean checkMyPlaneHit() {
        Rectangle myPlaneBounds = heroPlaneList.get(0).getBounds();
        HeroPlane heroPlane = heroPlaneList.get(0);
        Iterator<Bullet> iterator = enemyPlaneBulletList.iterator();
        int currentHealth;
        while (iterator.hasNext()) {
            Bullet enemyBullet = iterator.next();
            Rectangle bulletBounds = enemyBullet.getBounds();
            if (myPlaneBounds.intersects(bulletBounds)) {
                System.out.println("我方飞机被击中！");
                // 减少生命值
                currentHealth = heroPlane.getHealth();
                heroPlane.setHealth(currentHealth - 1);
                rightJPanel.setHealth(currentHealth);
                if (currentHealth - 1 <= 0) {
                    System.out.println("游戏结束！");
                    // 爆炸效果
                    MusicUtils.startGameOverMusicThread();
                    BoomUtils explosion = new BoomUtils(heroPlane.getFlyX(), heroPlane.getFlyY(), GameConstant.HEREOPLANE_OVER);
                    boomObjectList.add(explosion);
                    // todo 游戏结束
                } else {
                    // 爆炸效果
                    BoomUtils explosion = new BoomUtils(heroPlane.getFlyX(), heroPlane.getFlyY(), GameConstant.ZIDANTO_HEREOPLANE);
                    boomObjectList.add(explosion);
                }
                iterator.remove(); // 移除子弹
                return true;
            }
        }
        return false;
    }

    /**
     * 检查我子弹击中敌人子弹
     *
     * @return boolean
     */
    public boolean checkMyBulletHitEnemyBullet() {
        Iterator<Bullet> myBulletIterator = myPlaneBulletList.iterator();
        while (myBulletIterator.hasNext()) {
            Bullet myBullet = myBulletIterator.next();
            Rectangle myBulletBounds = myBullet.getBounds();
            Iterator<Bullet> enemyBulletIterator = enemyPlaneBulletList.iterator();
            while (enemyBulletIterator.hasNext()) {
                Bullet enemyBullet = enemyBulletIterator.next();
                Rectangle enemyBulletBounds = enemyBullet.getBounds();
                if (myBulletBounds.intersects(enemyBulletBounds)) {
                    myBulletIterator.remove(); // 移除我方子弹
                    enemyBulletIterator.remove(); // 移除敌方子弹
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 检查我飞机碰撞
     *
     * @return boolean
     */
    public boolean checkMyPlaneCollisions() {
        HeroPlane myPlane = heroPlaneList.get(0);
        Rectangle myPlaneBounds = myPlane.getBounds();
        boolean collisionOccurred = false;
        // 检测与小蜜蜂的碰撞
        Iterator<FlyingObj> iterator = flyingObjectList.iterator();
        while (iterator.hasNext()) {
            FlyingObj flyingObj = iterator.next();
            if (flyingObj instanceof Bee) {
                Bee bee = (Bee) flyingObj;
                Rectangle beeBounds = bee.getBounds();
                if (myPlaneBounds.intersects(beeBounds)) {
                    rightJPanel.setHealth(rightJPanel.getHealth() + 1);
                    iterator.remove(); // 移除小蜜蜂
                    collisionOccurred = true;
                }
            }
        }

        // 检测与双倍火力奖励的碰撞
        iterator = flyingObjectList.iterator();
        while (iterator.hasNext()) {
            FlyingObj flyingObj = iterator.next();
            if (flyingObj instanceof DoubleFirePower) {
                DoubleFirePower doubleFirePower = (DoubleFirePower) flyingObj;
                Rectangle doubleFirePowerBounds = doubleFirePower.getBounds();
                if (myPlaneBounds.intersects(doubleFirePowerBounds)) {

                    if (myPlane.getFireLevel() < 3) {// 设置双倍火力的等级
                        myPlane.setFireLevel(myPlane.getFireLevel() + 1);
                    }
                    iterator.remove(); // 移除双倍火力
                    collisionOccurred = true;
                }
            }
        }

        // 检测与核弹奖励的碰撞
        iterator = flyingObjectList.iterator();
        while (iterator.hasNext()) {
            FlyingObj flyingObj = iterator.next();
            if (flyingObj instanceof NuclearBomb) {
                NuclearBomb nuclearBomb = (NuclearBomb) flyingObj;
                Rectangle nuclearBombBounds = nuclearBomb.getBounds();
                if (myPlaneBounds.intersects(nuclearBombBounds)) {
                    // 碰撞后
                    rightJPanel.setBomb(rightJPanel.getBomb() + 1);
                    iterator.remove(); // 移除核弹
                    collisionOccurred = true;
                }
            }
        }

        return collisionOccurred;
    }


    /////////////////////////////////////get、set
    public List<FlyingObj> getboomObjectList() {
        return boomObjectList;
    }

    public void setboomObjectList(List<FlyingObj> boomObjectList) {
        this.boomObjectList = boomObjectList;
    }

    public UI getUi() {
        return ui;
    }

    public void setUi(UI ui) {
        this.ui = ui;
    }

    public BackGround getBackGround1() {
        return backGround1;
    }

    public void setBackGround1(BackGround backGround1) {
        this.backGround1 = backGround1;
    }

    public BackGround getBackGround2() {
        return backGround2;
    }

    public void setBackGround2(BackGround backGround2) {
        this.backGround2 = backGround2;
    }

    public BackGroundTime getBackGroundTime() {
        return backGroundTime;
    }

    public void setBackGroundTime(BackGroundTime backGroundTime) {
        this.backGroundTime = backGroundTime;
    }

    public FlyObjTime getFlyObjTime() {
        return flyObjTime;
    }

    public void setFlyObjTime(FlyObjTime flyObjTime) {
        this.flyObjTime = flyObjTime;
    }


    public boolean isAllowMovement() {
        return allowMovement;
    }

    public void setAllowMovement(boolean allowMovement) {
        this.allowMovement = allowMovement;
    }

    public List<FlyingObj> getflyingObjectList() {
        return flyingObjectList;
    }

    public void setflyingObjectList(List<FlyingObj> flyingObjectList) {
        this.flyingObjectList = flyingObjectList;
    }

    public List<Bullet> getmyPlaneBulletList() {
        return myPlaneBulletList;
    }

    public List<HeroPlane> getHeroPlaneList() {
        return heroPlaneList;
    }

    public void setHeroPlaneList(List<HeroPlane> heroPlaneList) {
        this.heroPlaneList = heroPlaneList;
    }

    public void setmyPlaneBulletList(List<Bullet> myPlaneBulletList) {
        this.myPlaneBulletList = myPlaneBulletList;
    }

    public List<Bullet> getenemyPlaneBulletList() {
        return enemyPlaneBulletList;
    }

    public void setenemyPlaneBulletList(List<Bullet> enemyPlaneBulletList) {
        this.enemyPlaneBulletList = enemyPlaneBulletList;
    }

    public List<FlyingObj> getCleanList() {
        return cleanList;
    }

    public void setCleanList(List<FlyingObj> cleanList) {
        this.cleanList = cleanList;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Radar getRadar() {
        return radar;
    }

    public void setRadar(Radar radar) {
        this.radar = radar;
    }

    public RightJPanel getRightJPanel() {
        return rightJPanel;
    }

    public void setRightJPanel(RightJPanel rightJPanel) {
        this.rightJPanel = rightJPanel;
    }
}
