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
    public void moveUp() {
        flyY -= flySpeed;
    }

    public void moveDown() {
        flyY += flySpeed;
    }

    public void moveLeft() {
        flyX -= flySpeed;
    }

    public void moveRight() {
        flyX += flySpeed;
    }
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
