package com.dyspersja.window;

import com.dyspersja.database.DatabaseSessionManager;
import com.dyspersja.window.components.MainFrame;

public class WindowController {

    private final MainFrame frame;

    public WindowController() {
        SplashScreen splashScreen = new SplashScreen();
        DatabaseSessionManager.getInstance();
        splashScreen.dispose();

        frame = new MainFrame();
    }

    public void initialize() {
        frame.setVisible(true);
    }
}
