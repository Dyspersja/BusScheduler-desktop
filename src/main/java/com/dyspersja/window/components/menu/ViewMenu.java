package com.dyspersja.window.components.menu;

import com.dyspersja.window.Scene;
import com.dyspersja.window.SceneChangeListener;
import com.dyspersja.window.SceneChangeService;
import com.dyspersja.window.components.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

public class ViewMenu extends JMenu implements SceneChangeListener {

    private Rectangle windowBounds;

    private final JMenuItem fullScreenMenuItem;
    private final Map<JMenuItem, Scene> sceneMenuItems = new HashMap<>();

    public ViewMenu() {
        setText("View");
        setMnemonic(KeyEvent.VK_V);

        this.fullScreenMenuItem = new JMenuItem("Full Screen");
        initializeFullScreenMenuItem();

        addSeparator();

        SceneChangeService sceneChangeService = SceneChangeService.getInstance();
        for (Scene scene : Scene.values()) {
            JMenuItem sceneMenuItem = new JMenuItem(scene.toString());
            sceneMenuItem.addActionListener(e -> sceneChangeService.changeScene(scene));
            sceneMenuItems.put(sceneMenuItem, scene);

            add(sceneMenuItem);
        }

        sceneChangeService.addObserver(this);
    }

    private void initializeFullScreenMenuItem() {
        fullScreenMenuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_F11,0));

        fullScreenMenuItem.addActionListener(e -> {
            JFrame frame = MainFrame.getInstance();

            if (!frame.isUndecorated()) {
                windowBounds = frame.getBounds();
                frame.dispose();
                frame.setUndecorated(true);
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                frame.setVisible(true);
            } else {
                frame.dispose();
                frame.setUndecorated(false);
                frame.setVisible(true);
                frame.setBounds(windowBounds);
            }
        });

        add(fullScreenMenuItem);
    }

    @Override
    public void onSceneChange(Scene scene) {
        sceneMenuItems.forEach((menuItem, menuItemScene) -> menuItem.setEnabled(menuItemScene != scene));
    }
}
