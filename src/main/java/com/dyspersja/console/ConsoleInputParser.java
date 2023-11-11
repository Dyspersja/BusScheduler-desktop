package com.dyspersja.console;

import com.dyspersja.database.DatabaseOperations;

import java.util.Optional;

public class ConsoleInputParser {

    public ConsoleCommands parseUserInput(String userInput) {
        if (parseExitCommand(userInput)) return ConsoleCommands.EXIT;
        if (parseHelpCommand(userInput)) return ConsoleCommands.HELP;
        return parseDatabaseOperation(userInput)
                .map(DatabaseOperations::toConsoleCommand)
                .orElse(ConsoleCommands.INVALID_COMMAND);
    }

    private Optional<DatabaseOperations> parseDatabaseOperation(String userInput) {
        return switch (userInput.toLowerCase()) {
            case "select", "s" -> Optional.of(DatabaseOperations.SELECT);
            case "update", "u" -> Optional.of(DatabaseOperations.UPDATE);
            case "delete", "d" -> Optional.of(DatabaseOperations.DELETE);
            case "insert", "i" -> Optional.of(DatabaseOperations.INSERT);
            default -> Optional.empty();
        };
    }

    private boolean parseHelpCommand(String userInput) {
        return userInput.equalsIgnoreCase("help");
    }

    private boolean parseExitCommand(String userInput) {
        return userInput.equalsIgnoreCase("exit");
    }
}