package asia.lhweb.skyassault.Util;

import asia.lhweb.skyassault.constant.GameConstant;

import javax.swing.*;
import java.awt.*;

/**
 * @author :罗汉
 * @date : 2024/1/25
 */
public class ImageUtils {
    /**
     * bg形象
     */
    public static Image bgImage;
    /**
     * 飞机图像
     */
    public static Image planeImage;
    /**
     * 敌机图像
     */
    public static Image enemyPlaneImage;
    /**
     * 蜜蜂形象
     */
    public static Image beeImage;
    public static Image doubleFirePowerImage;
    public static Image nuclearBombImage;

    /**
     * 得到背景图片
     *
     * @return {@link Image}
     */
    public static Image getBGImage1(){
        bgImage= new ImageIcon(GameConstant.GAME_BG1).getImage();
        return bgImage;
    }

    /**
     * 得到英雄机喷火
     *
     * @return {@link Image}
     */
    public static Image getMyPlaneImage1(){
        planeImage= new ImageIcon(GameConstant.HERO1).getImage();
        return planeImage;
    }
    /**
     * 得到英雄机不喷火
     *
     * @return {@link Image}
     */
    public static Image getMyPlaneImage1_0(){
        planeImage= new ImageIcon(GameConstant.HERO1_0).getImage();
        return planeImage;
    }
    /**
     * 获取敌机图像
     *
     * @return {@link Image}
     */
    public static Image getEnemyPlaneImage1() {
        enemyPlaneImage= new ImageIcon(GameConstant.ENEMY_PLANE1).getImage();
        return enemyPlaneImage;
    }

    /**
     * 获取蜜蜂图像
     *
     * @return {@link Image}
     */
    public static Image getBeeImage1() {
        beeImage= new ImageIcon(GameConstant.BEE1).getImage();
        return beeImage;
    }

    /**
     * 获取核弹图像
     *
     * @return {@link Image}
     */
    public static Image getNuclearBombImage() {
        nuclearBombImage= new ImageIcon(GameConstant.NUCLEAR_BOMB_IMAGE).getImage();
        return nuclearBombImage;
    }

    /**
     * 获得双倍火力图像
     *
     * @return {@link Image}
     */
    public static Image getDoubleFirePowerImage() {
        doubleFirePowerImage= new ImageIcon(GameConstant.DOUBLE_FIREPOWER_IMAGE).getImage();
        return doubleFirePowerImage;
    }
}
