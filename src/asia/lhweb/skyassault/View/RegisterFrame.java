package asia.lhweb.skyassault.View;



import asia.lhweb.skyassault.constant.ResLoginConstant;
import asia.lhweb.skyassault.controller.PlaneController;

import javax.swing.*;

public class RegisterFrame extends JFrame {

    private RegisterPanel registerPanel;

    private PlaneController planeController;

    public RegisterFrame(PlaneController planeController) {
        this.planeController=planeController;
        setTitle("注册窗口");
        setSize(ResLoginConstant.WIDTH, ResLoginConstant.HEIGHT); // 调整窗口大小
        setLocationRelativeTo(null);
        System.out.println(planeController);
        registerPanel = new RegisterPanel(this);
        this.add(registerPanel);
        setVisible(false);
    }

    public RegisterPanel getRegisterPanel() {
        return registerPanel;
    }

    public void setRegisterPanel(RegisterPanel registerPanel) {
        this.registerPanel = registerPanel;
    }

    public PlaneController getPlaneController() {
        return planeController;
    }

    public void setPlaneController(PlaneController planeController) {
        this.planeController = planeController;
    }

}
