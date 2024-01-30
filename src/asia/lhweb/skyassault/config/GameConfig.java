package asia.lhweb.skyassault.config;

import asia.lhweb.skyassault.Util.ImageUtils;
import asia.lhweb.skyassault.View.RightJPanel;
import asia.lhweb.skyassault.constant.GameConstant;
import asia.lhweb.skyassault.controller.PlaneController;
import asia.lhweb.skyassault.model.bean.fly.FlyingObj;

import java.awt.*;
import java.util.List;

/**
 * 游戏配置类（单例模式）
 * 包含英雄速度等游戏相关配置
 *
 * @author 罗汉
 * @date 2024/1/29
 */
public class GameConfig {
    private static int heroSpeed;// 英雄机飞行速度
    private static int heroHealth;// 英雄机最高生命值
    private static int EnemyHealth;// 敌机最高生命值
    private static Image bossImg;// boss图图片
    private static Image heroImg;// 英雄机图片
    private static Image enemyImgLv1;// 初级敌机图片
    private static Image enemyImgLv2;// 中级敌机图片
    private static Image backImage;// 背景图
    private static int gameLv;// 关卡等级
    private static Boolean setBgMusic=true;// 背景音乐是否开启
    private static String bgMusic;// 背景音乐
    private static Boolean setEffectMusic;// 特效音乐：子弹特效、击毁特效
    ///////////////////////////////////////////
    private static String addLife;//吃到生命值
    private static String reborn;//吃到奖励物
    private static String fire;//开火
    private static String enemyBoom;//敌机坠毁
    private static String gameOver;//游戏结束
    private static String bossBoom;//游戏结束
    private static GameConfig instance;
    /**
     * 默认通用初始化
     */
    private static void initDefault() {
        //音乐类
        setBgMusic=true;
        bgMusic= GameConstant.MUSIC_BG;
        addLife=GameConstant.MUSIC_ADD_LIFE;
        reborn=GameConstant.MUSIC_REBORN;
        fire=GameConstant.MUSIC_FIRE;
        enemyBoom=GameConstant.MUSIC_ENEMY_BOOM;
        gameOver=GameConstant.MUSIC_GAME_OVER;
        bossBoom=GameConstant.MUSIC_BOSS_BOOM;

    }

    private GameConfig() {

    }

    public static void initLv1() {
        //todo 设置boss血量
        initDefault();
        //数值类
        gameLv = 1;
        heroSpeed = 10;
        heroHealth = 3;
        EnemyHealth = 1;
        //图片类
        bossImg = ImageUtils.getBossPlaneImage1();
        enemyImgLv1 = ImageUtils.getEnemyPlaneImage1Lv1();
        enemyImgLv2 = ImageUtils.getEnemyPlaneImage1Lv2();
        heroImg = ImageUtils.getMyPlaneImage1();
        backImage = ImageUtils.getBGImage1();
        

    }



    public static void initLv2() {
        initDefault();
        gameLv = 2;
        heroSpeed = 10;
        heroHealth = 3;
        EnemyHealth = 3;
        bossImg = ImageUtils.getBossPlaneImage1();
        enemyImgLv1 = ImageUtils.getEnemyPlaneImage2Lv1();
        enemyImgLv2 = ImageUtils.getEnemyPlaneImage2Lv2();
        heroImg = ImageUtils.getMyPlaneImage1();
        backImage = ImageUtils.getBgImage2();
    }

    public static void initLv3() {
        initDefault();
        gameLv = 3;

    }

    public static GameConfig instance() {
        if (instance == null) {
            instance = new GameConfig();
        }
        return instance;
    }

    /**
     * 开始游戏数据初始化
     *
     * @param planeController 飞机控制器
     */
    public static void startGame(PlaneController planeController) {
        List<FlyingObj> flyingObjs = planeController.getflyingObjectList();// 得到飞行物列表
        for (FlyingObj flyingObj : flyingObjs) {

        }
        RightJPanel rightJPanel = planeController.getRightJPanel();// 得到右侧面板数据
        rightJPanel.setHealth(GameConfig.getHeroHealth());// 初始化生命值
        rightJPanel.setLevel(GameConfig.getGameLv());// 初始化关卡等级
    }

    public static int getHeroHealth() {
        return heroHealth;
    }

    public static void setHeroHealth(int heroHealth) {
        GameConfig.heroHealth = heroHealth;
    }

    public static int getHeroSpeed() {
        return heroSpeed;
    }

    public static void setHeroSpeed(int heroSpeed) {
        GameConfig.heroSpeed = heroSpeed;
    }

    public static Image getBossImg() {
        return bossImg;
    }

    public static void setBossImg(Image bossImg) {
        GameConfig.bossImg = bossImg;
    }

    public static int getGameLv() {
        return gameLv;
    }

    public static void setGameLv(int gameLv) {
        GameConfig.gameLv = gameLv;
    }

    public static int getEnemyHealth() {
        return EnemyHealth;
    }

    public static void setEnemyHealth(int enemyHealth) {
        EnemyHealth = enemyHealth;
    }

    public static Image getHeroImg() {
        return heroImg;
    }

    public static void setHeroImg(Image heroImg) {
        GameConfig.heroImg = heroImg;
    }

    public static GameConfig getInstance() {
        return instance;
    }

    public static void setInstance(GameConfig instance) {
        GameConfig.instance = instance;
    }

    public static Image getBackImage() {
        return backImage;
    }

    public static void setBackImage(Image backImage) {
        GameConfig.backImage = backImage;
    }

    public static Boolean getSetBgMusic() {
        return setBgMusic;
    }

    public static void setSetBgMusic(Boolean setBgMusic) {
        GameConfig.setBgMusic = setBgMusic;
    }

    public static Boolean getSetEffectMusic() {
        return setEffectMusic;
    }

    public static void setSetEffectMusic(Boolean setEffectMusic) {
        GameConfig.setEffectMusic = setEffectMusic;
    }

    public static String getBgMusic() {
        return bgMusic;
    }

    public static void setBgMusic(String bgMusic) {
        GameConfig.bgMusic = bgMusic;
    }

    public static Image getEnemyImgLv1() {
        return enemyImgLv1;
    }

    public static void setEnemyImgLv1(Image enemyImgLv1) {
        GameConfig.enemyImgLv1 = enemyImgLv1;
    }

    public static Image getEnemyImgLv2() {
        return enemyImgLv2;
    }

    public static void setEnemyImgLv2(Image enemyImgLv2) {
        GameConfig.enemyImgLv2 = enemyImgLv2;
    }

    public static String getAddLife() {
        return addLife;
    }

    public static String getReborn() {
        return reborn;
    }

    public static String getFire() {
        return fire;
    }

    public static String getEnemyBoom() {
        return enemyBoom;
    }

    public static String getGameOver() {
        return gameOver;
    }

    public static String getBossBoom() {
        return bossBoom;
    }
}
