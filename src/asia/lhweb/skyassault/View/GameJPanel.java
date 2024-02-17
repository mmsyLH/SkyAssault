package asia.lhweb.skyassault.View;

import asia.lhweb.skyassault.Util.DataUtils;
import asia.lhweb.skyassault.config.GameConfig;
import asia.lhweb.skyassault.controller.Listener.MyKeyListener;
import asia.lhweb.skyassault.controller.Listener.MyPlaneListener;
import asia.lhweb.skyassault.controller.Listener.MyPlaneMotionListener;
import asia.lhweb.skyassault.controller.PlaneController;

import javax.swing.*;
import java.awt.*;

/**
 * 游戏画板
 *
 * @author 罗汉
 * @date 2024/01/25
 */
public class GameJPanel extends JPanel {
    private final PlaneController planeController;
    private MyPlaneListener myMouseListener;
    private MyPlaneMotionListener myMouseMotionListener;
    private MyKeyListener myKeyListener;

    public GameJPanel(PlaneController planeController) {
        this.planeController = planeController;
        setLayout(null);
    }

    @Override
    public void paintComponent(Graphics g) {
        setFocusable(true);// 获取焦点

        planeController.getBackGround1().drawBackGround(g);
        planeController.getBackGround2().drawBackGround(g);
        (planeController.getPlayer().getHeroPlaneList()).get(0).drawFlyer(g);
        (planeController.getPlayer().getHeroPlaneList()).get(1).drawFlyer(g);

        // 遍历敌机集合调用绘制方法
        DataUtils.drawObjects(g, planeController.getflyingObjectList());

        // 遍历英雄机子弹集合调用绘制方法
        DataUtils.drawObjects(g, planeController.getmyPlaneBulletList());

        // 遍历敌机子弹集合调用绘制方法
        DataUtils.drawObjects(g, planeController.getenemyPlaneBulletList());

        // 绘制爆炸效果
        DataUtils.drawObjects(g, planeController.getboomObjectList());


    }

    /**
     * 设置监听器
     */
    public void setListener() {
        myMouseListener = new MyPlaneListener(planeController);
        addMouseListener(myMouseListener);
        myMouseMotionListener = new MyPlaneMotionListener(planeController);
        addMouseMotionListener(myMouseMotionListener);
        myKeyListener = new MyKeyListener(planeController);
        addKeyListener(myKeyListener);
    }
}
