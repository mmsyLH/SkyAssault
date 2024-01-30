package asia.lhweb.skyassault.model.bean;

import java.awt.*;

/**
 * @author :罗汉
 * @date : 2024/1/26
 */
public abstract class FlyingObj {
    protected int flyX;
    protected int flyY;
    protected int flyH;
    protected int flyW;
    protected int flyType;
    protected int flySpeed;
    protected String flyName;
    protected Image flyImage;
    private boolean isHit=false;//判断是否击中
    private Rectangle rectangle;
    public boolean isHit() {
        return isHit;
    }

    public void setHit(boolean hit) {
        isHit = hit;
    }

    public abstract void drawFlyer(Graphics g);

    public abstract void move();

    public int getFlySpeed() {
        return flySpeed;
    }

    public void setFlySpeed(int flySpeed) {
        this.flySpeed = flySpeed;
    }
    public int getFlyX() {
        return flyX;
    }

    public void setFlyX(int flyX) {
        this.flyX = flyX;
    }

    public int getFlyY() {
        return flyY;
    }

    public void setFlyY(int flyY) {
        this.flyY = flyY;
    }

    public int getFlyH() {
        return flyH;
    }

    public void setFlyH(int flyH) {
        this.flyH = flyH;
    }

    public int getFlyW() {
        return flyW;
    }

    public void setFlyW(int flyW) {
        this.flyW = flyW;
    }

    public int getFlyType() {
        return flyType;
    }

    public void setFlyType(int flyType) {
        this.flyType = flyType;
    }

    public Image getFlyImage() {
        return flyImage;
    }

    public void setFlyImage(Image flyImage) {
        this.flyImage = flyImage;
    }

    public Rectangle getBounds() {
        rectangle=new Rectangle(flyX, flyY, flyW, flyH);
        return rectangle;
    }
}
