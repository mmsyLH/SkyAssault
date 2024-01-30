package asia.lhweb.skyassault.View;


import asia.lhweb.skyassault.constant.GameConstant;
import asia.lhweb.skyassault.controller.Listener.GameMenuActionListener;
import asia.lhweb.skyassault.controller.PlaneController;


import javax.swing.*;
import java.awt.*;

/**
 * @author :罗汉
 * @date : 2024/1/22
 */
public class GameMenu extends JMenuBar {
    public GameMenu(PlaneController planeController) {
        GameMenuActionListener gameMenuActionListener = new GameMenuActionListener(planeController);
        //开始游戏
        JMenu jMenu = new JMenu(GameConstant.MENU_NAME);
        JMenuItem startItem = new JMenuItem(GameConstant.MENU_START);
        startItem.setActionCommand(GameConstant.GAME_START);
        startItem.addActionListener(gameMenuActionListener);
        jMenu.add(startItem);
        //暂停游戏
        JMenuItem pauseItem = new JMenuItem(GameConstant.MENU_PAUSE);
        pauseItem.setActionCommand(GameConstant.GAME_PAUSE);
        pauseItem.addActionListener(gameMenuActionListener);
        jMenu.add(pauseItem);
        //结束游戏
        JMenuItem endItem = new JMenuItem(GameConstant.MENU_END);
        endItem.setActionCommand(GameConstant.GAME_END);
        endItem.addActionListener(gameMenuActionListener);
        jMenu.add(endItem);

        add(jMenu);
        // 设置菜单栏的首选大小，包括高度
        setPreferredSize(new Dimension(GameConstant.GAME_WINDOW_WIDTH, GameConstant.MENU_BAR_HEIGHT));

    }
}
