package com.dyspersja.window.components.menu;

import com.dyspersja.window.Scene;
import com.dyspersja.window.SceneChangeListener;
import com.dyspersja.window.SceneChangeService;
import com.dyspersja.window.components.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class ViewMenu extends JMenu implements SceneChangeListener {

    private Rectangle windowBounds;

    private final JMenuItem fullScreenMenuItem;
    private final JMenuItem scene1;
    private final JMenuItem scene2;
    private final JMenuItem scene3;

    public ViewMenu() {
        setText("View");
        setMnemonic(KeyEvent.VK_V);

        this.fullScreenMenuItem = new JMenuItem("Full Screen");
        initializeFullScreenMenuItem();
        addSeparator();

        this.scene1 = new JMenuItem(Scene.SCENE_1.toString());
        add(scene1);
        this.scene2 = new JMenuItem(Scene.SCENE_2.toString());
        add(scene2);
        this.scene3 = new JMenuItem(Scene.SCENE_3.toString());
        add(scene3);

        addMenuItemListeners();

        SceneChangeService.getInstance().addObserver(this);
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

    private void addMenuItemListeners() {
        SceneChangeService sceneChangeService = SceneChangeService.getInstance();
        scene1.addActionListener(e -> sceneChangeService.changeScene(Scene.SCENE_1));
        scene2.addActionListener(e -> sceneChangeService.changeScene(Scene.SCENE_2));
        scene3.addActionListener(e -> sceneChangeService.changeScene(Scene.SCENE_3));
    }

    @Override
    public void onSceneChange(Scene scene) {
        scene1.setEnabled(true);
        scene2.setEnabled(true);
        scene3.setEnabled(true);
        switch (scene) {
            case SCENE_1 -> scene1.setEnabled(false);
            case SCENE_2 -> scene2.setEnabled(false);
            case SCENE_3 -> scene3.setEnabled(false);
        }
    }
}
