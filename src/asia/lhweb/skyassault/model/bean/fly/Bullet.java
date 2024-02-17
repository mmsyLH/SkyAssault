package asia.lhweb.skyassault.model.bean.fly;


import asia.lhweb.skyassault.Util.ImageRotationUtils;
import asia.lhweb.skyassault.Util.ImageUtils;
import asia.lhweb.skyassault.constant.GameConstant;
import asia.lhweb.skyassault.controller.PlaneController;
import asia.lhweb.skyassault.model.bean.fly.FlyingObj;
import asia.lhweb.skyassault.model.bean.plane.BossPlane;
import asia.lhweb.skyassault.model.bean.plane.EnemyPlane;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;

/**
 * @author :罗汉
 * @date : 2024/1/26
 */
public class Bullet extends FlyingObj {
    // todo 敌机、追种能力
    private boolean track = false;// 是否自动跟踪
    private int bulletMoveType = 1; // 弹道类型，1表示向上移动，2表示斜着移动

    public Bullet() {
        flyH = GameConstant.ZIDAN_H;
        flyW = GameConstant.ZIDAN_W;
        flySpeed = GameConstant.ZIDAN_SPEED;
    }

    public Bullet(int x, int y) {
        flyX = x;
        flyY = y;
        flyH = GameConstant.ZIDAN_H;
        flyW = GameConstant.ZIDAN_W;
        flySpeed = GameConstant.ZIDAN_SPEED;
        flyImage = ImageUtils.getEnemyBullet();
    }

    /**
     * 检查子弹是否越界
     */
    public boolean isOutOfBound() {
        return flyY < 0 || flyY > GameConstant.GAME_WINDOW_HEIGHT;
    }

    @Override
    public void drawFlyer(Graphics g) {
        g.drawImage(flyImage, flyX, flyY, flyW, flyH, null);
    }

    @Override
    public void move() {
        if (track) {// 自动跟踪的子弹
            List<FlyingObj> flyingObjs = PlaneController.getInstance().getflyingObjectList();
            for (FlyingObj flyingObj : flyingObjs) {
                if (flyingObj instanceof EnemyPlane||flyingObj instanceof BossPlane){//自动追踪的对象
                    int flyX1 = flyingObj.getFlyX();
                    int flyY1 = flyingObj.getFlyY();
                    // 计算子弹朝向敌机的方向
                    double deltaX = flyX1 - flyX;
                    double deltaY = flyY1 - flyY;
                    double angle = Math.atan2(deltaY, deltaX);
                    double speedX = Math.cos(angle) * flySpeed;
                    double speedY = Math.sin(angle) * flySpeed;
                    flyX += speedX;
                    flyY += speedY;

                    // 使用 ImageRotationUtils 工具类旋转子弹图像
                    // flyImage = ImageRotationUtils.rotateImage(this, angle);

                    break;
                }
            }
        } else {// 非自动跟踪子弹
            if (bulletMoveType == GameConstant.BULLET_MOVETYPE1) { // 向上移动
                flyY -= GameConstant.FLY_DEFAULT_SPEED + flySpeed;
            } else if (bulletMoveType == GameConstant.BULLET_MOVETYPE2) { // 斜左上移动
                flyY -= GameConstant.FLY_DEFAULT_SPEED + flySpeed;
                flyX -= GameConstant.FLY_DEFAULT_SPEED / 2 + flySpeed / 2;
            } else if (bulletMoveType == GameConstant.BULLET_MOVETYPE3) { // 斜右上移动
                flyY -= GameConstant.FLY_DEFAULT_SPEED + flySpeed;
                flyX += GameConstant.FLY_DEFAULT_SPEED / 2 + flySpeed / 2;
            } else if (bulletMoveType == GameConstant.BULLET_MOVETYPE0) {//向下
                flyY += GameConstant.FLY_DEFAULT_SPEED + flySpeed;
            }
        }
    }


    public boolean isTrack() {
        return track;
    }

    public void setTrack(boolean track) {
        this.track = track;
    }

    public int getBulletMoveType() {
        return bulletMoveType;
    }

    public void setBulletMoveType(int bulletMoveType) {
        this.bulletMoveType = bulletMoveType;
    }
}
