package asia.lhweb.skyassault.controller.Listener;

import asia.lhweb.skyassault.constant.GameConstant;
import asia.lhweb.skyassault.controller.PlaneController;
import asia.lhweb.skyassault.model.bean.Player;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MyPlaneMotionListener implements MouseMotionListener {
    private PlaneController planeController;
    private Player player;
    private boolean mouseControlEnabled = true; // 标识是否允许鼠标控制

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
        if (!mouseControlEnabled) return; // 如果禁用鼠标控制，则直接返回
        if (planeController.isAllowMovement()) {
            player = planeController.getPlayer();
            player.getHeroPlaneList().get(0).setFlyX(e.getX() - GameConstant.HERO1_WIDTH/2);
            player.getHeroPlaneList().get(0).setFlyY(e.getY() - GameConstant.HERO1_HEIGHT/2);
        }
    }

    // 添加方法来设置鼠标控制是否可用
    public void setMouseControlEnabled(boolean enabled) {
        this.mouseControlEnabled = enabled;
    }
}
