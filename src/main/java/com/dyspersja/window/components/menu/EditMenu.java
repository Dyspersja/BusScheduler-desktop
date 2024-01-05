package com.dyspersja.window.components.menu;

import com.dyspersja.window.*;

import javax.swing.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class EditMenu extends JMenu implements RowSelectionChangeListener {

    private final JMenuItem addMenuItem;
    private final JMenuItem deleteMenuItem;
    private final JMenuItem updateMenuItem;

    public EditMenu() {
        setText("Edit");
        setMnemonic(KeyEvent.VK_E);

        this.addMenuItem = new JMenuItem("Add");
        initializeAddMenuItem();
        this.deleteMenuItem = new JMenuItem("Delete");
        initializeDeleteMenuItem();
        this.updateMenuItem = new JMenuItem("Update");
        initializeUpdateMenuItem();

        RowSelectionChangeService.getInstance().addObserver(this);
    }

    private void initializeAddMenuItem() {
        addMenuItem.addActionListener(new AddActionListener());
        addMenuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));

        add(addMenuItem);
    }

    private void initializeDeleteMenuItem() {
        deleteMenuItem.addActionListener(new DeleteActionListener());
        deleteMenuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_DELETE, 0));

        add(deleteMenuItem);
    }

    private void initializeUpdateMenuItem() {
        updateMenuItem.addActionListener(new UpdateActionListener());
        updateMenuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_F, InputEvent.CTRL_DOWN_MASK));

        add(updateMenuItem);
    }

    @Override
    public void onRowSelect(Long id) {
        deleteMenuItem.setEnabled(true);
        updateMenuItem.setEnabled(true);
    }

    @Override
    public void onRowDeselect() {
        deleteMenuItem.setEnabled(false);
        updateMenuItem.setEnabled(false);
    }
}
