package com.dyspersja.window.components;

import com.dyspersja.window.components.menu.MainMenuBar;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private final MainMenuBar menuBar;

    public MainFrame() {
        menuBar = new MainMenuBar();
        setJMenuBar(menuBar);

        setLayout(new BorderLayout());
        setSize(700,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
