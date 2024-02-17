package asia.lhweb.skyassault.View;


import asia.lhweb.skyassault.Util.ImageUtils;
import asia.lhweb.skyassault.controller.PlaneController;

import javax.swing.*;
import java.awt.*;

public class UI extends JFrame {

    private LoginJFrame loginJFrame;
    private RegisterFrame registerFrame;
    private GameJFrame gameJFrame;
    private PlaneController planeController;

    public UI(PlaneController planeController) {
        this.planeController = planeController;
        loginJFrame = new LoginJFrame(this.planeController);
        gameJFrame = new GameJFrame(this.planeController);
        registerFrame = new RegisterFrame(this.planeController);

    }
    public void endGame(){
        System.exit(0);
    }
    public LoginJFrame getLoginJFrame() {
        return loginJFrame;
    }

    public void setLoginJFrame(LoginJFrame loginJFrame) {
        this.loginJFrame = loginJFrame;
    }
    public GameJFrame getGameJFrame() {
        return gameJFrame;
    }

    public void setGameJFrame(GameJFrame gameJFrame) {
        this.gameJFrame = gameJFrame;
    }

    public PlaneController getPlaneController() {
        return planeController;
    }

    public void setPlaneController(PlaneController planeController) {
        this.planeController = planeController;
    }

    public RegisterFrame getRegisterFrame() {
        return registerFrame;
    }

    public void setRegisterFrame(RegisterFrame registerFrame) {
        this.registerFrame = registerFrame;
    }

    @Override
    public String toString() {
        return "UI{" +
                "loginJFrame=" + loginJFrame +
                ", registerFrame=" + registerFrame +
                ", gameJFrame=" + gameJFrame +
                ", planeController=" + planeController +
                '}';
    }
}
