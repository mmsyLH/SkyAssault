package asia.lhweb.skyassault.controller.Listener;

import asia.lhweb.skyassault.Util.DataUtils;
import asia.lhweb.skyassault.Util.DialogUtils;
import asia.lhweb.skyassault.View.LoginJPanel;
import asia.lhweb.skyassault.View.RegisterPanel;
import asia.lhweb.skyassault.controller.PlaneController;
import asia.lhweb.skyassault.model.bean.Player;
import asia.lhweb.skyassault.service.UserService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginListener implements ActionListener {
    private LoginJPanel loginJPanel;
    private UserService userService;
    private PlaneController planeController;

    public LoginListener(LoginJPanel loginJPanel, PlaneController planeController) {
        this.loginJPanel = loginJPanel;
        this.planeController = planeController;
        this.userService = new UserService();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "login":
                login();
                break;
            case "code":
                //生成新的验证码
                loginJPanel.getCodeButton().setText(DataUtils.generateRandomCode());
                break;
            case "goToRegister":
                planeController.getUi().getRegisterFrame().setVisible(true);
                planeController.getUi().getLoginJFrame().setVisible(false);
                break;
        }
    }


    /**
     * 登录操作
     */
    private void login() {
        // 获取文本框中的用户输入
        String username = loginJPanel.getAccText().getText();
        String password = loginJPanel.getPasswordText().getText();
        String inputCode = loginJPanel.getCodeText().getText();
        String correctCode = loginJPanel.getCodeButton().getText();

        // 检查验证码是否正确
        if (!inputCode.equals(correctCode)) {
           DialogUtils.showMessageDialog("验证码错误！", "登录失败");
            return;
        }

        // 登录验证
        Player player = new Player();
        player.setUsername(username);
        player.setPassword(password);
        Player loggedInPlayer = userService.login(player);
        if (loggedInPlayer != null) {
            // 登录成功，打开游戏窗口
            JOptionPane.showMessageDialog(null, "登录成功！", "登录成功", JOptionPane.INFORMATION_MESSAGE);
            // 关闭登录界面
            planeController.getUi().getGameJFrame().setVisible(true);
            planeController.getUi().getLoginJFrame().setVisible(false);
        }
    }
}
