package com.dyspersja.database;

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
}
