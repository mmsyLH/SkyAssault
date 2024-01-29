package asia.lhweb.skyassault.View;

import asia.lhweb.skyassault.constant.GameConstant;
import asia.lhweb.skyassault.controller.PlaneController;

import javax.swing.*;
import java.awt.*;

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
        setLocationRelativeTo(null);//居中
        setResizable(false);//固定窗口大小
        //顶部菜单栏
        gameMenu=new GameMenu(planeController);


        //左侧主布局
        gameJPanel=new GameJPanel(planeController);

        //右侧布局
        rightJPanel=new RightJPanel();
        rightJPanel.setPreferredSize(new Dimension(GameConstant.GAME_WINDOW_RIGHT_WIDTH,0));
        rightJPanel.setBackground(Color.cyan);

        //添加画板
        setJMenuBar(gameMenu);
        this.add(gameJPanel);
        this.add(rightJPanel,BorderLayout.EAST);
        setVisible(true);
    }
    public void endGame(){
        //关闭窗口会自动结束进程
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public GameJPanel getGameJPanel() {
        return gameJPanel;
    }

    public void setGameJPanel(GameJPanel gameJPanel) {
        this.gameJPanel = gameJPanel;
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
}
