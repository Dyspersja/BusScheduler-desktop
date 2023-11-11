package com.dyspersja;

import com.dyspersja.console.ConsoleInputHandler;
import com.dyspersja.properties.PropertiesLoader;

public class Main {
    public static void main( String[] args ) {
        PropertiesLoader.createInstance(args);

        var inputHandler = new ConsoleInputHandler();
        inputHandler.start();
    }
}
