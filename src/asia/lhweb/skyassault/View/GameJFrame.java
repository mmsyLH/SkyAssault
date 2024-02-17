package asia.lhweb.skyassault.View;

import asia.lhweb.skyassault.Util.ImageUtils;
import asia.lhweb.skyassault.constant.GameConstant;
import asia.lhweb.skyassault.controller.PlaneController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 游戏容器
 *
 * @author 罗汉
 * @date 2024/01/25
 */
public class GameJFrame extends JFrame {
    private GameJPanel gameJPanel;
    private RightJPanel rightJPanel;
    private PlaneController planeController;
    private GameMenu gameMenu;

    public GameJFrame(PlaneController planeController) {
        this.planeController = planeController;
        setTitle(GameConstant.SKY_ASSAULT_NAME);
        setSize(GameConstant.GAME_WINDOW_WIDTH, GameConstant.GAME_WINDOW_HEIGHT);
        setLocationRelativeTo(null);// 居中
        setResizable(false);// 固定窗口大小
        // 顶部菜单栏
        gameMenu = new GameMenu(planeController);

        // 左侧主布局
        gameJPanel = new GameJPanel(planeController);
        gameJPanel.setPreferredSize(new Dimension(GameConstant.GAME_WINDOW_LEFT_WIDTH, 0));

        // 右侧布局
        rightJPanel = new RightJPanel(planeController);
        rightJPanel.setPreferredSize(new Dimension(GameConstant.GAME_WINDOW_RIGHT_WIDTH, 0));
        rightJPanel.setBackground(new Color(0xEEEEEE));

        // 添加画板
        setJMenuBar(gameMenu);
        this.add(gameJPanel);
        this.add(rightJPanel, BorderLayout.EAST);

        // 添加窗口关闭事件监听
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                showExitConfirmationDialog();
            }
        });
        this.setIconImage(ImageUtils.getZhuTi());
        setVisible(false);
    }

    private void showExitConfirmationDialog() {
        JDialog dialog = new JDialog(this, "退出游戏", true);
        dialog.getContentPane().setBackground(Color.WHITE);
        int result = JOptionPane.showConfirmDialog(dialog, "确定要退出游戏吗？", "退出游戏", JOptionPane.YES_NO_OPTION);
        System.out.println("result: " + result);
        if (result == JOptionPane.YES_OPTION) {
            // 用户点击了确认，结束进程
            endGame();
        }
    }

    public void endGame() {
        // 关闭窗口会自动结束进程
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public GameJPanel getGameJPanel() {
        return gameJPanel;
    }




    public RightJPanel getRightJPanel() {
        return rightJPanel;
    }

    public void setRightJPanel(RightJPanel rightJPanel) {
        this.rightJPanel = rightJPanel;
    }

    public PlaneController getPlaneController() {
        return planeController;
    }

    public void setPlaneController(PlaneController planeController) {
        this.planeController = planeController;
    }

    public GameMenu getGameMenu() {
        return gameMenu;
    }

    public void setGameMenu(GameMenu gameMenu) {
        this.gameMenu = gameMenu;
    }
}
