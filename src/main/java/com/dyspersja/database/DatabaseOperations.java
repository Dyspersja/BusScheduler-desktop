package com.dyspersja.database;

import com.dyspersja.console.ConsoleCommands;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum DatabaseOperations {

    SELECT("select", "s"),
    UPDATE("update", "u"),
    DELETE("delete", "d"),
    INSERT("insert", "i");

    private final String longForm;
    private final String shortForm;

    public ConsoleCommands toConsoleCommand() {
        return switch (this) {
            case SELECT -> ConsoleCommands.SELECT;
            case UPDATE -> ConsoleCommands.UPDATE;
            case DELETE -> ConsoleCommands.DELETE;
            case INSERT -> ConsoleCommands.INSERT;
        };
    }
}
