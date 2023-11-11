package com.dyspersja.console;

import com.dyspersja.database.DatabaseOperations;

import java.util.Scanner;

public class ConsoleInputHandler {

    public void start() {
        var messageWriter = new ConsoleMessageWriter();
        messageWriter.printWelcomeMessage();
        runLoop();
    }

    private void runLoop() {
        boolean isRunning = true;
        Scanner input = new Scanner(System.in);
        ConsoleInputParser parser = new ConsoleInputParser();

        while(isRunning) {
            String userInput = input.nextLine();

            if(parser.parseHelpCommand(userInput)) System.out.println("HELP_MESSAGE");
            else if(parser.parseExitCommand(userInput)) {
                System.out.println("execute exit command");
                isRunning = false;
                break;
            }
            else {
                DatabaseOperations operation = parser.parseDatabaseOperation(userInput);
                System.out.println(operation);
            }
        }
    }
}
