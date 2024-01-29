package asia.lhweb.skyassault.controller.Listener;

import asia.lhweb.skyassault.controller.PlaneController;

import java.awt.event.ActionEvent;

public class ActionListener implements java.awt.event.ActionListener {
    private PlaneController planeController;

    public ActionListener(PlaneController planeController) {
        this.planeController = planeController;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
