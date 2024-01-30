package asia.lhweb.skyassault;


import asia.lhweb.skyassault.Util.ImageUtils;
import asia.lhweb.skyassault.Util.MusicUtils;
import asia.lhweb.skyassault.Util.UIUtils;
import asia.lhweb.skyassault.config.GameConfig;
import asia.lhweb.skyassault.controller.PlaneController;

public class SkyAssaultMain {
    public static void main(String[] args) {
        //初始化
        UIUtils.InitUI();
        ImageUtils.init();
        GameConfig.initLv1();
        MusicUtils.init();
        //开启游戏
        PlaneController.run();
    }
}
