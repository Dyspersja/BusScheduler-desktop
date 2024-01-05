package com.dyspersja.window.components;

import com.dyspersja.window.RowSelectionChangeService;
import com.dyspersja.window.Scene;
import com.dyspersja.window.SceneChangeService;
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
    private final StatusBar statusBar;

    public MainFrame() {
        setLayout(new BorderLayout());
        setSize(700,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        this.menuBar = new MainMenuBar();
        setJMenuBar(menuBar);

        this.centerPanel = new CenterPanel();
        add(centerPanel, BorderLayout.CENTER);

        this.statusBar = new StatusBar();
        add(statusBar,BorderLayout.SOUTH);

        this.leftPanel = new LeftPanel();
        add(leftPanel, BorderLayout.WEST);

        instance = this;
        SceneChangeService.getInstance().changeScene(Scene.values()[0]);
        RowSelectionChangeService.getInstance().changeSelectedRowId(null);
    }
}
