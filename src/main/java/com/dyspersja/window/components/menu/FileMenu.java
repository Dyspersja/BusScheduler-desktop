package com.dyspersja.window.components.menu;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class FileMenu extends JMenu {

    private final JMenuItem exitMenuItem;

    public FileMenu() {
        setText("File");
        setMnemonic(KeyEvent.VK_F);

        this.exitMenuItem = new JMenuItem("Exit");
        initializeExitMenuItem();
    }

    private void initializeExitMenuItem() {
        exitMenuItem.addActionListener(e -> System.exit(0));
        add(exitMenuItem);
    }
}
