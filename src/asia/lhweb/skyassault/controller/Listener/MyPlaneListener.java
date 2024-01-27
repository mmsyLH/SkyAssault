package asia.lhweb.skyassault.controller.Listener;

import asia.lhweb.skyassault.controller.PlaneController;
import asia.lhweb.skyassault.model.bean.Player;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * 鼠标点击监听器
 *
 * @author 罗汉
 * @date 2024/01/24
 */
public class MyPlaneListener implements MouseListener {
    private PlaneController planeController;
    private Player player;

    public MyPlaneListener() {
    }

    public MyPlaneListener(PlaneController planeController) {
        this.planeController = planeController;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
