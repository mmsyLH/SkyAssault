package asia.lhweb.skyassault.Util;

import asia.lhweb.skyassault.constant.GameConstant;
import asia.lhweb.skyassault.model.bean.FlyingObj;


/**
 * @author :罗汉
 * @date : 2024/1/27
 */
public class BoomUtils extends FlyingObj {

    /**
     * 爆炸类型
     */
    private String expType;
    /**
     * 爆炸时间
     */
    private int expTime;

    public BoomUtils(int x, int y) {
        this(x, y, null);
    }

    public BoomUtils(int x, int y, String expType) {
        flyX = x;
        flyY = y;
        flyW = GameConstant.BOOM_W;
        flyH = GameConstant.BOOM_H;
        this.expType = expType;
        expTime = 4;
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
            case GameConstant.ZIDANTO_ENEMYPLANE:
                switch (expTime) {
                    case 1:
                        setFlyImage(ImageUtils.getPlaneBoomImage1());
                        break;
                    case 2:
                        setFlyImage(ImageUtils.getPlaneBoomImage2());
                        break;
                    case 3:
                        setFlyImage(ImageUtils.getPlaneBoomImage3());
                        break;
                    case 4:
                        setFlyImage(ImageUtils.getPlaneBoomImage4());
                        break;
                    case 5:
                        setFlyImage(ImageUtils.getPlaneBoomImage5());
                        break;
                }
            case GameConstant.ZIDANTO_HEREOPLANE:
                switch (expTime) {
                    case 1:
                        setFlyImage(ImageUtils.getPlaneBoomImage1());
                        break;
                    case 2:
                        setFlyImage(ImageUtils.getPlaneBoomImage2());
                        break;
                    case 3:
                        setFlyImage(ImageUtils.getPlaneBoomImage3());
                        break;
                    case 4:
                        setFlyImage(ImageUtils.getPlaneBoomImage4());
                        break;
                    case 5:
                        setFlyImage(ImageUtils.getPlaneBoomImage5());
                        break;
                }
                break;
            case GameConstant.ENEMYPLANE_OVER:
                switch (expTime) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        setFlyImage(ImageUtils.getBeeImage1());
                        break;
                }
                break;
            default:
                switch (expTime) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        setFlyImage(ImageUtils.getBeeImage1());
                        break;
                }
                break;
        }
        expTime--;
        if (expTime <= 0) return false;

        return true;
    }
}
