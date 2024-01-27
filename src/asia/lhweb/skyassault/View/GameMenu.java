package asia.lhweb.skyassault.View;

import asia.lhweb.skyassault.controller.Listener.ActionListener;
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

        JMenu jMenu = new JMenu("菜单");
        JMenuItem startItem = new JMenuItem("开始游戏");
        startItem.setActionCommand("start");
        startItem.addActionListener(gameMenuActionListener);
        jMenu.add(startItem);

        JMenuItem pauseItem = new JMenuItem("暂停游戏");
        pauseItem.setActionCommand("pause");
        pauseItem.addActionListener(gameMenuActionListener);
        jMenu.add(pauseItem);

        JMenuItem endItem = new JMenuItem("结束游戏");
        endItem.setActionCommand("end");
        endItem.addActionListener(gameMenuActionListener);
        jMenu.add(endItem);

        add(jMenu);
    }
}
