package com.dyspersja.window.components;

import com.dyspersja.window.components.menu.MainMenuBar;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    @Getter
    private static MainFrame instance;

    private final MainMenuBar menuBar;
    private final CenterPanel centerPanel;
    private final LeftPanel leftPanel;

    public MainFrame() {
        setLayout(new BorderLayout());
        setSize(700,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.menuBar = new MainMenuBar();
        setJMenuBar(menuBar);

        this.centerPanel = new CenterPanel();
        add(centerPanel, BorderLayout.CENTER);

        this.leftPanel = new LeftPanel();
        leftPanel.addObserver(centerPanel);
        leftPanel.addObserver(menuBar);
        add(leftPanel, BorderLayout.WEST);

        instance = this;
    }
}
