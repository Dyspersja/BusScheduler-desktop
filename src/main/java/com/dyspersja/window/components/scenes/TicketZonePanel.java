package com.dyspersja.window.components.scenes;

import com.dyspersja.database.tables.ticketzone.TicketZone;
import com.dyspersja.database.tables.ticketzone.TicketZoneService;
import com.dyspersja.window.Scene;
import com.dyspersja.window.SceneChangeListener;
import com.dyspersja.window.SceneChangeService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.util.List;

public class TicketZonePanel extends JScrollPane implements SceneChangeListener {

    private final JTable table;
    private final DefaultTableModel model;

    public TicketZonePanel() {
        table = new JTable();
        setViewportView(table);

        model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        model.addColumn("ID");
        model.addColumn("Zone Name");

        table.setRowSorter(new TableRowSorter<>(model));
        table.setModel(model);

        ListSelectionModel selectionModel = table.getSelectionModel();
        selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        selectionModel.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    Object idValue = table.getValueAt(selectedRow, 0);
                    JOptionPane.showMessageDialog(this, "Selected ID: " + idValue);
                }
            }
        });

        SceneChangeService.getInstance().addObserver(this);
    }

    private void loadData() {
        TicketZoneService service = new TicketZoneService();
        List<TicketZone> ticketZones = service.getAll();

        model.setRowCount(0);
        for (TicketZone ticketZone : ticketZones) {
            model.addRow(new Object[]{ticketZone.getId(), ticketZone.getZoneName()});
        }
    }

    @Override
    public void onSceneChange(Scene scene) {
        if (scene == Scene.TICKET_ZONES) loadData();
    }
}
