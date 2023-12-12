package com.dyspersja.window.components.menu;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class FileMenu extends JMenu {

    public FileMenu() {
        setText("File");
        setMnemonic(KeyEvent.VK_F);
    }
}
