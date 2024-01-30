package asia.lhweb.skyassault.model.bean.plane;

import asia.lhweb.skyassault.Util.ImageUtils;
import asia.lhweb.skyassault.config.GameConfig;
import asia.lhweb.skyassault.constant.GameConstant;

import java.awt.*;

/**
 * 敌人飞机
 *
 * @author 罗汉
 * @date 2024/01/26
 */
public class BossPlane extends Plane {

    private boolean movingRight = true; // 标记Z字形移动方向

    public BossPlane() {
        this(1);
    }

    public BossPlane(int enemyPlaneType) {
        this( GameConstant.BOSS_WIDTH,GameConstant.BOSS_HEIGHT, enemyPlaneType);
    }

    public BossPlane(int enemyPlaneW, int enemyPlaneH, int enemyPlaneType) {
        flyX=GameConstant.GAME_WINDOW_LEFT_WIDTH/4;
        flyH = enemyPlaneH;
        flyY=flyH/8;
        flyW = enemyPlaneW;
        flySpeed = GameConstant.FLY_BOSS_SPEED;
        init(10, Color.red);
        flyType = enemyPlaneType;
        flyName = "敌机";
        flyImage = GameConfig.getBossImg();
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
        if (flyY <= flyH/4){
            flyY += flySpeed;
        }

    }
}
