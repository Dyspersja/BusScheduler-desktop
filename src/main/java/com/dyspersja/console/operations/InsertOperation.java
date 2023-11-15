package com.dyspersja.console.operations;

import com.dyspersja.console.ConsoleMessageWriter;
import com.dyspersja.database.tables.BusStop.BusStopEntity;
import com.dyspersja.database.tables.BusStop.BusStopService;

import java.util.Scanner;

public class InsertOperation {

    private final Scanner input;

    public InsertOperation(Scanner input) {
        this.input = input;
    }

    public void start() {
        System.out.println("Enter details for the new bus stop:");

        BusStopService service = new BusStopService();

        service.save(BusStopEntity.builder()
                .number(getInt("Provide bus stop number:"))
                .city(getString("Provide bus stop city:"))
                .street(getString("Provide bus stop street:"))
                .latitude(getDouble("Provide bus stop latitude:"))
                .longitude(getDouble("Provide bus stop longitude:"))
                .build());

        System.out.println("successfully added new bus stop");
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
            System.out.println("Invalid input. Please enter a valid number.");
        }
        double number = input.nextDouble();
        input.nextLine();
        return number;
    }

}
