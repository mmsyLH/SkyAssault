package asia.lhweb.skyassault.model.bean;

import asia.lhweb.skyassault.Util.ImageUtils;

import java.awt.*;

/**
 * 英雄飞机
 *
 * @author 罗汉
 * @date 2024/01/26
 */
public class HeroPlane extends FlyingObj{
    public HeroPlane() {
        flyX = 100;
        flyY = 100;
        flyH=100;
        flyW=100;
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

}
