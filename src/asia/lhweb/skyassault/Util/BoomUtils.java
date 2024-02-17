package asia.lhweb.skyassault.Util;

import asia.lhweb.skyassault.constant.GameConstant;
import asia.lhweb.skyassault.model.bean.fly.FlyingObj;

import java.awt.*;


/**
 * @author :罗汉
 * @date : 2024/1/27
 */
public class BoomUtils extends FlyingObj {

    /**
     * 爆炸类型
     */
    private String expType;
    private int radarImageIndex;  // 用于记录索引
    private Image[] radarImages;

    public BoomUtils(int x, int y) {
        this(x, y, null);
    }

    public BoomUtils(int x, int y, String expType) {
        flyX = x;
        flyY = y;
        flyW = GameConstant.BOOM_W;
        flyH = GameConstant.BOOM_H;
        this.expType = expType;
        this.radarImageIndex = 0;
    }
    public BoomUtils(int x, int y, int w, int h,String expType) {
        flyX = x;
        flyY = y;
        flyW = w;
        flyH = h;
        this.expType = expType;
        this.radarImageIndex = 0;
    }
    @Override
    public void drawFlyer(Graphics g) {
        g.drawImage(flyImage, flyX, flyY, flyW, flyH, null);
    }

    @Override
    public void move() {
    }

    /**
     * 爆炸方法
     *
     * @return boolean
     */
    public boolean explosive() {

        switch (expType) {
            case GameConstant.ZIDANTO_ENEMYPLANE:// 子弹击中敌机
                radarImages = ImageUtils.getDefaultBoomImages();
                if (boomAnimation(radarImages)) return false;  // 当索引超过数组长度时，表示爆炸结束
                break;
            case GameConstant.ENEMYPLANE_OVER:// 敌机被摧毁
                radarImages = ImageUtils.getEnemyOverBooms();
                if (boomAnimation(radarImages)) return false;  // 当索引超过数组长度时，表示爆炸结束
                break;
            case GameConstant.HEREOPLANE_OVER:// 英雄机被摧毁
                radarImages = ImageUtils.getHeroOverBOOMS();
                if (boomAnimation(radarImages)) return false;  // 当索引超过数组长度时，表示爆炸结束
                break;
            case GameConstant.NUCLEAR_BOOM:// 核弹爆炸
                radarImages = ImageUtils.getNuclearBooms();
                if (boomAnimation(radarImages)) return false;  // 当索引超过数组长度时，表示爆炸结束
                break;
            default:
                radarImages = ImageUtils.getDefaultBoomImages();
                if (boomAnimation(radarImages)) return false;  // 当索引超过数组长度时，表示爆炸结束
                break;
        }
        return true;
    }

    /**
     * 播放动画效果
     *
     * @param images 图片数组
     * @return 如果动画播放完毕，返回 true；否则返回 false
     */
    private boolean boomAnimation(Image[] images) {
        int arrayLength = images.length;
        if (arrayLength >= 1 && radarImageIndex < arrayLength) {
            setFlyImage(images[radarImageIndex]);
            radarImageIndex++;
            if (radarImageIndex >= arrayLength) {
                return true; // 动画播放完毕
            }
        }
        return false; // 动画未播放完毕
    }

    /**
     * 设置爆炸图像尺寸 如果不调用就默认使用原图片大小
     */
    private void setImageDimensions() {

    }

}
