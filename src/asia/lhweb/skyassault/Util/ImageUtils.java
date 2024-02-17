package asia.lhweb.skyassault.Util;

import asia.lhweb.skyassault.constant.GameConstant;

import javax.swing.*;
import java.awt.*;

/**
 * 图像工具类
 *
 * @author 罗汉
 * @date 2024/02/02
 */
public class ImageUtils {
    public static Image bgImage;// 背景
    public static Image bgImage2;// 背景2
    public static Image zhuTi;// 背景2
    public static Image bgStartImage;// 游戏就绪背景
    public static Image bgPauseImage;// 游戏就绪背景
    public static Image bgVictoryImage;// 游戏胜利背景
    public static Image planeImage1;// 飞机图像 开火
    public static Image planeImage2;// 飞机图像 不开火
    public static Image heroBullet;//子弹1
    public static Image enemyBullet;//子弹2
    public static Image zhuiZhongBullet1;//子弹3 自动跟踪
    public static Image zhuiZhongBullet2;//子弹4 自动跟踪
    public static Image enemyPlaneImage1Lv1;// 敌机图像
    public static Image enemyPlaneImage1Lv2;// 敌机图像
    public static Image enemyPlaneImage2Lv1;// 敌机图像
    public static Image enemyPlaneImage2Lv2;// 敌机图像
    public static Image enemyPlaneImage3Lv1;// 敌机图像
    public static Image enemyPlaneImage3Lv2;// 敌机图像
    public static Image bossPlaneImage1;// boss图像
    public static Image bossPlaneImage2;// boss图像
    public static Image bossPlaneImage3;// boss图像
    public static Image beeImage;// 蜜蜂
    public static Image doubleFirePowerImage;// 双倍火力图像
    public static Image nuclearBombImage;// 核弹图像1
    public static Image gameBgR;// 核弹图像1
    public static Image[] defaultBoomImages;// 默认爆炸图像数组
    public static Image[] enemyOverBooms;// 敌机摧毁爆炸图像数组
    public static Image[] heroOverBOOMS;// 英雄机被摧毁爆炸图像数组
    public static Image[] nuclearBooms;// 英雄机被摧毁爆炸图像数组
    public static Image[] radarImages;// 雷达图数组

    public ImageUtils() {
    }

    public static void init() {
        // 初始化背景图像
        bgImage = new ImageIcon(GameConstant.GAME_BG1).getImage();
        bgImage2 = new ImageIcon(GameConstant.GAME_BG2).getImage();
        bgPauseImage = new ImageIcon(GameConstant.GAME_BG_PAUSE).getImage();
        bgStartImage = new ImageIcon(GameConstant.GAME_BG_START).getImage();
        bgVictoryImage = new ImageIcon(GameConstant.BG_VICTORY_IMAGE).getImage();
        zhuTi = new ImageIcon(GameConstant.ZHU_TI).getImage();

        // 初始化飞机图像
        planeImage1 = new ImageIcon(GameConstant.HERO1).getImage();
        planeImage2 = new ImageIcon(GameConstant.HERO1_0).getImage();
        // 初始化全部关卡敌机图像
        enemyPlaneImage1Lv1 = new ImageIcon(GameConstant.ENEMY_PLANE1LV1).getImage();
        enemyPlaneImage1Lv2 = new ImageIcon(GameConstant.ENEMY_PLANE1LV2).getImage();
        enemyPlaneImage2Lv1 = new ImageIcon(GameConstant.ENEMY_PLANE2LV1).getImage();
        enemyPlaneImage2Lv2 = new ImageIcon(GameConstant.ENEMY_PLANE2LV2).getImage();
        enemyPlaneImage3Lv1 = new ImageIcon(GameConstant.ENEMY_PLANE3LV1).getImage();
        enemyPlaneImage3Lv2 = new ImageIcon(GameConstant.ENEMY_PLANE3LV2).getImage();

        // 初始化蜜蜂图像
        beeImage = new ImageIcon(GameConstant.BEE1).getImage();
        //初始化子弹
        heroBullet=new ImageIcon(GameConstant.HERO_BULLET).getImage();
        enemyBullet=new ImageIcon(GameConstant.ENEMY_BULLET).getImage();
        zhuiZhongBullet1=new ImageIcon(GameConstant.ZHUIZHONG_BULLET1).getImage();
        zhuiZhongBullet2=new ImageIcon(GameConstant.ZHUIZHONG_BULLET2).getImage();
        // 初始化Boss飞机图像
        bossPlaneImage1 = new ImageIcon(GameConstant.BOSS_PLANE1).getImage();
        bossPlaneImage2 = new ImageIcon(GameConstant.BOSS_PLANE2).getImage();
        bossPlaneImage3 = new ImageIcon(GameConstant.BOSS_PLANE3).getImage();
        // 初始化核弹图像
        nuclearBombImage = new ImageIcon(GameConstant.NUCLEAR_BOMB_IMAGE).getImage();
        // 初始化双倍火力图像
        doubleFirePowerImage = new ImageIcon(GameConstant.DOUBLE_FIREPOWER_IMAGE).getImage();
        gameBgR = new ImageIcon(GameConstant.GAME_BGR).getImage();
        //////////////////////////////////////////////数组初始化
        // 初始化默认爆炸图像数组
        defaultBoomImages = initBoomImages(GameConstant.DEFAULT_BOOMS);

        // 初始化雷达图数组
        radarImages = initBoomImages(GameConstant.RADAR_IMAGES);

        // 初始化敌机坠毁数组
        enemyOverBooms = initBoomImages(GameConstant.ENEMY_OVER_BOOMS);

        // 初始化英雄机坠毁数组
        heroOverBOOMS = initBoomImages(GameConstant.HERO_OVER_BOOMS);

        //初始化核弹爆炸数组
        nuclearBooms = initBoomImages(GameConstant.NUCLEAR_OVER_BOOMS);
    }

    /**
     * 初始爆炸图像
     *
     * @param imagePaths 图片路径
     * @return {@link Image[]}
     */
    public static Image[] initBoomImages(String[] imagePaths) {
        Image[] images = new Image[imagePaths.length];
        for (int i = 0; i < imagePaths.length; i++) {
            images[i] = new ImageIcon(imagePaths[i]).getImage();
        }
        return images;
    }

    public static Image[] getHeroOverBOOMS() {
        return heroOverBOOMS;
    }

    public static Image[] getEnemyOverBooms() {
        return enemyOverBooms;
    }

    /**
     * 获取雷达图数组
     *
     * @return {@link Image[]}
     */
    public static Image[] getRadarImages() {
        return radarImages;
    }

    /**
     * 得到背景图片
     *
     * @return {@link Image}
     */
    public static Image getBGImage1() {
        return bgImage;
    }

    /**
     * 得到英雄机喷火
     *
     * @return {@link Image}
     */
    public static Image getMyPlaneImage1() {
        return planeImage1;
    }

    /**
     * 得到英雄机不喷火
     *
     * @return {@link Image}
     */
    public static Image getMyPlaneImage1_0() {
        return planeImage2;
    }


    /**
     * 获取蜜蜂图像
     *
     * @return {@link Image}
     */
    public static Image getBeeImage1() {
        return beeImage;
    }

    /**
     * 获取核弹图像
     *
     * @return {@link Image}
     */
    public static Image getNuclearBombImage() {
        return nuclearBombImage;
    }

    /**
     * 获得双倍火力图像
     *
     * @return {@link Image}
     */
    public static Image getDoubleFirePowerImage() {
        return doubleFirePowerImage;
    }

    public static Image[] getDefaultBoomImages() {
        return defaultBoomImages;
    }

    public static Image getGameBgR() {
        return gameBgR;
    }


    public static Image getBossPlaneImage1() {
        return bossPlaneImage1;
    }


    public static Image getBossPlaneImage2() {
        return bossPlaneImage2;
    }


    public static Image getBossPlaneImage3() {
        return bossPlaneImage3;
    }


    public static Image getBgImage() {
        return bgImage;
    }


    public static Image getBgImage2() {
        return bgImage2;
    }


    public static Image getPlaneImage1() {
        return planeImage1;
    }


    public static Image getPlaneImage2() {
        return planeImage2;
    }

    public static Image getBeeImage() {
        return beeImage;
    }

    public static Image getEnemyPlaneImage1Lv1() {
        return enemyPlaneImage1Lv1;
    }

    public static Image getEnemyPlaneImage1Lv2() {
        return enemyPlaneImage1Lv2;
    }

    public static Image getEnemyPlaneImage2Lv1() {
        return enemyPlaneImage2Lv1;
    }

    public static Image getEnemyPlaneImage2Lv2() {
        return enemyPlaneImage2Lv2;
    }

    public static Image getEnemyPlaneImage3Lv1() {
        return enemyPlaneImage3Lv1;
    }

    public static Image getEnemyPlaneImage3Lv2() {
        return enemyPlaneImage3Lv2;
    }

    public static Image getHeroBullet() {
        return heroBullet;
    }

    public static Image getEnemyBullet() {
        return enemyBullet;
    }

    public static Image getBgStartImage() {
        return bgStartImage;
    }

    public static void setBgStartImage(Image bgStartImage) {
        ImageUtils.bgStartImage = bgStartImage;
    }

    public static Image getBgPauseImage() {
        return bgPauseImage;
    }

    public static void setBgPauseImage(Image bgPauseImage) {
        ImageUtils.bgPauseImage = bgPauseImage;
    }

    public static Image getZhuTi() {
        return zhuTi;
    }

    public static Image getZhuiZhongBullet1() {
        return zhuiZhongBullet1;
    }

    public static Image getZhuiZhongBullet2() {
        return zhuiZhongBullet2;
    }

    public static Image[] getNuclearBooms() {
        return nuclearBooms;
    }

    public static Image getBgVictoryImage() {
        return bgVictoryImage;
    }
}
