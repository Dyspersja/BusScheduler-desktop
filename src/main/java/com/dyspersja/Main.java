package com.dyspersja;

import com.dyspersja.console.ConsoleInputHandler;
import com.dyspersja.database.DatabaseConnection;
import com.dyspersja.properties.PropertiesLoader;

public class Main {
    public static void main( String[] args ) {
        PropertiesLoader.createInstance(args);

        Runtime.getRuntime().addShutdownHook(new Thread(() ->
                DatabaseConnection.getInstance().closeConnection()));

        //var inputHandler = new ConsoleInputHandler();
        //inputHandler.initialize();
    }
}
