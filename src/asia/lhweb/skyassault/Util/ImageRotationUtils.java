package asia.lhweb.skyassault.Util;

import asia.lhweb.skyassault.constant.GameConstant;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


/**
 * 图像旋转示例
 * ImageRotationExample 类演示了如何在 JPanel 中旋转图像。
 * 该类使用了 AffineTransform 来实现图像的旋转效果。
 *
 */
public class ImageRotationUtils extends JPanel {

    private BufferedImage image;

    /**
     * 构造函数，初始化 ImageRotationExample 实例。
     * 从指定文件加载图像并赋值给成员变量 image。
     */
    public ImageRotationUtils() {
        try {
            // 从文件加载图像
            image = ImageIO.read(new File(GameConstant.NUCLEAR_BOMB_IMAGE));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 重写父类的 paintComponent 方法，绘制旋转后的图像。
     *
     * @param g 绘图上下文
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (image != null) {
            Graphics2D g2d = (Graphics2D) g.create();

            // 计算旋转角度，这里设置为 45 度
            double rotationRequired = Math.atan2(0, 0);

            // 计算旋转中心点的坐标
            double locationX = image.getWidth() / 2;
            double locationY = image.getHeight() / 2;

            // 创建 AffineTransform 对象，用于旋转图像
            AffineTransform tx = AffineTransform.getRotateInstance(rotationRequired, locationX, locationY);

            // 平移图像，使其绘制在新的位置
            // tx.translate(100, 100);

            // 绘制旋转后的图像
            g2d.drawImage(image, tx, null);

            // 释放图形上下文资源
            g2d.dispose();
        }
    }

    /**
     * 主方法，创建 JFrame 实例，并添加 ImageRotationExample 实例。
     *
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("Image Rotation Example");
        ImageRotationUtils imageExample = new ImageRotationUtils();
        frame.add(imageExample);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭窗口
        frame.setVisible(true);
    }
}
