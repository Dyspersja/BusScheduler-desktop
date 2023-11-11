package com.dyspersja.console;

import java.util.Scanner;

public class ConsoleInputHandler {

    public void start() {
        var messageWriter = new ConsoleMessageWriter();
        var parser = new ConsoleInputParser();
        var input = new Scanner(System.in);
        boolean isRunning = true;

        messageWriter.printWelcomeMessage();

        while(isRunning) {
            String userInput = input.nextLine();

            ConsoleCommands command = parser.parseUserInput(userInput);
        }
    }
}
