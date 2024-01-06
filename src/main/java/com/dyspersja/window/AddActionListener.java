package com.dyspersja.window;

import com.dyspersja.database.tables.ticketzone.TicketZone;
import com.dyspersja.database.tables.ticketzone.TicketZoneService;
import com.dyspersja.window.components.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JTextField nameTextField = new JTextField(10);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel.add(new JLabel("Zone name:"));
        panel.add(nameTextField);

        int result = JOptionPane.showConfirmDialog(
                MainFrame.getInstance(),
                panel,
                "Add new Ticket Zone",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE
        );

        if (result == JOptionPane.OK_OPTION) {
            String textFieldValue = nameTextField.getText();
            if(!textFieldValue.isEmpty()) {
                new TicketZoneService().save(TicketZone.builder()
                        .zoneName(textFieldValue)
                        .build());
                reloadScene();
            } else {
                JOptionPane.showMessageDialog(
                        MainFrame.getInstance(),
                        "Zone name cannot be empty",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void reloadScene() {
        OperationService operationService = OperationService.getInstance();

        operationService.suppressChangeNotifications();
        SceneChangeService.getInstance().reloadScene();
        operationService.resumeChangeNotifications();
    }
}
