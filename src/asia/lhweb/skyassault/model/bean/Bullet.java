package asia.lhweb.skyassault.model.bean;

import asia.lhweb.skyassault.Util.ImageUtils;
import asia.lhweb.skyassault.constant.GameConstant;

import java.awt.*;

/**
 * @author :罗汉
 * @date : 2024/1/26
 */
public class Bullet extends FlyingObj{
    public Bullet() {
        flyH= GameConstant.ZIDAN_H;
        flyW=GameConstant.ZIDAN_W;
        flySpeed=GameConstant.ZIDAN_SPEED;
    }
    public Bullet(int x,int y) {
        flyX=x;
        flyY=y;
        flyH= GameConstant.ZIDAN_H;
        flyW=GameConstant.ZIDAN_W;
        flySpeed=GameConstant.ZIDAN_SPEED;
        flyImage= ImageUtils.getBeeImage1();
    }
    /**
     * 检查子弹是否越界
     */
    public boolean isOutOfBound() {
        return flyY < 0 || flyY > GameConstant.GAME_WINDOW_HEIGHT;
    }
    @Override
    public void drawFlayer(Graphics g) {
        g.drawImage(flyImage, flyX, flyY, flyH, flyW, null);
    }

    @Override
    public void move() {
        if (flyType==0){//向上移动
            flyY-=GameConstant.FLY_DEFAULT_SPEED+flySpeed;
        }else {
            flyY+=GameConstant.FLY_DEFAULT_SPEED+flySpeed;
        }
    }

}
