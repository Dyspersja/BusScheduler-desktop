package com.dyspersja.console.operations;

import com.dyspersja.database.tables.BusStop.BusStopColumns;
import com.dyspersja.database.tables.BusStop.BusStopEntity;
import com.dyspersja.database.tables.BusStop.BusStopService;

import java.util.List;

public class SelectOperation {

    private final BusStopService service;

    public SelectOperation() {
        this.service = new BusStopService();
    }

    public void start() {
        List<BusStopEntity> busStops = service.findAll();
        if (busStops.isEmpty()) {
            System.out.println("There are no bus stops to display");
            return;
        }

        printTable(busStops);
    }

    private void printTable(List<BusStopEntity> busStops) {
        BusStopColumns[] headers = BusStopColumns.values();
        int[] columnWidths = calculateColumnWidths(busStops);

        printTableLine(columnWidths);
        printHeaderRow(columnWidths,headers);
        printTableLine(columnWidths);

        busStops.forEach(busStop -> printDataRow(columnWidths, busStop));

        printTableLine(columnWidths);
    }

    private int[] calculateColumnWidths(List<BusStopEntity> busStops) {
        BusStopColumns[] headers = BusStopColumns.values();
        int[] columnWidths = new int[headers.length];

        for (int i = 0; i < headers.length; i++)
            columnWidths[i] = headers[i].getColumnName().length();

        for (BusStopEntity busStop : busStops) {
            for (int i = 0; i < headers.length; i++) {
                columnWidths[i] = Math.max(columnWidths[i], getValueWidth(busStop, headers[i]));
            }
        }
        return columnWidths;
    }

    private int getValueWidth(BusStopEntity busStop, BusStopColumns column) {
        return switch(column) {
            case ID -> String.valueOf(busStop.getId()).length();
            case NUMBER -> String.valueOf(busStop.getNumber()).length();
            case CITY -> busStop.getCity().length();
            case STREET -> busStop.getStreet().length();
            case LATITUDE -> String.valueOf(busStop.getLatitude()).length();
            case LONGITUDE -> String.valueOf(busStop.getLongitude()).length();
        };
    }

    private void printTableLine(int[] columnWidths) {
        for (int columnWidth : columnWidths)
            System.out.print("+" + "-".repeat(columnWidth + 2));

        System.out.print("+");
        System.out.println();
    }

    private void printHeaderRow(int[] columnWidths, BusStopColumns[] headers) {
        for (int i = 0; i < columnWidths.length; i++)
            System.out.printf("| %-"+ columnWidths[i] + "s ", headers[i].getColumnName());

        System.out.print("|");
        System.out.println();
    }

    private void printDataRow(int[] columnWidths, BusStopEntity busStop) {
        System.out.printf("| %"+ columnWidths[0] + "s ", busStop.getId());
        System.out.printf("| %"+ columnWidths[1] + "s ", busStop.getNumber());
        System.out.printf("| %-"+ columnWidths[2] + "s ", busStop.getCity());
        System.out.printf("| %-"+ columnWidths[3] + "s ", busStop.getStreet());
        System.out.printf("| %"+ columnWidths[4] + "s ", busStop.getLatitude());
        System.out.printf("| %"+ columnWidths[5] + "s ", busStop.getLongitude());

        System.out.print("|");
        System.out.println();
    }
}
