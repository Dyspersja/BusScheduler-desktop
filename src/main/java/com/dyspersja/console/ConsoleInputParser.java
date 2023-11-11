package com.dyspersja.console;

import com.dyspersja.database.DatabaseOperations;

public class ConsoleInputParser {

    public DatabaseOperations parseDatabaseOperation(String userInput) {
        return switch (userInput.toLowerCase()) {
            case "select", "s" -> DatabaseOperations.SELECT;
            case "update", "u" -> DatabaseOperations.UPDATE;
            case "delete", "d" -> DatabaseOperations.DELETE;
            case "insert", "i" -> DatabaseOperations.INSERT;
            default -> throw new RuntimeException();
        };
    }

    public boolean parseHelpCommand(String userInput) {
        return userInput.equals("help");
    }

    public boolean parseExitCommand(String userInput) {
        return userInput.equals("exit");
    }
}
