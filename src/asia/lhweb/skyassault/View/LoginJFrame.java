package asia.lhweb.skyassault.View;

import asia.lhweb.skyassault.constant.GameConstant;
import asia.lhweb.skyassault.controller.PlaneController;


import javax.swing.*;

public class LoginJFrame extends JFrame {
    private LoginJPanel loginJpanel;
    public LoginJFrame(PlaneController planeController) {
        setTitle("登录界面");
        setSize(GameConstant.GAME_WINDOW_WIDTH, GameConstant.GAME_WINDOW_HEIGHT);
        setLocationRelativeTo(null);

        loginJpanel=new LoginJPanel(planeController);
        add(loginJpanel);

        setVisible(true);
    }

    public LoginJPanel getLoginJpanel() {
        return loginJpanel;
    }

    public void setLoginJpanel(LoginJPanel loginJpanel) {
        this.loginJpanel = loginJpanel;
    }
}
