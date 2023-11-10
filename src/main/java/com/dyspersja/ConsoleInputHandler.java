package com.dyspersja;

import java.util.Scanner;

public class ConsoleInputHandler {
    private final String WELCOME_MESSAGE = """
            Welcome to Bus Transport Management application
            
            Enter name of the operation you want to perform
            type 'help' for a brief introduction and list of available commands.\s
            type 'exit' to close""";

    private final String HELP_MESSAGE = """
            Available commands:
            help - prints a list of commands with a brief description
            exit - closes the program
            
            Available operations:
            SELECT "select", "s"
            UPDATE "update", "u"
            DELETE "delete", "d"
            INSERT "insert", "i"
            """;

    public void start() {
        System.out.println(WELCOME_MESSAGE);

        runLoop();
    }

    private void runLoop() {
        boolean isRunning = true;
        Scanner input = new Scanner(System.in);
        UserInputParser parser = new UserInputParser();

        while(isRunning) {
            String userInput = input.nextLine();

            if(parser.parseHelpCommand(userInput)) System.out.println(HELP_MESSAGE);
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
