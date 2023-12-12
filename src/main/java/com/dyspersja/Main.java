package com.dyspersja;

import com.dyspersja.database.DatabaseConnection;
import com.dyspersja.properties.PropertiesLoader;
import com.dyspersja.window.WindowController;

public class Main {
    public static void main( String[] args ) {
        PropertiesLoader.createInstance(args);

        Runtime.getRuntime().addShutdownHook(new Thread(() ->
                DatabaseConnection.getInstance().closeConnection()));

        //var inputHandler = new ConsoleInputHandler();
        //inputHandler.initialize();

        var window = new WindowController();
        window.initialize();
    }
}
