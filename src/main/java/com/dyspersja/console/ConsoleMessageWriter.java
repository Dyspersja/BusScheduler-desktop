package com.dyspersja.console;

public class ConsoleMessageWriter {

    public void printWelcomeMessage() {
        final String welcomeMessage = """
            Welcome to Bus Transport Management application
            
            Enter name of the operation you want to perform
            type 'help' for a brief introduction and list of available commands.\s
            type 'exit' to close""";

        System.out.println(welcomeMessage);
    }

    public void printHelpMessage() {
        final String helpMessage = """
            Available commands:
            help - prints a list of commands with a brief description
            exit - closes the program
            
            Available operations:
            SELECT "select", "s" - Retrieve data from the database
            UPDATE "update", "u" - Modify existing data in the database
            DELETE "delete", "d" - Remove data from the database
            INSERT "insert", "i" - Add new data to the database
            """;

        System.out.println(helpMessage);
    }

    public void printInvalidCommandMessage(String userInput) {
        System.out.println("Invalid command: " + userInput);
        System.out.println("Use the 'help' command to see available commands");
    }

    public void printExitMessage() {
        System.out.println("Exiting the program. Goodbye!");
    }
}
