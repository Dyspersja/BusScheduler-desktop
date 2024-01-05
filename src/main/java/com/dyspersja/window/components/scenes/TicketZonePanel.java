package com.dyspersja.window.components.scenes;

import com.dyspersja.database.tables.ticketzone.TicketZone;
import com.dyspersja.database.tables.ticketzone.TicketZoneService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class TicketZonePanel extends JScrollPane {

    private final JTable table;
    private final DefaultTableModel model;

    public TicketZonePanel() {
        table = new JTable();
        setViewportView(table);

        model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Zone Name");

        loadData();

        table.setModel(model);

        ListSelectionModel selectionModel = table.getSelectionModel();
        selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        selectionModel.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    // Retrieve the value from the "ID" column
                    Object idValue = table.getValueAt(selectedRow, 0);
                    JOptionPane.showMessageDialog(this, "Selected ID: " + idValue);
                }
            }
        });
    }

    private void loadData() {
        TicketZoneService service = new TicketZoneService();
        List<TicketZone> ticketZones = service.getAll();

        model.setRowCount(0);
        for (TicketZone ticketZone : ticketZones) {
            model.addRow(new Object[]{ticketZone.getId(), ticketZone.getZoneName()});
        }
    }
}
