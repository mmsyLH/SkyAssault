package asia.lhweb.skyassault.controller.Listener;


import asia.lhweb.skyassault.controller.PlaneController;
import asia.lhweb.skyassault.model.bean.Player;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

/**
 * 鼠标移动监听器
 *
 */
public class MyPlaneMotionListener implements MouseMotionListener {
    private PlaneController planeController;
    private Player player;


    public MyPlaneMotionListener() {

    }

    public MyPlaneMotionListener(PlaneController planeController) {

        this.planeController=planeController;
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }
    @Override
    public void mouseMoved(MouseEvent e) {
        if (planeController.isAllowMovement()) {
            player = planeController.getPlayer();
            player.getHeroPlaneList().get(0).setFlyX(e.getX() - 50);
            player.getHeroPlaneList().get(0).setFlyY(e.getY() - 50);

        }
    }
}
