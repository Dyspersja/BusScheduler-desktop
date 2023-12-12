package com.dyspersja.window;

import com.dyspersja.window.components.MainFrame;

public class WindowController {

    private final MainFrame frame;

    public WindowController() {
        frame = new MainFrame();
    }

    public void initialize() {
        frame.setVisible(true);
    }
}
