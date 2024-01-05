package com.dyspersja.window;

import javax.swing.*;
import java.awt.*;

public class SplashScreen extends JWindow {

    public SplashScreen() {
        JPanel content = new JPanel(new BorderLayout());
        JLabel label = new JLabel("Loading...", JLabel.CENTER);
        content.add(label, BorderLayout.CENTER);

        setContentPane(content);
        setSize(200, 100);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
