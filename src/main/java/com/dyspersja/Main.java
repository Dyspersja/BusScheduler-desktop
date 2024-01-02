package com.dyspersja;

import com.dyspersja.properties.PropertiesLoader;
import com.dyspersja.window.WindowController;

public class Main {
    public static void main( String[] args ) {
        PropertiesLoader.createInstance(args);

        var window = new WindowController();
        window.initialize();
    }
}
