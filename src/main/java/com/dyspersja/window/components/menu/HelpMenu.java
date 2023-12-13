package com.dyspersja.window.components.menu;

import com.dyspersja.window.components.AboutDialog;
import com.dyspersja.window.components.MainFrame;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class HelpMenu extends JMenu {

    private JMenuItem aboutMenuItem;

    public HelpMenu() {
        setText("Help");
        setMnemonic(KeyEvent.VK_H);

        initializeAboutMenuItem();
    }

    private void initializeAboutMenuItem() {
        aboutMenuItem = new JMenuItem("About");

        aboutMenuItem.addActionListener(l -> {
            AboutDialog aboutDialog = new AboutDialog(MainFrame.getInstance());
            aboutDialog.setVisible(true);
        });

        add(aboutMenuItem);
    }
}
