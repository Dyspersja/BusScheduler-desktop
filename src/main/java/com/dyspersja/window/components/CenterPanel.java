package com.dyspersja.window.components;

import com.dyspersja.window.Scene;
import com.dyspersja.window.SceneChangeListener;
import com.dyspersja.window.SceneChangeService;

import javax.swing.*;
import java.awt.*;

public class CenterPanel extends JPanel implements SceneChangeListener {

    private final CardLayout cardLayout;

    public CenterPanel() {
        this.cardLayout = new CardLayout();
        setLayout(cardLayout);

        add(createScenePanel("Scene 1 Content"), Scene.SCENE_1.toString());
        add(createScenePanel("Scene 2 Content"), Scene.SCENE_2.toString());
        add(createScenePanel("Scene 3 Content"), Scene.SCENE_3.toString());

        SceneChangeService.getInstance().addObserver(this);
    }

    private JPanel createScenePanel(String content) {
        JPanel scenePanel = new JPanel();
        scenePanel.add(new JLabel(content));
        return scenePanel;
    }

    private void showScene(String sceneName) {
        cardLayout.show(this, sceneName);
    }

    @Override
    public void onSceneChange(Scene scene) {
        showScene(scene.toString());
    }
}
