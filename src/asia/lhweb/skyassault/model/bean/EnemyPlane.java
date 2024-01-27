package asia.lhweb.skyassault.model.bean;

import asia.lhweb.skyassault.Util.ImageUtils;
import asia.lhweb.skyassault.constant.GameConstant;

import java.awt.*;

/**
 * 敌人飞机
 *
 * @author 罗汉
 * @date 2024/01/26
 */
public class EnemyPlane extends FlyingObj {
    private int health; // 生命值属性
    private boolean movingRight = true; // 标记Z字形移动方向
    public EnemyPlane() {
        flyH = 80;
        flyW = 80;
        flySpeed=GameConstant.FLY_DEFAULT_SPEED;
        health=5;
        flyType = 1;
        flyName = "敌机";
        flyImage = ImageUtils.getEnemyPlaneImage1();
    }

    @Override
    public void drawFlayer(Graphics g) {
        g.drawImage(flyImage, flyX, flyY, flyH, flyW, null);
    }

    @Override
    public void move() {
        if (movingRight) {
            flyX += flySpeed; // 向右移动
        } else {
            flyX -= flySpeed; // 向左移动
        }

        if (flyX <= 0 || flyX >= (GameConstant.GAME_WINDOW_LEFT_WIDTH - flyW)) {
            // 如果触边，改变方向，并向下移动
            movingRight = !movingRight;

        }
        flyY += flySpeed;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}