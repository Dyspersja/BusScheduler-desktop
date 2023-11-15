package com.dyspersja.console;

import com.dyspersja.console.operations.DeleteOperation;
import com.dyspersja.console.operations.InsertOperation;
import com.dyspersja.console.operations.SelectOperation;
import com.dyspersja.console.operations.UpdateOperation;

import java.util.Scanner;

public class ConsoleInputHandler {

    private ConsoleMessageWriter messageWriter;
    private ConsoleInputParser parser;
    private Scanner input;

    private boolean isRunning;

    public void initialize() {
        this.messageWriter = new ConsoleMessageWriter();
        this.parser = new ConsoleInputParser();
        this.input = new Scanner(System.in);

        messageWriter.printWelcomeMessage();
        isRunning = true;

        start();
    }

    private void start() {
        var insert = new InsertOperation(input, messageWriter);
        var delete = new DeleteOperation(input, messageWriter);
        var update = new UpdateOperation(input, messageWriter);
        var select = new SelectOperation();

        while(isRunning) {
            String userInput = input.nextLine();

            switch(parser.parseUserInput(userInput)) {
                case INVALID_COMMAND -> printInvalidCommandMessage(userInput);

                case HELP -> printHelpMessage();
                case EXIT -> exit();

                case INSERT -> insert.start();
                case DELETE -> delete.start();
                case UPDATE -> update.start();
                case SELECT -> select.start();
            }
        }
    }

    private void printInvalidCommandMessage(String userInput) {
        messageWriter.printInvalidCommandMessage(userInput);
    }

    private void printHelpMessage() {
        messageWriter.printHelpMessage();
    }

    private void exit() {
        messageWriter.printExitMessage();
        isRunning = false;

        input.close();
    }
}
