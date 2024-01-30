package asia.lhweb.skyassault.model.bean.plane;

import asia.lhweb.skyassault.model.bean.fly.FlyingObj;

import java.awt.*;

/**
 * @author :罗汉
 * @date : 2024/1/30
 */
public abstract class Plane extends FlyingObj {

    private int health; // 生命值属性
    private int healthLimit; // 生命值属性

    private Color healthColor; // 生命值属性

    public void init(int health, Color healthColor) {
        this.health = health;
        healthLimit = health;
        this.healthColor = healthColor;
    }

    public int getHealthLimit() {
        return healthLimit;
    }

    public void setHealthLimit(int healthLimit) {
        this.healthLimit = healthLimit;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public void drawFlyer(Graphics g) {
        int hpHeight = getFlyW();//血条高度  todo: 改成根据飞行物高度设置最小值来区别Boss
        g.drawImage(flyImage, flyX, flyY, flyW, flyH, null);
        g.setColor(Color.white);
        g.fillRect(flyX + (flyW - hpHeight) / 2, flyY - 10, (int) (1.0 * hpHeight * healthLimit / healthLimit), 5);
        g.setColor(healthColor);
        g.fillRect(flyX  + (flyW - hpHeight) / 2, flyY - 10, (int) (1.0 * hpHeight * health / healthLimit), 5);
    }

    public Color getHealthColor() {
        return healthColor;
    }

    public void setHealthColor(Color healthColor) {
        this.healthColor = healthColor;
    }
}
