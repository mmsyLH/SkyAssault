package asia.lhweb.skyassault.model.bean.plane;

import asia.lhweb.skyassault.config.GameConfig;
import asia.lhweb.skyassault.constant.GameConstant;

import java.awt.*;

/**
 * 敌人飞机
 *
 * @author 罗汉
 * @date 2024/01/26
 */
public class EnemyPlane extends Plane {

    private boolean movingRight = true; // 标记Z字形移动方向

    public EnemyPlane() {//默认为初级敌机
        this( GameConstant.Enemy_TYPE1);
    }

    public EnemyPlane(int enemyPlaneType) {
        this(GameConstant.Enemy_WIDTH, GameConstant.Enemy_HEIGHT, enemyPlaneType);
    }

    public EnemyPlane(int enemyPlaneW, int enemyPlaneH, int enemyPlaneType) {
        flyH = enemyPlaneH;
        flyW = enemyPlaneW;
        flySpeed = GameConstant.FLY_DEFAULT_SPEED;
        init(GameConfig.getEnemyHealth(), Color.red);
        flyType = enemyPlaneType;// 1 初级敌机 2 中级敌机
        flyName = "敌机";
        if (flyType == GameConstant.Enemy_TYPE1) {
            flyImage = GameConfig.getEnemyImgLv1();
        } else if (flyType == GameConstant.Enemy_TYPE2) {
            flyImage = GameConfig.getEnemyImgLv2();
        }

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

    @Override
    public String toString() {
        return "EnemyPlane{" +
                "movingRight=" + movingRight +
                ", flyX=" + flyX +
                ", flyY=" + flyY +
                ", flyH=" + flyH +
                ", flyW=" + flyW +
                ", flyType=" + flyType +
                ", flySpeed=" + flySpeed +
                ", flyName='" + flyName + '\'' +
                ", flyImage=" + flyImage +
                '}';
    }
}
