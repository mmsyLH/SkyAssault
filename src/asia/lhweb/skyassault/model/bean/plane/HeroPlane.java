package asia.lhweb.skyassault.model.bean.plane;

import asia.lhweb.skyassault.Util.ImageUtils;
import asia.lhweb.skyassault.config.GameConfig;
import asia.lhweb.skyassault.constant.GameConstant;
import asia.lhweb.skyassault.model.bean.plane.Plane;

import java.awt.*;

/**
 * 英雄飞机
 *
 * @author 罗汉
 * @date 2024/01/26
 */
public class HeroPlane extends Plane {

    private int fireLevel;;
    public HeroPlane() {
        flyType=GameConfig.getGameController();//0鼠标 1键盘
        flySpeed= GameConfig.getHeroSpeed();
        init(GameConfig.getHeroHealth(), Color.green);
        fireLevel=GameConstant.FIRE_LEVEL1;
        flyH= GameConstant.HERO1_HEIGHT;
        flyW=GameConstant.HERO1_WIDTH;
        flyName = "英雄飞机";
        flyImage= ImageUtils.getMyPlaneImage1();
    }
    
    @Override
    public void move() {

    }

    /**
     * 向上移动
     */
    public void moveUp() {
        if (flyY - flySpeed >= 0) {
            flyY -= flySpeed;
        } else {
            flyY = 0;
        }
    }

    /**
     * 向下移动
     */
    public void moveDown() {
        if (flyY <= GameConstant.GAME_WINDOW_LEFT_HEIGHT - flyH) {
            flyY += flySpeed;
        } else {
            flyY = GameConstant.GAME_WINDOW_LEFT_HEIGHT- flyH/2-flySpeed;
        }
    }

    /**
     * 移动左
     */
    public void moveLeft() {
        if (flyX - flySpeed >= 0) {
            flyX -= flySpeed;
        } else {
            flyX = 0;
        }
    }

    /**
     * 移动右
     */
    public void moveRight() {
        if (flyX +flySpeed<GameConstant.GAME_WINDOW_LEFT_WIDTH - flyW) {//750-60 690
            flyX += flySpeed;
        } else {
            flyX = GameConstant.GAME_WINDOW_LEFT_WIDTH - flyW-flySpeed;
        }
    }

    public int getFireLevel() {
        return fireLevel;
    }

    public void setFireLevel(int fireLevel) {
        this.fireLevel = fireLevel;
    }
}
