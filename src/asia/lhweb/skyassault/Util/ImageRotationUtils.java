package asia.lhweb.skyassault.Util;

import asia.lhweb.skyassault.model.bean.fly.FlyingObj;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class ImageRotationUtils {

    /**
     * 旋转图像
     *
     * @param flyingObj 要旋转的 FlyingObj 对象
     * @param angle     旋转角度（弧度）
     * @return 旋转后的图像
     */
    public static BufferedImage rotateImage(FlyingObj flyingObj, double angle) {
        if (flyingObj == null || flyingObj.getFlyImage() == null) {
            return null;
        }

        Image flyImage = flyingObj.getFlyImage();
        int flyW = flyingObj.getFlyW();
        int flyH = flyingObj.getFlyH();
        // 创建一个用于旋转的AffineTransform对象
        AffineTransform transform = new AffineTransform();
        // 将图像旋转到指定角度
        transform.rotate(angle, flyW / 2, flyH / 2);

        // 创建一个新的BufferedImage对象，用于存储旋转后的图像
        BufferedImage rotatedImage = new BufferedImage(flyW, flyH, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = rotatedImage.createGraphics();
        g.setTransform(transform);
        // 绘制旋转后的图像
        g.drawImage(flyImage, 0, 0, null);
        g.dispose();

        return rotatedImage;
    }
}
