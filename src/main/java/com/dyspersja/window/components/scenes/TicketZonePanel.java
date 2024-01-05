package com.dyspersja.window.components.scenes;

import com.dyspersja.database.tables.ticketzone.TicketZoneService;
import com.dyspersja.window.*;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
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
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 0
                        ? Long.class
                        : super.getColumnClass(columnIndex);
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
                        table.setRowSelectionInterval(row, row);
                        showContextMenu(e);
                    }
                }
            }
        });

        initializeSelectionModel();
        initializeFilterPanel();
        initializeCellRenderer();

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

        JMenuItem updateMenuItem = new JMenuItem("Update");
        JMenuItem deleteMenuItem = new JMenuItem("Delete");

        updateMenuItem.addActionListener(new UpdateActionListener());
        deleteMenuItem.addActionListener(new DeleteActionListener());

        contextMenu.add(updateMenuItem);
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

    private void initializeCellRenderer() {
        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setHorizontalAlignment(JLabel.LEFT);
        table.getColumnModel().getColumn(0).setCellRenderer(cellRenderer);
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
