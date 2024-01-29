package asia.lhweb.skyassault.View;


import asia.lhweb.skyassault.constant.GameConstant;
import asia.lhweb.skyassault.controller.Listener.GameMenuActionListener;
import asia.lhweb.skyassault.controller.PlaneController;


import javax.swing.*;

/**
 * @author :罗汉
 * @date : 2024/1/22
 */
public class GameMenu extends JMenuBar {
    public GameMenu(PlaneController planeController) {
        GameMenuActionListener gameMenuActionListener = new GameMenuActionListener(planeController);

        JMenu jMenu = new JMenu(GameConstant.MENU_NAME);
        JMenuItem startItem = new JMenuItem(GameConstant.MENU_START);
        startItem.setActionCommand(GameConstant.GAME_START);
        startItem.addActionListener(gameMenuActionListener);
        jMenu.add(startItem);

        JMenuItem pauseItem = new JMenuItem(GameConstant.MENU_PAUSE);
        pauseItem.setActionCommand(GameConstant.GAME_PAUSE);
        pauseItem.addActionListener(gameMenuActionListener);
        jMenu.add(pauseItem);

        JMenuItem endItem = new JMenuItem(GameConstant.MENU_END);
        endItem.setActionCommand(GameConstant.GAME_END);
        endItem.addActionListener(gameMenuActionListener);
        jMenu.add(endItem);

        add(jMenu);
    }
}
