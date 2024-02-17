package asia.lhweb.skyassault.controller.Listener;

import asia.lhweb.skyassault.Util.DataUtils;
import asia.lhweb.skyassault.Util.DialogUtils;
import asia.lhweb.skyassault.config.GameConfig;
import asia.lhweb.skyassault.constant.GameConstant;
import asia.lhweb.skyassault.controller.PlaneController;
import asia.lhweb.skyassault.model.bean.Player;
import asia.lhweb.skyassault.service.UserService;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

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
            case GameConstant.GAME_START:// 开始游戏
                Object[] options = {"鼠标移动", "键盘移动"};
                int gameController = DialogUtils.showOptionDialog("请选择移动方式", "开始游戏", options);
                GameConfig.setGameController(gameController);
                planeController.startGame();
                break;
            case GameConstant.GAME_END:// 结束游戏
                System.out.println("结束游戏");
                planeController.endGame();
                break;
            case GameConstant.GAME_PAUSE:// 暂停游戏
                planeController.pauseGame();
                DialogUtils.showPauseDialog(planeController.getUi().getGameJFrame()); // 显示暂停游戏的对话框
                break;
            case GameConstant.GAME_CONTINUE:// 继续游戏
                planeController.resumeGame();
                break;
            case GameConstant.GAME_AGAIN:// 重新开始游戏
                planeController.restartGame();
                break;
            case GameConstant.GAME_CUSTOM:// 自定义游戏
                planeController.pauseGame();
                DialogUtils.showCustomLevelDialog(planeController.getUi().getGameJFrame());
                break;
            case "top":// 获取排行榜数据
                UserService userService = new UserService();
                List<Player> top3Player = userService.getTop3();
                DialogUtils.showTop3Dialog(top3Player);
                break;
            case GameConstant.GAME_SETTING:
                // 处理设置菜单项的逻辑
                DialogUtils.showMessageDialog(planeController.getUi().getGameJFrame(), "设置","设置");
                break;
            case GameConstant.GAME_OPERATE:
                // 处理操作说明菜单项的逻辑
                if (GameConfig.getGameController()==0){//0鼠标 1键盘
                    DialogUtils.showMessageDialog(planeController.getUi().getGameJFrame(),
                            "鼠标控制方向移动；\n" +
                            "U:游戏开始\n" +
                            "I:游戏暂停\n" +
                            "O:游戏继续\n" +
                            "H:发射核弹","操作信息");
                } else if (GameConfig.getGameController()==1) {
                    DialogUtils.showMessageDialog(planeController.getUi().getGameJFrame(), "W:英雄机上移；\n" +
                            "A:英雄机左移；\n" +
                            "S:英雄机下移；\n" +
                            "D:英雄机右移；\n" +
                            "U:游戏开始\n" +
                            "I:游戏暂停\n" +
                            "O:游戏继续\n" +
                            "H:发射核弹","操作信息");
                }

                break;
            case GameConstant.GAME_ABOUT:
                // 处理关于菜单项的逻辑
                DialogUtils.showMessageDialog(planeController.getUi().getGameJFrame(), "关于游戏的信息","关于游戏");
                break;
        }
    }


}
