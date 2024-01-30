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
        ///////////////////////////////////////////////菜单1
        JMenu jMenu = new JMenu(GameConstant.MENU_NAME);
        // 开始游戏
        JMenuItem startItem = new JMenuItem(GameConstant.MENU_START);
        startItem.setActionCommand(GameConstant.GAME_START);
        startItem.addActionListener(gameMenuActionListener);
        jMenu.add(startItem);

        // 暂停游戏
        JMenuItem pauseItem = new JMenuItem(GameConstant.MENU_PAUSE);
        pauseItem.setActionCommand(GameConstant.GAME_PAUSE);
        pauseItem.addActionListener(gameMenuActionListener);
        jMenu.add(pauseItem);

        // 继续游戏
        JMenuItem continueItem = new JMenuItem(GameConstant.MENU_CONTINUE);
        continueItem.setActionCommand(GameConstant.GAME_CONTINUE);
        continueItem.addActionListener(gameMenuActionListener);
        jMenu.add(continueItem);

        // 重新开始
        JMenuItem againItem = new JMenuItem(GameConstant.MENU_AGAIN);
        againItem.setActionCommand(GameConstant.GAME_AGAIN);
        againItem.addActionListener(gameMenuActionListener);
        jMenu.add(againItem);

        // 自定义
        JMenuItem customItem = new JMenuItem(GameConstant.MENU_CUSTOM);
        customItem.setActionCommand(GameConstant.GAME_CUSTOM);
        customItem.addActionListener(gameMenuActionListener);
        jMenu.add(customItem);

        // 结束游戏
        JMenuItem endItem = new JMenuItem(GameConstant.MENU_END);
        endItem.setActionCommand(GameConstant.GAME_END);
        endItem.addActionListener(gameMenuActionListener);
        jMenu.add(endItem);
        ///////////////////////////////////////////////菜单2
        JMenu helpMenu = new JMenu(GameConstant.MENU_NAME2);
        //操作信息
        JMenuItem operateItem = new JMenuItem(GameConstant.MENU_OPERATE);
        operateItem.setActionCommand(GameConstant.GAME_OPERATE);
        operateItem.addActionListener(gameMenuActionListener);
        helpMenu.add(operateItem);
        //关于游戏
        JMenuItem aboutItem = new JMenuItem(GameConstant.MENU_ABOUT);
        aboutItem.setActionCommand(GameConstant.GAME_ABOUT);
        aboutItem.addActionListener(gameMenuActionListener);
        helpMenu.add(aboutItem);
        //设置
        JMenuItem settingItem = new JMenuItem(GameConstant.MENU_SETTING);
        settingItem.setActionCommand(GameConstant.GAME_SETTING);
        settingItem.addActionListener(gameMenuActionListener);
        helpMenu.add(settingItem);

        // 设置菜单栏的首选大小，包括高度
        add(jMenu);
        add(helpMenu);
        setPreferredSize(new Dimension(GameConstant.GAME_WINDOW_WIDTH, GameConstant.MENU_BAR_HEIGHT));
    }
}
