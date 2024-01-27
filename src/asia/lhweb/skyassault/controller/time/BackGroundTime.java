package asia.lhweb.skyassault.controller.time;

import asia.lhweb.skyassault.View.RightJPanel;
import asia.lhweb.skyassault.controller.PlaneController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 背景定时器
 * 延迟时间、定时器、响应事件
 *
 * @author 罗汉
 * @date 2024/01/25
 */
public class BackGroundTime {
    private int delay;//刷新间隔
    private Timer bgTimer;;
    private PlaneController planeController;
    public BackGroundTime(PlaneController planeController) {
        this.planeController=planeController;
        this.delay=17;//  1000/60=17
        this.bgTimer=new Timer(delay,actionListener);
    }
    public ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            planeController.getBackGround1().backGroundMove();
            planeController.getBackGround2().backGroundMove();
            planeController.getUi().getGameJFrame().repaint();
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

    public ActionListener getActionListener() {
        return actionListener;
    }

    public void setActionListener(ActionListener actionListener) {
        this.actionListener = actionListener;
    }
}
