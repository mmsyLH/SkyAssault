package asia.lhweb.skyassault.View;

import asia.lhweb.skyassault.Util.BoomUtils;
import asia.lhweb.skyassault.Util.DataUtils;
import asia.lhweb.skyassault.controller.Listener.MyKeyListener;
import asia.lhweb.skyassault.controller.Listener.MyPlaneListener;
import asia.lhweb.skyassault.controller.Listener.MyPlaneMotionListener;
import asia.lhweb.skyassault.controller.PlaneController;
import asia.lhweb.skyassault.model.bean.FlyingObj;

import javax.swing.*;
import java.awt.*;
import java.util.Iterator;

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
        setFocusable(true);//获取焦点
        planeController.getBackGround1().drawBackGround(g);
        planeController.getBackGround2().drawBackGround(g);
        (planeController.getPlayer().getHeroPlaneList()).get(0).drawFlayer(g);
        (planeController.getPlayer().getHeroPlaneList()).get(1).drawFlayer(g);

        // 遍历敌机集合调用绘制方法
        DataUtils.drawObjects(g, planeController.getFlyingObjects());

        // 遍历英雄机子弹集合调用绘制方法
        DataUtils.drawObjects(g, planeController.getMyPlaneBullets());

        // 遍历敌机子弹集合调用绘制方法
        DataUtils.drawObjects(g, planeController.getEnemyPlaneBullets());

        // 绘制爆炸效果
        for (Iterator<FlyingObj> iterator = planeController.getBoomObjects().iterator(); iterator.hasNext(); ) {
            FlyingObj flyingObj = iterator.next();
            if (flyingObj instanceof BoomUtils) {
                BoomUtils explosion = (BoomUtils) flyingObj;
                if (!explosion.explosive()) {
                    iterator.remove(); // 移除爆炸效果
                } else {
                    explosion.drawFlayer(g); // 绘制爆炸效果
                }
            }
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
        myKeyListener = new MyKeyListener(planeController);
        addKeyListener(myKeyListener);


    }
}
