package asia.lhweb.skyassault.Test;

import asia.lhweb.skyassault.Util.UIUtils;
import asia.lhweb.skyassault.View.GameJFrame;
import asia.lhweb.skyassault.controller.PlaneController;

/**
 * @author :罗汉
 * @date : 2024/1/25
 */
public class GameJFrameTest {
    public static void main(String[] args) {
        UIUtils.InitUI();
        new GameJFrame(new PlaneController());
    }
}
