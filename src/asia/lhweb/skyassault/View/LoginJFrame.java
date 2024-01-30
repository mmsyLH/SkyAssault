package asia.lhweb.skyassault.View;

import asia.lhweb.skyassault.constant.GameConstant;
import asia.lhweb.skyassault.constant.ResLoginConstant;
import asia.lhweb.skyassault.controller.PlaneController;


import javax.swing.*;

public class LoginJFrame extends JFrame {
    private boolean flag=true;
    private LoginJPanel loginJpanel;
    public LoginJFrame(PlaneController planeController) {
        setTitle("登录界面");
        setSize(ResLoginConstant.WIDTH, ResLoginConstant.HEIGHT);//400 400
        setLocationRelativeTo(null);
        loginJpanel=new LoginJPanel(planeController);
        add(loginJpanel);

        setVisible(flag);
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public LoginJPanel getLoginJpanel() {
        return loginJpanel;
    }

    public void setLoginJpanel(LoginJPanel loginJpanel) {
        this.loginJpanel = loginJpanel;
    }
}
