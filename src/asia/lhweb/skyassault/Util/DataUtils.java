package asia.lhweb.skyassault.Util;

import asia.lhweb.skyassault.model.bean.FlyingObj;

import java.awt.*;

/**
 * @author :罗汉
 * @date : 2024/1/29
 */
public class DataUtils {
    /**
     * 画对象
     *
     * @param g       g
     * @param objects 对象
     */
    public static <T extends FlyingObj> void drawObjects(Graphics g, java.util.List<T> objects) {
        for (FlyingObj obj : objects) {
            obj.drawFlyer(g);
        }
    }
}
