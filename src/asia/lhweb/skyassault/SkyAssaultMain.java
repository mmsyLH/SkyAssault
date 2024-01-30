package asia.lhweb.skyassault;


import asia.lhweb.skyassault.Util.ImageUtils;
import asia.lhweb.skyassault.Util.UIUtils;
import asia.lhweb.skyassault.config.GameConfig;
import asia.lhweb.skyassault.controller.PlaneController;

public class SkyAssaultMain {
    public static void main(String[] args) {
        UIUtils.InitUI();
        GameConfig.init();
        ImageUtils.init();
        new PlaneController();
    }
}
