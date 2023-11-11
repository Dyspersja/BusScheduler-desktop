package com.dyspersja.database;

import com.dyspersja.console.ConsoleCommands;

public enum DatabaseOperations {

    SELECT("select", "s"),
    UPDATE("update", "u"),
    DELETE("delete", "d"),
    INSERT("insert", "i");

    private final String longForm;
    private final String shortForm;

    DatabaseOperations(String longForm, String shortForm) {
        this.longForm = longForm;
        this.shortForm = shortForm;
    }

    public String getLongForm() {
        return longForm;
    }

    public String getShortForm() {
        return shortForm;
    }

    public ConsoleCommands toConsoleCommand() {
        return switch (this) {
            case SELECT -> ConsoleCommands.SELECT;
            case UPDATE -> ConsoleCommands.UPDATE;
            case DELETE -> ConsoleCommands.DELETE;
            case INSERT -> ConsoleCommands.INSERT;
        };
    }
}
