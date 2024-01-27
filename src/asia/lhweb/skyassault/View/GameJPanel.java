package asia.lhweb.skyassault.View;

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
    private PlaneController planeController;
    private  MyPlaneListener myMouseListener;
    private  MyPlaneMotionListener myMouseMotionListener;
    public GameJPanel(PlaneController planeController) {
        this.planeController = planeController;
        setLayout(null);
    }
    @Override
    public void paintComponent(Graphics g) {
        planeController.getBackGround1().drawBackGround(g);
        planeController.getBackGround2().drawBackGround(g);
        planeController.getPlayer().getHeroPlane().drawFlayer(g);

        //遍历敌机集合调用绘制方法
        for (int i = 0; i < planeController.getFlyingObjects().size(); i++) {
            planeController.getFlyingObjects().get(i).drawFlayer(g);
        }
    }
    /**
     * 设置监听器
     */
    public void setListener() {
        myMouseListener = new MyPlaneListener(planeController);
        addMouseListener(myMouseListener);
        myMouseMotionListener = new MyPlaneMotionListener(planeController);
        addMouseMotionListener(myMouseMotionListener);
    }
}
