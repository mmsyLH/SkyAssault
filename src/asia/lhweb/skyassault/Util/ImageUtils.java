package asia.lhweb.skyassault.Util;

import asia.lhweb.skyassault.constant.GameConstant;

import javax.swing.*;
import java.awt.*;

public class ImageUtils {
    public static Image bgImage;//背景
    public static Image planeImage1;//飞机图像 开火
    public static Image planeImage2;//飞机图像 不开火
    public static Image enemyPlaneImage;//敌机图像
    public static Image beeImage;//蜜蜂
    public static Image doubleFirePowerImage;//双倍火力图像
    public static Image nuclearBombImage;//核弹图像1
    public static Image planeBoomImage1;//爆炸图像1
    public static Image planeBoomImage2;//爆炸图像2
    public static Image planeBoomImage3;//爆炸图像3
    public static Image planeBoomImage4;//爆炸图像4
    public static Image planeBoomImage5;//爆炸图像5

    public static Image[] radarImages;// 雷达图数组

    public ImageUtils() {
    }
    public static void init() {
        // 初始化背景图像
        bgImage = new ImageIcon(GameConstant.GAME_BG1).getImage();
        // 初始化飞机图像
        planeImage1 = new ImageIcon(GameConstant.HERO1).getImage();
        planeImage2 = new ImageIcon(GameConstant.HERO1_0).getImage();
        // 初始化敌机图像
        enemyPlaneImage = new ImageIcon(GameConstant.ENEMY_PLANE1).getImage();
        // 初始化蜜蜂图像
        beeImage = new ImageIcon(GameConstant.BEE1).getImage();
        // 初始化核弹图像
        nuclearBombImage = new ImageIcon(GameConstant.NUCLEAR_BOMB_IMAGE).getImage();
        // 初始化双倍火力图像
        doubleFirePowerImage = new ImageIcon(GameConstant.DOUBLE_FIREPOWER_IMAGE).getImage();
        //初始化爆炸图像
        planeBoomImage1 = new ImageIcon(GameConstant.DEFAULT_BOOM1).getImage();
        planeBoomImage2 = new ImageIcon(GameConstant.DEFAULT_BOOM2).getImage();
        planeBoomImage3 = new ImageIcon(GameConstant.DEFAULT_BOOM3).getImage();
        planeBoomImage4 = new ImageIcon(GameConstant.DEFAULT_BOOM4).getImage();
        planeBoomImage5 = new ImageIcon(GameConstant.DEFAULT_BOOM5).getImage();

        // 初始化雷达图数组
        radarImages = new Image[GameConstant.RADAR_IMAGES.length];
        for (int i = 0; i < GameConstant.RADAR_IMAGES.length; i++) {
            radarImages[i] = new ImageIcon(GameConstant.RADAR_IMAGES[i]).getImage();
        }
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
     * 获取敌机图像
     *
     * @return {@link Image}
     */
    public static Image getEnemyPlaneImage1() {
        return enemyPlaneImage;
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

    /**
     * 获取飞机吊杆图像
     *
     * @return {@link Image}
     */
    public static Image getPlaneBoomImage1() {
        return planeBoomImage1;
    }

    /**
     * 获取飞机吊杆图像2
     *
     * @return {@link Image}
     */
    public static Image getPlaneBoomImage2() {
        return planeBoomImage2;
    }

    /**
     * 获取飞机吊杆图像3
     *
     * @return {@link Image}
     */
    public static Image getPlaneBoomImage3() {
        return planeBoomImage3;
    }

    /**
     * 获取飞机吊杆图像
     *
     * @return {@link Image}
     */
    public static Image getPlaneBoomImage4() {
        return planeBoomImage4;
    }

    /**
     * 获取飞机吊杆图像
     *
     * @return {@link Image}
     */
    public static Image getPlaneBoomImage5() {
        return planeBoomImage5;
    }
}
