package asia.lhweb.skyassault;


import asia.lhweb.skyassault.Util.UIUtils;
import asia.lhweb.skyassault.controller.PlaneController;

public class SkyAssaultMain {
    public static void main(String[] args) {
        UIUtils.InitUI();
        new PlaneController();
    }
}
