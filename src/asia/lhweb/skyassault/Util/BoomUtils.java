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
    private int expType;
    /**
     * 爆炸时间
     */
    private int expTime;
    public BoomUtils(int x,int y) {
        this(x,y,0);
    }
    public BoomUtils(int x,int y,int expType) {
        flyX=x;
        flyY=y;
        flyW=100;
        flyH=100;
        this.expType = expType;
        expTime =4;
    }
    @Override
    public void move() {

    }

    /**
     * 爆炸方法
     *
     * @return boolean
     */
    public boolean explosive(){
        if (expType==GameConstant.ZIDANTO_ENEMYPLANE){//子弹打到敌机的爆炸
            switch (expTime){
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
            expTime--;
            if (expTime<=0) return false;
        }
        return true;
    }
}
