package com.dyspersja.console;

import java.util.Scanner;

public class ConsoleInputHandler {

    private ConsoleMessageWriter messageWriter;
    private ConsoleInputParser parser;
    private Scanner input;

    public void initialize() {
        this.messageWriter = new ConsoleMessageWriter();
        this.parser = new ConsoleInputParser();
        this.input = new Scanner(System.in);

        messageWriter.printWelcomeMessage();

        start();
    }

    private void start() {
        boolean isRunning = true;

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
        input.close();
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
