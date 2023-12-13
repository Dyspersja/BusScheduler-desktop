package com.dyspersja.window.components.menu;

import com.dyspersja.window.SceneChangeListener;

import javax.swing.*;

public class MainMenuBar extends JMenuBar implements SceneChangeListener {

    private final FileMenu fileMenu;
    private final EditMenu editMenu;
    private final ViewMenu viewMenu;
    private final HelpMenu helpMenu;

    public MainMenuBar() {
        fileMenu = new FileMenu();
        editMenu = new EditMenu();
        viewMenu = new ViewMenu();
        helpMenu = new HelpMenu();

        add(fileMenu);
        add(editMenu);
        add(viewMenu);
        add(helpMenu);
    }

    @Override
    public void onSceneChange(String sceneName) {
        // do nothing
    }
}
