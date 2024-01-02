package com.dyspersja.window.components;

import com.dyspersja.window.Scene;
import com.dyspersja.window.SceneChangeListener;
import com.dyspersja.window.SceneChangeService;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class LeftPanel extends JPanel implements SceneChangeListener {

    private final Map<JButton, Scene> buttons = new HashMap<>();

    public LeftPanel() {
        setLayout(new FlowLayout(FlowLayout.LEFT, 0, 5));
        setPreferredSize(new Dimension(200, Integer.MAX_VALUE));
        setBackground(Color.LIGHT_GRAY);

        SceneChangeService sceneChangeService = SceneChangeService.getInstance();

        Dimension buttonSize = new Dimension(180, 30);
        for (Scene scene : Scene.values()) {
            JButton button = new JButton(scene.toString());
            button.setPreferredSize(buttonSize);
            buttons.put(button, scene);

            button.addActionListener(e -> sceneChangeService.changeScene(scene));

            add(button);
        }

        sceneChangeService.addObserver(this);
    }

    @Override
    public void onSceneChange(Scene scene) {
        buttons.forEach((button, buttonScene) -> button.setEnabled(buttonScene != scene));
    }
}
