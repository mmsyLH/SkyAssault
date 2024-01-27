package asia.lhweb.skyassault.controller.Listener;

import asia.lhweb.skyassault.controller.PlaneController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameMenuActionListener implements ActionListener {
    private PlaneController planeController;

    public GameMenuActionListener(PlaneController planeController) {
        this.planeController = planeController;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "start":
                System.out.println("start");
                // 处理开始游戏的事件
                planeController.startGame();
                break;
            case "end":
                System.out.println("end");
                // 处理结束游戏的事件
                planeController.endGame();
                break;
            case "pause":
                System.out.println("pause");
                // 处理暂停游戏的事件
                planeController.pauseGame();
                break;
            // 添加其他菜单项的处理逻辑，如果有的话
        }
    }
}
