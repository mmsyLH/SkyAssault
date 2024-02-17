package asia.lhweb.skyassault.model.bean;


import asia.lhweb.skyassault.Util.ImageUtils;
import asia.lhweb.skyassault.config.GameConfig;
import asia.lhweb.skyassault.constant.GameConstant;

import javax.swing.*;
import java.awt.*;

/**
 * @author :罗汉
 * @date : 2024/1/25
 */
public class BackGround {
    private int backX;
    private int backY;
    private int backW=GameConstant.GAME_WINDOW_LEFT_WIDTH;
    private int backH=GameConstant.GAME_WINDOW_HEIGHT;
    private Image backImage;
    private int backSpeed;

    public BackGround() {
        this.backX =0;
        this.backY =0;
        this.backImage= GameConfig.getBackImage();
        this.backSpeed =5;
    }
    public void drawBackGround(Graphics g){
        g.drawImage(backImage, backX, backY, backW, backH, null);
    }
    public void backGroundMove(){
        backY+=backSpeed;//背景图片移动
        if(backY>=backH){
            backY=-backH;
        }
    }

    public int getBackY() {
        return backY;
    }

    public void setBackY(int backY) {
        this.backY = backY;
    }

    public void setBackImage(Image backImage) {
        this.backImage = backImage;
    }
}
