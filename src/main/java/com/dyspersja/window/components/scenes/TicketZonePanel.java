package com.dyspersja.window.components.scenes;

import com.dyspersja.database.tables.ticketzone.TicketZoneService;
import com.dyspersja.window.RowSelectionChangeService;
import com.dyspersja.window.Scene;
import com.dyspersja.window.SceneChangeListener;
import com.dyspersja.window.SceneChangeService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TicketZonePanel extends JPanel implements SceneChangeListener {

    private final JTable table;
    private final JScrollPane scrollPane;
    private final DefaultTableModel model;
    private final TableRowSorter<TableModel> sorter;

    public TicketZonePanel() {
        setLayout(new BorderLayout());

        model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        model.addColumn("ID");
        model.addColumn("Zone Name");

        sorter = new TableRowSorter<>(model);

        table = new JTable();
        table.setRowSorter(sorter);
        table.setModel(model);

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {
                    int row = table.rowAtPoint(e.getPoint());
                    if (row != -1) {
                        Object idValue = table.getValueAt(row, 0);
                        if(idValue instanceof Long id) {
                            RowSelectionChangeService.getInstance().changeSelectedRowId(id);
                        }
                        table.setRowSelectionInterval(row, row);
                        showContextMenu(e);
                    }
                }
            }
        });

        initializeSelectionModel();
        initializeFilterPanel();

        scrollPane = new JScrollPane();
        scrollPane.setViewportView(table);
        add(scrollPane,BorderLayout.CENTER);

        SceneChangeService.getInstance().addObserver(this);
    }

    private void showContextMenu(MouseEvent e) {
        JPopupMenu contextMenu = createContextMenu();
        contextMenu.show(e.getComponent(), e.getX(), e.getY());
    }

    private JPopupMenu createContextMenu() {
        JPopupMenu contextMenu = new JPopupMenu();

        JMenuItem editMenuItem = new JMenuItem("Edit");
        JMenuItem deleteMenuItem = new JMenuItem("Delete");

        contextMenu.add(editMenuItem);
        contextMenu.add(deleteMenuItem);

        return contextMenu;
    }

    private void initializeSelectionModel() {
        ListSelectionModel selectionModel = table.getSelectionModel();
        selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        selectionModel.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    Object idValue = table.getValueAt(selectedRow, 0);
                    if(idValue instanceof Long id) {
                        RowSelectionChangeService.getInstance().changeSelectedRowId(id);
                    }
//                    JOptionPane.showMessageDialog(this, "Selected ID: " + idValue);
                }
            }
        });
    }

    private void initializeFilterPanel() {
        JPanel filterPanel = new JPanel(new BorderLayout());
        filterPanel.add(new JLabel("Filter: "),BorderLayout.WEST);

        JTextField filterTextField = new JTextField();
        filterTextField.addActionListener(e -> applyFilter(filterTextField.getText()));
        filterPanel.add(filterTextField,BorderLayout.CENTER);

        filterPanel.setBorder(BorderFactory.createEmptyBorder(5, 30, 5, 30));
        add(filterPanel, BorderLayout.NORTH);
    }

    private void applyFilter(String text) {
        sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
    }

    private void loadData() {
        model.setRowCount(0);
        new TicketZoneService().getAll().forEach(ticketZone ->
                model.addRow(new Object[]{ticketZone.getId(), ticketZone.getZoneName()}));
    }

    @Override
    public void onSceneChange(Scene scene) {
        if (scene == Scene.TICKET_ZONES) loadData();
    }
}
