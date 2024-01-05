package com.dyspersja.window;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        SceneChangeService.getInstance().reloadScene();
    }
}
