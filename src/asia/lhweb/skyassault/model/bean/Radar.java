package asia.lhweb.skyassault.model.bean;

import asia.lhweb.skyassault.Util.ImageUtils;
import asia.lhweb.skyassault.constant.GameConstant;

import java.awt.*;

/**
 * 雷达
 *
 * @author 罗汉
 * @date 2024/01/31
 */
public class Radar {
    private int backX;
    private int backY;
    private Image[] backImage;
    private int radarImageIndex;

    public Radar() {
        this.backX = 20;
        this.backY = 450;
        this.backImage = ImageUtils.getRadarImages();
        this.radarImageIndex = 0; // 初始化索引
    }

    /**
     * 抽回地面
     *
     * @param g g
     */
    public void drawBackGround(Graphics g) {
        if (backImage.length >= 1) {
            // 绘制当前雷达图片
            g.drawImage(backImage[radarImageIndex], backX, backY, null);
        }
    }

    /**
     * 切换图片
     */
    public void switchImage() {
        radarImageIndex++;
        if (radarImageIndex >= backImage.length) {
            radarImageIndex = 0;
        }
    }
}
