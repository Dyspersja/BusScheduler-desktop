package com.dyspersja.window.components.menu;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class ViewMenu extends JMenu {

    public ViewMenu() {
        setText("View");
        setMnemonic(KeyEvent.VK_V);
    }
}
