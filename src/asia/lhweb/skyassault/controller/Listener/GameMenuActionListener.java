package asia.lhweb.skyassault.controller.Listener;

import asia.lhweb.skyassault.Util.DialogUtils;
import asia.lhweb.skyassault.constant.GameConstant;
import asia.lhweb.skyassault.controller.PlaneController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 游戏菜单动作监听器
 *
 * @author 罗汉
 * @date 2024/01/31
 */
public class GameMenuActionListener implements ActionListener {
    private PlaneController planeController;

    public GameMenuActionListener(PlaneController planeController) {
        this.planeController = planeController;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case GameConstant.GAME_START://开始游戏
                planeController.startGame();
                break;
            case GameConstant.GAME_END://结束游戏
                planeController.endGame();
                break;
            case GameConstant.GAME_PAUSE://暂停游戏
                planeController.pauseGame();
                break;
            case GameConstant.GAME_CONTINUE://继续游戏
                planeController.resumeGame();
                break;
            case GameConstant.GAME_AGAIN://重新开始游戏
                planeController.restartGame();
                break;
            case GameConstant.GAME_CUSTOM://自定义游戏
                break;
        }
    }
}
