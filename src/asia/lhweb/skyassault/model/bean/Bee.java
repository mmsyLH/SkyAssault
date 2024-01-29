package asia.lhweb.skyassault.model.bean;

import asia.lhweb.skyassault.Util.ImageUtils;
import asia.lhweb.skyassault.constant.GameConstant;

import java.awt.*;

/**
 * 蜜蜂
 *
 * @author 罗汉
 * @date 2024/01/26
 */
public class Bee extends FlyingObj {
    private boolean movingRight = true; // 标记Z字形移动方向
    public Bee(int x, int y) {
        flyX = x;
        flyY = y;
        flyH = 60;
        flyW = 60;
        flySpeed=GameConstant.FLY_DEFAULT_SPEED;
        flyType = 2; // 使用一个区分小蜜蜂的类型
        flyName = "Bee";
        flyImage = ImageUtils.getBeeImage1(); // 使用合适的小蜜蜂图片
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

        if (flyX <= 0 || flyX >= (GameConstant.GAME_WINDOW_LEFT_WIDTH-flyW)) {
            // 如果触边，改变方向，并向下移动
            movingRight = !movingRight;
        }
        flyY += flySpeed;
    }
}
