package com.dyspersja.window;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        SceneChangeService.getInstance().changeScene(SceneChangeService.getInstance().getScene());
    }
}
