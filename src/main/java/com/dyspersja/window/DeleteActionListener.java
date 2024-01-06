package com.dyspersja.window;

import com.dyspersja.database.tables.ticketzone.TicketZoneService;
import com.dyspersja.window.components.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        Scene scene = SceneChangeService.getInstance().getScene();
        Long id = RowSelectionChangeService.getInstance().getSelectedRowId();

        int option = JOptionPane.showConfirmDialog(
                MainFrame.getInstance(),
                "Are you sure you want to delete record with id: " + id,
                "Confirmation",
                JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            new TicketZoneService().delete(id);
            reloadScene();
        }
    }

    private void reloadScene() {
        OperationService operationService = OperationService.getInstance();

        operationService.suppressChangeNotifications();
        SceneChangeService.getInstance().reloadScene();
        operationService.resumeChangeNotifications();
    }
}
