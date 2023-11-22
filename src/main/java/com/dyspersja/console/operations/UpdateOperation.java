package com.dyspersja.console.operations;

import com.dyspersja.console.ConsoleMessageWriter;
import com.dyspersja.database.tables.BusStop.BusStopColumns;
import com.dyspersja.database.tables.BusStop.BusStopEntity;
import com.dyspersja.database.tables.BusStop.BusStopService;

import java.util.Scanner;

public class UpdateOperation {

    private final ConsoleMessageWriter messageWriter;
    private final Scanner input;

    private final BusStopService service;

    public UpdateOperation(Scanner input, ConsoleMessageWriter messageWriter) {
        this.messageWriter = messageWriter;
        this.input = input;

        this.service = new BusStopService();
    }

    public void start() {
        messageWriter.printInitialUpdateOperationMessage();

        BusStopEntity busStop = getBusStopToUpdate();
        if (busStop == null) return;

        System.out.println("Selected bus stop:");
        displayBusStop(busStop);

        if (isForUpdate(BusStopColumns.NUMBER.getColumnName()))
            busStop.setNumber(getInt("Provide bus stop number:"));
        if (isForUpdate(BusStopColumns.CITY.getColumnName()))
            busStop.setCity(getString("Provide bus stop city:"));
        if (isForUpdate(BusStopColumns.STREET.getColumnName()))
            busStop.setStreet(getString("Provide bus stop street:"));
        if (isForUpdate(BusStopColumns.LATITUDE.getColumnName()))
            busStop.setLatitude(getDouble("Provide bus stop latitude:"));
        if (isForUpdate(BusStopColumns.LONGITUDE.getColumnName()))
            busStop.setLongitude(getDouble("Provide bus stop longitude:"));

        service.update(busStop);

        System.out.println("Going back to main mode");
    }

    public BusStopEntity getBusStopToUpdate() {
        while (true) {
            if (input.hasNextInt()) {
                int busStopId = input.nextInt();
                input.nextLine();

                if (!service.existsById(busStopId))
                    System.out.printf("bus stop with id: '%d' does not exist\n", busStopId);
                else {
                    return service.findById(busStopId).orElse(null);
                }
            } else if (input.nextLine().equals("back")) {
                System.out.println("Going back to main mode");
                break;
            } else System.out.println("Invalid input. Please enter a valid number.");
        }
        return null;
    }

    private void displayBusStop(BusStopEntity busStop) {
        System.out.printf("id = %d\n", busStop.getId());
        System.out.printf("number = %d\n", busStop.getNumber());
        System.out.printf("city = %s\n", busStop.getCity());
        System.out.printf("street = %s\n", busStop.getStreet());
        System.out.printf("latitude = %f\n", busStop.getLatitude());
        System.out.printf("longitude = %f\n", busStop.getLongitude());
    }

    private boolean isForUpdate(String columnName) {
        System.out.println("Do you want to change "+ columnName + " value?");
        System.out.println("write 'y' for yes, 'n' for no");

        while(true) {
            String userInput = input.nextLine();
            if (userInput.equals("n")) return false;
            else if (userInput.equals("y")) return true;
            else System.out.println("Invalid input, write 'y' or 'n'");
        }
    }

    private int getInt(String message) {
        System.out.println(message);

        while (!input.hasNextInt()) {
            input.nextLine();
            System.out.println("Invalid input. Please enter a valid number.");
        }
        int number = input.nextInt();
        input.nextLine();
        return number;
    }

    private String getString(String message) {
        System.out.println(message);
        return input.nextLine();
    }

    private double getDouble(String message) {
        System.out.println(message);

        while (!input.hasNextDouble()) {
            input.nextLine();
            System.out.println("Invalid input. Please enter a valid number. (use commas ',' instead of periods '.')");
        }
        double number = input.nextDouble();
        input.nextLine();
        return number;
    }
}
