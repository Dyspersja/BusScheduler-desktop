package com.dyspersja.window.components.menu;

import com.dyspersja.window.components.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class ViewMenu extends JMenu {

    private Rectangle windowBounds;

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

            if (!frame.isUndecorated()) {
                windowBounds = frame.getBounds();
                frame.dispose();
                frame.setUndecorated(true);
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                frame.setVisible(true);
            } else {
                frame.dispose();
                frame.setUndecorated(false);
                frame.setVisible(true);
                frame.setBounds(windowBounds);
            }
        });

        add(fullScreenMenuItem);
    }
}
