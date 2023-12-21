package com.dyspersja.window.components;

import com.dyspersja.window.Scene;
import com.dyspersja.window.SceneChangeListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class StatusBar extends Box implements SceneChangeListener {

    public StatusBar() {
        super(BoxLayout.X_AXIS);
        setPreferredSize(new Dimension(Integer.MAX_VALUE, 20));
        setBorder(new EmptyBorder(0, 5, 0, 5));

        JLabel label = new JLabel("Test1");
        add(label);
//        add(new JSeparator(SwingConstants.VERTICAL));
        add(Box.createHorizontalGlue());
        JLabel label1 = new JLabel("Test2");
        add(label1);
    }

    @Override
    public void onSceneChange(Scene scene) {
        // do nothing
    }
}