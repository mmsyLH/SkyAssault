package asia.lhweb.skyassault.controller.Listener;

import asia.lhweb.skyassault.View.RegisterFrame;
import asia.lhweb.skyassault.View.RegisterPanel;
import asia.lhweb.skyassault.controller.PlaneController;
import asia.lhweb.skyassault.model.bean.Player;
import asia.lhweb.skyassault.service.UserService;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterListener implements ActionListener {
    private RegisterPanel registerPanel;
    private UserService userService;

    public RegisterListener(RegisterPanel registerPanel) {
        this.registerPanel = registerPanel;
        userService = new UserService();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // 获取文本框中的用户输入
        String userAccount = registerPanel.getAccount().getText();
        String userPwd = registerPanel.getPlayPwd().getText();
        String userName = registerPanel.getPlayName().getText();
        int userScore = 0; // 初始分数为0

        Player player = new Player();
        player.setUsername(userAccount);
        player.setPassword(userPwd);
        player.setPlayerName(userName);
        player.setPlayerScore(userScore);
        switch (e.getActionCommand()) {
            case "register":
                boolean flag = userService.register(player);
                if (flag) {
                    // 关闭注册页面显示框
                    PlaneController.getInstance().getUi().getRegisterFrame().setVisible(false);
                }
                break;
            case "goToLogin":
                PlaneController.getInstance().getUi().getLoginJFrame().setVisible(true);
                PlaneController.getInstance().getUi().getRegisterFrame().setVisible(false);
                break;
            default:
                break;
        }
    }
}
