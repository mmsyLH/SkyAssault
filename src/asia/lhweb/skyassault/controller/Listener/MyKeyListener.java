package asia.lhweb.skyassault.controller.Listener;

import asia.lhweb.skyassault.controller.PlaneController;
import asia.lhweb.skyassault.model.bean.HeroPlane;
import asia.lhweb.skyassault.model.bean.Player;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * 键盘监听
 *
 * @author 罗汉
 * @date 2024/01/29
 */
public class MyKeyListener implements KeyListener {

    private PlaneController planeController;
    private Player player;
    private HeroPlane heroPlaneLeft;
    private boolean spacePressed;//监听空格是否持续按下
    public MyKeyListener() {
    }

    public MyKeyListener(PlaneController planeController) {
        this.planeController = planeController;
        player = planeController.getPlayer();
        heroPlaneLeft= player.getHeroPlaneList().get(1);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        heroPlaneLeft= player.getHeroPlaneList().get(1);
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_UP:
            case KeyEvent.VK_W:
                // 上
                // System.out.println("移动前"+heroPlaneLeft.getFlyX()+"  "+heroPlaneLeft.getFlyY());
                heroPlaneLeft.moveUp();
                // System.out.println("移动后"+heroPlaneLeft.getFlyX()+"  "+heroPlaneLeft.getFlyY());
                break;
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_S:
                // 下
                // System.out.println("移动前"+heroPlaneLeft.getFlyX()+"  "+heroPlaneLeft.getFlyY());
                heroPlaneLeft.moveDown();
                // System.out.println("移动后"+heroPlaneLeft.getFlyX()+"  "+heroPlaneLeft.getFlyY());
                break;
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_A:
                // 左
                // System.out.println("移动前"+heroPlaneLeft.getFlyX()+"  "+heroPlaneLeft.getFlyY());
                heroPlaneLeft.moveLeft();
                // System.out.println("移动后"+heroPlaneLeft.getFlyX()+"  "+heroPlaneLeft.getFlyY());
                break;
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
                // 右
                // System.out.println("移动前"+heroPlaneLeft.getFlyX()+"  "+heroPlaneLeft.getFlyY());
                heroPlaneLeft.moveRight();
                // System.out.println("移动后"+heroPlaneLeft.getFlyX()+"  "+heroPlaneLeft.getFlyY());
                break;
            case KeyEvent.VK_SPACE:
                // 空格
                System.out.println("按下了空格");
                spacePressed = true;
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_SPACE:
                spacePressed = false;
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

}
