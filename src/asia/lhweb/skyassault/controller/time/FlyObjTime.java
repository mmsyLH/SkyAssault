package asia.lhweb.skyassault.controller.time;

import asia.lhweb.skyassault.Util.ImageUtils;
import asia.lhweb.skyassault.controller.PlaneController;
import asia.lhweb.skyassault.model.bean.FlyingObj;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class FlyObjTime {
    /**
     * 延迟
     */
    private int delay;
    private Timer bgTimer;
    private PlaneController planeController;
    private int myPlaneIndex = 0;
    private List<FlyingObj> flyingObjs;

    public FlyObjTime(PlaneController planeController) {
        this.planeController = planeController;
        this.delay=35;//  1000/60=17
        this.bgTimer = new Timer(delay, actionListener);
    }
    public ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            flyingObjs=planeController.getFlyingObjects();
            //设置玩家飞机的喷火效果切换
            myPlaneIndex = (myPlaneIndex + 1) % 2;
            planeController.getPlayer().getHeroPlane().setFlyType((myPlaneIndex == 0) ? 1 : 2);

            for (FlyingObj flyingObj : flyingObjs) {
                flyingObj.move();
            }


            planeController.getUi().getGameJFrame().repaint();//刷新页面
        }
    };
    public void startTimer() {
        bgTimer.start();
    }

    public void stopTimer() {
        bgTimer.stop();
    }

    public void pauseTimer() {
        bgTimer.stop();
    }

    public void resumeTimer() {
        bgTimer.start();
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public Timer getBgTimer() {
        return bgTimer;
    }

    public void setBgTimer(Timer bgTimer) {
        this.bgTimer = bgTimer;
    }

    public PlaneController getPlaneController() {
        return planeController;
    }

    public void setPlaneController(PlaneController planeController) {
        this.planeController = planeController;
    }
}
