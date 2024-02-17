package asia.lhweb.skyassault.controller.Listener;

import asia.lhweb.skyassault.controller.PlaneController;
import asia.lhweb.skyassault.model.bean.plane.HeroPlane;
import asia.lhweb.skyassault.model.bean.Player;

import javax.swing.*;
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
    private boolean keyboardControlEnabled = true; // 标识是否允许键盘控制

    public MyKeyListener() {
    }

    public MyKeyListener(PlaneController planeController) {
        this.planeController = planeController;
        player = planeController.getPlayer();
        heroPlaneLeft= player.getHeroPlaneList().get(0);
    }

    /**
     * 键按下
     *
     * @param e e
     */
    @Override
    public void keyPressed(KeyEvent e) {
        if (!keyboardControlEnabled) return; // 如果禁用键盘控制，则直接返回
        heroPlaneLeft= player.getHeroPlaneList().get(0);
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_UP:
            case KeyEvent.VK_W:
                // 上
                heroPlaneLeft.moveUp();
                break;
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_S:
                // 下
                heroPlaneLeft.moveDown();
                break;
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_A:
                // 左
                heroPlaneLeft.moveLeft();
                break;
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
                // 右
                heroPlaneLeft.moveRight();
                break;
            case KeyEvent.VK_SPACE:
                // 空格
                spacePressed = true;
                break;
            case KeyEvent.VK_H:
                // H 发射核弹
                planeController.launchNuclearBomb();
                break;
            case KeyEvent.VK_U:
                // U 开始游戏
                planeController.startGame();
                break;
            case KeyEvent.VK_P:
                // P 暂停游戏
                planeController.pauseGame();
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

    /**
     * 设置键盘控制启用
     *
     * @param enabled 启用
     */
    public void setKeyboardControlEnabled(boolean enabled) {
        this.keyboardControlEnabled = enabled;
    }
}
