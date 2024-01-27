package asia.lhweb.skyassault.Test;

import asia.lhweb.skyassault.Util.UIUtils;
import asia.lhweb.skyassault.View.LoginJFrame;
import asia.lhweb.skyassault.controller.PlaneController;

/**
 * @author :罗汉
 * @date : 2024/1/25
 */
public class LoginJFTest {
    public static void main(String[] args) {
        UIUtils.InitUI();
        new LoginJFrame(new PlaneController());
    }
}
