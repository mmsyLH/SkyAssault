package asia.lhweb.skyassault.Util;

import asia.lhweb.skyassault.constant.GameConstant;
import asia.lhweb.skyassault.model.bean.Player;
import asia.lhweb.skyassault.model.bean.fly.Bullet;
import asia.lhweb.skyassault.model.bean.fly.FlyingObj;

import java.awt.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Random;

/**
 * @author :罗汉
 * @date : 2024/1/29
 */
public class DataUtils {
    /**
     * 画对象
     *
     * @param g       g
     * @param objects 对象
     */
    public static <T extends FlyingObj> void drawObjects(Graphics g, java.util.List<T> objects) {
        for (FlyingObj obj : objects) {
            obj.drawFlyer(g);
        }
    }

    /**
     * 画子弹
     *
     * @param objects   对象
     * @param cleanList 干净列表
     */
    public static <T extends Bullet> void drawBullet(java.util.List<T> objects, List<FlyingObj> cleanList) {
        for (Bullet obj : objects) {
            obj.move();
            if (obj.isOutOfBound()) {
                cleanList.add(obj);
            }
        }
    }

    /**
     * MD5加密密码
     *
     * @param password 密码
     * @return {@link String}
     */
    public static String encryptPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update((GameConstant.SALT +password).getBytes());
            byte[] digest = md.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(String.format("%02x", b & 0xff));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 验证密码
     *
     * @param inputPassword     输入密码
     * @param encryptedPassword 加密密码
     * @return boolean
     */
    public static boolean verifyPassword(String inputPassword, String encryptedPassword) {
        // 对用户输入的密码进行MD5加密
        String inputEncryptedPassword = encryptPassword(inputPassword);
        // 比对加密后的密码是否匹配
        return inputEncryptedPassword.equals(encryptedPassword);
    }

    /**
     * 计算雷达中红点x的位置
     *
     * @param enemyPlaneX     敌机在左侧游戏区域的x位置
     * 雷达区域是一个长宽200的区域 他的雷达半径是100 在区域中间
     *  英雄飞机扫描范围是一个半径200的圈
     * @param heroPlaneX 英雄飞机在左侧游戏区域的x位置
     * @return int
     */
    public static int radarX(int enemyPlaneX, int heroPlaneX) {
        int radarW = 200; // 雷达图的宽度

        // 计算敌机在游戏区域中心的相对 x 坐标
        int relativeX = enemyPlaneX - heroPlaneX;
        // 检查相对位置是否在雷达范围内
        if (Math.abs(relativeX) <= 200) {
            // 使用比例将相对位置映射到雷达的宽度上
            double ratio = (double) relativeX / 200; // -1 <= ratio <= 1
            int radarX = (int) (radarW / 2 + ratio * (radarW / 2)); // 映射到雷达宽度上
            return radarX;
        } else {
            return -1; // 如果超出范围，返回-1
        }
    }

    /**
     * 计算雷达中红点y的位置
     *
     * @param enemyPlaneY     敌机在左侧游戏区域的y位置
     * @param heroPlaneY 英雄飞机在左侧游戏区域的y位置
     * @return int
     */
    public static int radarY(int enemyPlaneY, int heroPlaneY) {
        int radarH = 200; // 雷达图的高度

        // 计算敌机在游戏区域中心的相对 y 坐标
        int relativeY = enemyPlaneY - heroPlaneY;

        // 检查相对位置是否在雷达范围内
        if (Math.abs(relativeY) <= 300) {
            // 使用比例将相对位置映射到雷达的高度上
            double ratio = (double) relativeY / 300; // -1 <= ratio <= 1
            int radarY = (int) (radarH / 2 + ratio * (radarH / 2)); // 映射到雷达高度上
            return radarY;
        } else {
            return -1; // 如果超出范围，返回-1
        }
    }


    /**
     * 获得安全用户
     *
     * @param originPlayer 起源球员
     * @return {@link Player}
     */
    public Player getSafetyPlayer(Player originPlayer) {
        if (originPlayer == null) {
            return null;
        }
        Player safetyPlayer = new Player();
        safetyPlayer.setPlayerName(originPlayer.getPlayerName());
        safetyPlayer.setUsername(originPlayer.getUsername());
        safetyPlayer.setPlayerScore(originPlayer.getPlayerScore());
        return safetyPlayer;
    }

    // 生成随机验证码
    public static String generateRandomCode() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            sb.append(random.nextInt(10)); // 生成0到9的随机数字
        }
        return sb.toString();
    }
}
