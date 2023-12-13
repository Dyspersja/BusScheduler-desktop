package com.dyspersja.window.components;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {

    private final CardLayout cardLayout;

    public MainPanel() {
        this.cardLayout = new CardLayout();
        setLayout(cardLayout);

        add(createScenePanel("Scene 1 Content"), "Scene 1");
        add(createScenePanel("Scene 2 Content"), "Scene 2");
        add(createScenePanel("Scene 3 Content"), "Scene 3");
    }

    private JPanel createScenePanel(String content) {
        JPanel scenePanel = new JPanel();
        scenePanel.add(new JLabel(content));
        return scenePanel;
    }

    public void showScene(String sceneName) {
        cardLayout.show(this, sceneName);
    }
}
