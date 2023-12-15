package com.dyspersja.window.components.menu;

import com.dyspersja.window.components.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class ViewMenu extends JMenu {

    private final JMenuItem fullScreenMenuItem;

    public ViewMenu() {
        setText("View");
        setMnemonic(KeyEvent.VK_V);

        this.fullScreenMenuItem = new JMenuItem("Full Screen");
        initializeFullScreenMenuItem();
    }

    private void initializeFullScreenMenuItem() {
        fullScreenMenuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_F11,0));

        fullScreenMenuItem.addActionListener(e -> {
            JFrame frame = MainFrame.getInstance();

            GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();

            if (!frame.isUndecorated()) {
                frame.dispose();
                frame.setUndecorated(true);
                frame.setVisible(true);
                device.setFullScreenWindow(frame);
            } else {
                device.setFullScreenWindow(null);
                frame.dispose();
                frame.setUndecorated(false);
                frame.setVisible(true);
            }
        });

        add(fullScreenMenuItem);
    }
}
