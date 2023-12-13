package com.dyspersja.window.components;

import com.dyspersja.window.components.menu.MainMenuBar;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    @Getter
    private static MainFrame instance;

    private final MainMenuBar menuBar;
    private final MainPanel mainPanel;
    private final LeftPanel leftPanel;

    public MainFrame() {
        setLayout(new BorderLayout());
        setSize(700,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.menuBar = new MainMenuBar();
        setJMenuBar(menuBar);

        this.mainPanel = new MainPanel();
        add(mainPanel, BorderLayout.CENTER);

        this.leftPanel = new LeftPanel();

        this.leftPanel.addButton1ActionListener(l ->
            this.mainPanel.showScene("Scene 1"));
        this.leftPanel.addButton2ActionListener(l ->
            this.mainPanel.showScene("Scene 2"));
        this.leftPanel.addButton3ActionListener(l ->
            this.mainPanel.showScene("Scene 3"));

        add(leftPanel, BorderLayout.WEST);

        instance = this;
    }
}
