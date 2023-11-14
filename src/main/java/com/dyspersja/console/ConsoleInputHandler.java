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

            switch(parser.parseUserInput(userInput)) {
                case INVALID_COMMAND ->
                        messageWriter.printInvalidCommandMessage(userInput);

                case HELP ->
                        messageWriter.printHelpMessage();
                case EXIT -> {
                    messageWriter.printExitMessage();
                    isRunning = false;
                }

                case INSERT -> goToInsertOperation();
                case DELETE -> goToDeleteOperation();
                case UPDATE -> goToUpdateOperation();
                case SELECT -> goToSelectOperation();
            }
        }
    }

    private void goToInsertOperation() {

    }

    private void goToDeleteOperation() {

    }

    private void goToUpdateOperation() {

    }

    private void goToSelectOperation() {

    }
}
