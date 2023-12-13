package com.dyspersja.window.components;

import javax.swing.*;

public class AboutDialog extends JDialog {

    public AboutDialog(JFrame parent) {
        setTitle("About");
        setModal(true);
        setSize(300, 150);
        setLocationRelativeTo(parent);
    }
}
