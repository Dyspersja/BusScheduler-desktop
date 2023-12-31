package com.dyspersja.window.components;

import com.dyspersja.window.Scene;
import com.dyspersja.window.SceneChangeService;

import javax.swing.*;
import java.awt.*;

public class LeftPanel extends JPanel {

    private final SceneChangeService sceneChangeService;

    private final JButton button1;
    private final JButton button2;
    private final JButton button3;

    public LeftPanel() {
        setLayout(new FlowLayout(FlowLayout.LEFT, 0, 5));
        setPreferredSize(new Dimension(200, Integer.MAX_VALUE));
        setBackground(Color.LIGHT_GRAY);

        this.button1 = new JButton("Scene 1");
        this.button2 = new JButton("Scene 2");
        this.button3 = new JButton("Scene 3");

        Dimension buttonSize = new Dimension(180, 30);
        this.button1.setPreferredSize(buttonSize);
        this.button2.setPreferredSize(buttonSize);
        this.button3.setPreferredSize(buttonSize);
        add(this.button1);
        add(this.button2);
        add(this.button3);

        addButtonListeners();

        this.sceneChangeService = SceneChangeService.getInstance();
    }

    private void addButtonListeners() {
        button1.addActionListener(e -> sceneChangeService.changeScene(Scene.SCENE_1));
        button2.addActionListener(e -> sceneChangeService.changeScene(Scene.SCENE_2));
        button3.addActionListener(e -> sceneChangeService.changeScene(Scene.SCENE_3));
    }
}
