package com.dyspersja.window.components;

import com.dyspersja.window.Scene;
import com.dyspersja.window.SceneChangeListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class StatusBar extends Box implements SceneChangeListener {

    private final JLabel sceneLabel;
    private final JLabel currentScene;

    public StatusBar() {
        super(BoxLayout.X_AXIS);
        setPreferredSize(new Dimension(Integer.MAX_VALUE, 20));
        setBorder(new EmptyBorder(0, 5, 0, 5));

        this.sceneLabel = new JLabel("Scene: ");
        add(this.sceneLabel);
        this.currentScene = new JLabel("N/A");
        add(this.currentScene);

//        add(new JSeparator(SwingConstants.VERTICAL));
        add(Box.createHorizontalGlue());
        JLabel label1 = new JLabel("Test2");
        add(label1);
    }

    @Override
    public void onSceneChange(Scene scene) {
        this.currentScene.setText(scene.toString());
    }
}