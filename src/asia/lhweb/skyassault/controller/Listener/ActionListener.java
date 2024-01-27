package asia.lhweb.skyassault.controller.Listener;

import asia.lhweb.skyassault.controller.PlaneController;

import java.awt.event.ActionEvent;

public class ActionListener implements java.awt.event.ActionListener {
    private PlaneController planeController;

    public ActionListener(PlaneController planeController) {
        System.out.println("ActionListener执行了构造函数一次");
        this.planeController = planeController;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "login":
                break;
            case "code":
                break;
            case "start":
                break;
            case "end":
                break;
        }
    }
}
