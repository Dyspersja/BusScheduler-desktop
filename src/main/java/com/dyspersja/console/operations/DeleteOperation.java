package com.dyspersja.console.operations;

import com.dyspersja.console.ConsoleMessageWriter;
import com.dyspersja.database.tables.BusStop.BusStopEntity;
import com.dyspersja.database.tables.BusStop.BusStopService;

import java.util.Optional;
import java.util.Scanner;

public class DeleteOperation {

    private final ConsoleMessageWriter messageWriter;
    private final Scanner input;

    public DeleteOperation(Scanner input, ConsoleMessageWriter messageWriter) {
        this.messageWriter = messageWriter;
        this.input = input;
    }

    public void start() {
        messageWriter.printInitialDeleteOperationMessage();

        while (true) {
            if (input.hasNextInt()) {
                int busStopId = input.nextInt();
                input.nextLine();

                BusStopService service = new BusStopService();
                if (!service.existsById(busStopId))
                    System.out.printf("bus stop with id: '%d' does not exist\n", busStopId);
                else {
                    service.deleteById(busStopId);
                    System.out.printf("successfully deleted bus stop with id: '%d'\n", busStopId);
                    break;
                }
            } else if (input.nextLine().equals("back")) {
                System.out.println("Going back to main mode");
                break;
            }
            else System.out.println("Invalid input. Please enter a valid number.");
        }
    }
}
