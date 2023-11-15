package com.dyspersja.console.operations;

import com.dyspersja.console.ConsoleMessageWriter;

import java.util.Scanner;

public class SelectOperation {

    private final ConsoleMessageWriter messageWriter;
    private final Scanner input;

    public SelectOperation(Scanner input, ConsoleMessageWriter messageWriter) {
        this.messageWriter = messageWriter;
        this.input = input;
    }

    public void start() {

    }
}
