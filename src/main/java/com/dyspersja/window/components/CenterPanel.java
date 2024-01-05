package com.dyspersja.window.components;

import com.dyspersja.window.Scene;
import com.dyspersja.window.SceneChangeListener;
import com.dyspersja.window.SceneChangeService;
import com.dyspersja.window.components.scenes.TicketZonePanel;

import javax.swing.*;
import java.awt.*;

public class CenterPanel extends JPanel implements SceneChangeListener {

    private final TicketZonePanel ticketZonePanel;

    private final CardLayout cardLayout;

    public CenterPanel() {
        this.ticketZonePanel = new TicketZonePanel();

        this.cardLayout = new CardLayout();
        setLayout(cardLayout);

        add(createScenePanel("Scene 1 Content"), Scene.SCENE_1.toString());
        add(createScenePanel("Scene 2 Content"), Scene.SCENE_2.toString());
        add(createScenePanel("Scene 3 Content"), Scene.SCENE_3.toString());
        add(ticketZonePanel, Scene.TICKET_ZONES.toString());

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
