package asia.lhweb.skyassault.View;

import asia.lhweb.skyassault.Util.BoomUtils;
import asia.lhweb.skyassault.controller.Listener.MyPlaneListener;
import asia.lhweb.skyassault.controller.Listener.MyPlaneMotionListener;
import asia.lhweb.skyassault.controller.PlaneController;
import asia.lhweb.skyassault.model.bean.Bullet;
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

        // 遍历敌机集合调用绘制方法
        for (FlyingObj flyingObj : planeController.getFlyingObjects()) {
            flyingObj.drawFlayer(g);
        }

        // 遍历英雄机子弹集合调用绘制方法
        drawBullets(g, planeController.getMyPlaneBullets());

        // 遍历敌机子弹集合调用绘制方法
        drawBullets(g, planeController.getEnemyPlaneBullets());

        //绘制爆炸效果
        for (Iterator<FlyingObj> iterator = planeController.getBoomObjects().iterator(); iterator.hasNext();) {
            FlyingObj flyingObj = iterator.next();
            if (flyingObj instanceof BoomUtils) {
                BoomUtils explosion = (BoomUtils) flyingObj;
                if (!explosion.explosive()) {
                    // System.out.println("移除了爆炸效果");
                    iterator.remove(); // 移除爆炸效果
                } else {
                    // System.out.println("绘制了爆炸效果");
                    explosion.drawFlayer(g); // 绘制爆炸效果
                }
            }
        }
    }
    /**
     * 绘制子弹集合
     */
    private void drawBullets(Graphics g, java.util.List<Bullet> bullets) {
        for (Bullet bullet : bullets) {
            bullet.drawFlayer(g);
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
