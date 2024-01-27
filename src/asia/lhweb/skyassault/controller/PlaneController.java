package asia.lhweb.skyassault.controller;

import asia.lhweb.skyassault.View.UI;
import asia.lhweb.skyassault.constant.GameConstant;
import asia.lhweb.skyassault.controller.time.BackGroundTime;
import asia.lhweb.skyassault.controller.time.FlyObjTime;
import asia.lhweb.skyassault.dao.EnemyPlaneFactory;
import asia.lhweb.skyassault.model.bean.BackGround;
import asia.lhweb.skyassault.model.bean.FlyingObj;
import asia.lhweb.skyassault.model.bean.Player;

import java.util.ArrayList;
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
    private List<FlyingObj> flyingObjects; // 存储所有飞行物
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

    public List<FlyingObj> getFlyingObjects() {
        return flyingObjects;
    }

    public void setFlyingObjects(List<FlyingObj> flyingObjects) {
        this.flyingObjects = flyingObjects;
    }

    public UI getUi() {
        return ui;
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


}
