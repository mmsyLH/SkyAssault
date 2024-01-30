package asia.lhweb.skyassault.model.bean;

import asia.lhweb.skyassault.Util.ImageUtils;
import asia.lhweb.skyassault.config.GameConfig;
import asia.lhweb.skyassault.constant.GameConstant;

import java.awt.*;

/**
 * 英雄飞机
 *
 * @author 罗汉
 * @date 2024/01/26
 */
public class HeroPlane extends FlyingObj{
    private int health; // 生命值属性
    public HeroPlane() {
        flySpeed= GameConfig.getHeroSpeed();
        health=3;
        flyX = 60;
        flyY =60;
        flyH= GameConstant.HERO1_HEIGHT;
        flyW=GameConstant.HERO1_WIDTH;
        flyName = "英雄飞机";
        flyImage= ImageUtils.getMyPlaneImage1();
    }

    @Override
    public void drawFlayer(Graphics g) {
        if (flyType == 1) {
            flyImage = ImageUtils.getMyPlaneImage1();
            g.drawImage(flyImage, flyX, flyY, flyH, flyW, null);

        } else {
            flyImage =ImageUtils.getMyPlaneImage1_0();
            g.drawImage(flyImage, flyX, flyY, flyH, flyW, null);
        }
    }

    @Override
    public void move() {

    }

    /**
     * 向上移动
     */
    public void moveUp() {
        if (flyY - flySpeed >= 0) {
            flyY -= flySpeed;
        } else {
            flyY = 0;
        }
    }

    /**
     * 向下移动
     */
    public void moveDown() {
        if (flyY <= GameConstant.GAME_WINDOW_LEFT_HEIGHT - flyH) {
            flyY += flySpeed;
        } else {
            flyY = GameConstant.GAME_WINDOW_LEFT_HEIGHT- flyH/2-flySpeed;
        }
    }

    /**
     * 移动左
     */
    public void moveLeft() {
        if (flyX - flySpeed >= 0) {
            flyX -= flySpeed;
        } else {
            flyX = 0;
        }
    }

    /**
     * 移动右
     */
    public void moveRight() {
        // int x=flyX;
        // int y=GameConstant.GAME_WINDOW_LEFT_WIDTH - flyW;
        // System.out.println("x=" + x + " y=" + y);
        if (flyX +flySpeed<GameConstant.GAME_WINDOW_LEFT_WIDTH - flyW) {//750-60 690
            flyX += flySpeed;
        } else {
            flyX = GameConstant.GAME_WINDOW_LEFT_WIDTH - flyW-flySpeed;
        }
    }
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
