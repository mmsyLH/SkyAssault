package asia.lhweb.skyassault.controller.Listener;

import asia.lhweb.skyassault.constant.GameConstant;
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
            case GameConstant.GAME_START:
                // 处理开始游戏的事件
                planeController.startGame();
                break;
            case GameConstant.GAME_END:
                // 处理结束游戏的事件
                planeController.endGame();
                break;
            case GameConstant.GAME_PAUSE:
                // 处理暂停游戏的事件
                planeController.pauseGame();
                break;
        }
    }
}
