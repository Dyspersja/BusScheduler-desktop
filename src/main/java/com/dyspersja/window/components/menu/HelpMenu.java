package com.dyspersja.window.components.menu;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class HelpMenu extends JMenu {

    public HelpMenu() {
        setText("Help");
        setMnemonic(KeyEvent.VK_H);
    }
}
