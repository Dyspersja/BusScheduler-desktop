package com.dyspersja.window.components;

import com.dyspersja.window.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class StatusBar extends Box implements SceneChangeListener, RowSelectionChangeListener, OperationListener {

    private final JLabel sceneLabel;
    private final JLabel currentScene;
    private final JLabel selectedRowLabel;
    private final JLabel currentSelectedRow;
    private final JLabel operationLabel;
    private final JLabel lastOperationPerformed;

    public StatusBar() {
        super(BoxLayout.X_AXIS);
        setPreferredSize(new Dimension(Integer.MAX_VALUE, 20));
        setBorder(new EmptyBorder(0, 5, 0, 5));

        this.operationLabel = new JLabel("Last operation: ");
        add(this.operationLabel);
        this.lastOperationPerformed = new JLabel("N/A");
        add(this.lastOperationPerformed);

        add(Box.createRigidArea(new Dimension(10, 0)));

        this.selectedRowLabel = new JLabel("Selected row with ID: ");
        add(this.selectedRowLabel);
        this.currentSelectedRow = new JLabel("N/A");
        add(this.currentSelectedRow);

        add(Box.createHorizontalGlue());

        this.sceneLabel = new JLabel("Scene: ");
        add(this.sceneLabel);
        this.currentScene = new JLabel("N/A");
        add(this.currentScene);

        SceneChangeService.getInstance().addObserver(this);
        RowSelectionChangeService.getInstance().addObserver(this);
        OperationService.getInstance().addObserver(this);
    }

    @Override
    public void onSceneChange(Scene scene) {
        this.currentScene.setText(scene.toString());
    }

    @Override
    public void onRowSelect(Long id) {
        this.currentSelectedRow.setText(id.toString());

        this.selectedRowLabel.setVisible(true);
        this.currentSelectedRow.setVisible(true);
    }

    @Override
    public void onRowDeselect() {
        this.selectedRowLabel.setVisible(false);
        this.currentSelectedRow.setVisible(false);
    }

    @Override
    public void onOperationPerformed(String description) {
        this.lastOperationPerformed.setText(description);
    }
}