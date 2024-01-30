package asia.lhweb.skyassault.Util;

import asia.lhweb.skyassault.constant.GameConstant;
import asia.lhweb.skyassault.model.bean.Player;
import asia.lhweb.skyassault.model.bean.User;
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
