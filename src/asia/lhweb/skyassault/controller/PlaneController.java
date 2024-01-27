package asia.lhweb.skyassault.controller;

import asia.lhweb.skyassault.Util.BoomUtils;
import asia.lhweb.skyassault.View.UI;
import asia.lhweb.skyassault.constant.GameConstant;
import asia.lhweb.skyassault.controller.time.BackGroundTime;
import asia.lhweb.skyassault.controller.time.FlyObjTime;
import asia.lhweb.skyassault.dao.EnemyPlaneFactory;
import asia.lhweb.skyassault.model.bean.*;

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
public class PlaneController{
    private UI ui;
    private BackGround backGround1;
    private BackGround backGround2;
    private BackGroundTime backGroundTime;
    private FlyObjTime flyObjTime;
    private Player player;
    private boolean gamePaused = false;//是否暂停游戏
    private boolean allowMovement = false;//是否鼠标移动
    private List<FlyingObj> flyingObjects; // 存储所有飞行物 敌机、奖励物
    private List<FlyingObj> boomObjects=new ArrayList<>(); // 存储爆炸效果
    private List<Bullet> myPlaneBullets=new ArrayList<>();//英雄飞机子弹
    private List<Bullet> myPlaneRemoveBullets=new ArrayList<>();//英雄飞机子弹销毁池
    private List<Bullet> enemyPlaneBullets=new ArrayList<>();//敌机子弹
    private List<Bullet> enemyPlaneRemoveBullets=new ArrayList<>();//敌机子弹销毁池

    public PlaneController() {
        backGround1=new BackGround();
        backGround2=new BackGround();
        flyingObjects=new ArrayList<>();
        player=new Player();
        backGround2.setBackY(-GameConstant.GAME_WINDOW_HEIGHT);
        backGroundTime=new BackGroundTime(this);
        flyObjTime=new FlyObjTime(this);
        ui=new UI(this);
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    /**
     * 开始游戏
     */
    public void startGame() {
        generateRandomFlyingObject();
        setAllowMovement(true);
        getUi().getGameJFrame().getGameJPanel().setListener();
        backGroundTime.startTimer();
        flyObjTime.startTimer();
    }

    /**
     * 暂停游戏
     */
    public void pauseGame() {
        if (gamePaused) {
            // 如果游戏已经暂停，恢复游戏
            backGroundTime.resumeTimer();
            flyObjTime.resumeTimer();
            allowMovement=true; // 允许鼠标移动
            gamePaused = false;
        } else {
            // 如果游戏未暂停，暂停游戏
            backGroundTime.pauseTimer();
            flyObjTime.pauseTimer();
            allowMovement=false; // 禁止鼠标移动
            gamePaused = true;
        }
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
        double random;
        FlyingObj flyingObj;

        for (int i = 0; i < 20; i++) {
            random = Math.random();

            // 计算y轴偏移量
            int yOffset = (i == 0) ? 0 : -i * 150; // 这里的50可以根据实际情况调整

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
            flyingObjects.add(flyingObj);
        }
    }


    /**
     * 获取随机的 X 坐标
     */
    private int getRandomX() {
        int x = (int) (Math.random() * GameConstant.GAME_WINDOW_LEFT_WIDTH);
        return x;
    }
    /**
     * 检查敌人命中
     *
     * @return boolean
     */
    public boolean checkEnemyHit() {
        Iterator<Bullet> myBulletIterator = myPlaneBullets.iterator();
        while (myBulletIterator.hasNext()) {
            Bullet myBullet = myBulletIterator.next();
            Rectangle bulletBounds = myBullet.getBounds();
            Iterator<FlyingObj> enemyIterator = flyingObjects.iterator();
            while (enemyIterator.hasNext()) {
                FlyingObj flyingObj = enemyIterator.next();
                if (flyingObj instanceof EnemyPlane) {
                    EnemyPlane enemyPlane = (EnemyPlane) flyingObj;
                    Rectangle enemyBounds = enemyPlane.getBounds();
                    if (bulletBounds.intersects(enemyBounds)) {
                        System.out.println("敌机被击中！");
                        //设置子弹击中爆炸效果
                        BoomUtils explosion = new BoomUtils(enemyPlane.getFlyX(), enemyPlane.getFlyY(), GameConstant.ZIDANTO_ENEMYPLANE);
                        boomObjects.add(explosion);

                        // 减少敌机生命值
                        int currentHealth = enemyPlane.getHealth();
                        enemyPlane.setHealth(currentHealth - 1);


                        // 处理敌机被击中的逻辑
                        if (currentHealth - 1 <= 0) {
                            System.out.println("敌机已被击毁");
                            enemyIterator.remove(); // 移除敌机
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
     * 检查我方飞机命中
     *
     * @return boolean
     */
    public boolean checkMyPlaneHit() {
        Rectangle myPlaneBounds = getPlayer().getHeroPlane().getBounds();
        Iterator<Bullet> iterator = enemyPlaneBullets.iterator();
        int currentHealth;
        while (iterator.hasNext()) {
            Bullet enemyBullet = iterator.next();
            Rectangle bulletBounds = enemyBullet.getBounds();
            if (myPlaneBounds.intersects(bulletBounds)) {
                System.out.println("我方飞机被击中！");
                // 减少生命值
                currentHealth = getPlayer().getHeroPlane().getHealth();
                getPlayer().getHeroPlane().setHealth(currentHealth - 1);
                if (currentHealth - 1 <= 0) {
                    System.out.println("游戏结束！");
                }

                iterator.remove(); // 移除子弹
                return true;
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
        HeroPlane myPlane =player.getHeroPlane();
        Rectangle myPlaneBounds = myPlane.getBounds();
        boolean collisionOccurred = false;
        // 检测与小蜜蜂的碰撞
        Iterator<FlyingObj> iterator = flyingObjects.iterator();
        while (iterator.hasNext()) {
            FlyingObj flyingObj = iterator.next();
            if (flyingObj instanceof Bee) {
                Bee bee = (Bee) flyingObj;
                Rectangle beeBounds = bee.getBounds();
                if (myPlaneBounds.intersects(beeBounds)) {
                    System.out.println("与小蜜蜂碰撞！");
                    iterator.remove(); // 移除小蜜蜂
                    collisionOccurred = true;
                }
            }
        }

        // 检测与双倍火力奖励的碰撞
        iterator = flyingObjects.iterator();
        while (iterator.hasNext()) {
            FlyingObj flyingObj = iterator.next();
            if (flyingObj instanceof DoubleFirePower) {
                DoubleFirePower doubleFirePower = (DoubleFirePower) flyingObj;
                Rectangle doubleFirePowerBounds = doubleFirePower.getBounds();
                if (myPlaneBounds.intersects(doubleFirePowerBounds)) {
                    // 处理与双倍火力奖励的碰撞逻辑，例如增加火力等
                    System.out.println("与双倍火力奖励碰撞！");
                    iterator.remove(); // 移除双倍火力奖励
                    collisionOccurred = true;
                }
            }
        }

        // 检测与核弹奖励的碰撞
        iterator = flyingObjects.iterator();
        while (iterator.hasNext()) {
            FlyingObj flyingObj = iterator.next();
            if (flyingObj instanceof NuclearBomb) {
                NuclearBomb nuclearBomb = (NuclearBomb) flyingObj;
                Rectangle nuclearBombBounds = nuclearBomb.getBounds();
                if (myPlaneBounds.intersects(nuclearBombBounds)) {
                    // 处理与核弹奖励的碰撞逻辑，例如使用核弹等
                    System.out.println("与核弹奖励碰撞！");
                    iterator.remove(); // 移除核弹奖励
                    collisionOccurred = true;
                }
            }
        }

        return collisionOccurred;
    }

    public List<FlyingObj> getBoomObjects() {
        return boomObjects;
    }

    public void setBoomObjects(List<FlyingObj> boomObjects) {
        this.boomObjects = boomObjects;
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

    public boolean isGamePaused() {
        return gamePaused;
    }

    public void setGamePaused(boolean gamePaused) {
        this.gamePaused = gamePaused;
    }

    public boolean isAllowMovement() {
        return allowMovement;
    }

    public void setAllowMovement(boolean allowMovement) {
        this.allowMovement = allowMovement;
    }

    public List<FlyingObj> getFlyingObjects() {
        return flyingObjects;
    }

    public void setFlyingObjects(List<FlyingObj> flyingObjects) {
        this.flyingObjects = flyingObjects;
    }

    public List<Bullet> getMyPlaneBullets() {
        return myPlaneBullets;
    }

    public void setMyPlaneBullets(List<Bullet> myPlaneBullets) {
        this.myPlaneBullets = myPlaneBullets;
    }

    public List<Bullet> getMyPlaneRemoveBullets() {
        return myPlaneRemoveBullets;
    }

    public void setMyPlaneRemoveBullets(List<Bullet> myPlaneRemoveBullets) {
        this.myPlaneRemoveBullets = myPlaneRemoveBullets;
    }

    public List<Bullet> getEnemyPlaneBullets() {
        return enemyPlaneBullets;
    }

    public void setEnemyPlaneBullets(List<Bullet> enemyPlaneBullets) {
        this.enemyPlaneBullets = enemyPlaneBullets;
    }

    public List<Bullet> getEnemyPlaneRemoveBullets() {
        return enemyPlaneRemoveBullets;
    }

    public void setEnemyPlaneRemoveBullets(List<Bullet> enemyPlaneRemoveBullets) {
        this.enemyPlaneRemoveBullets = enemyPlaneRemoveBullets;
    }
}
