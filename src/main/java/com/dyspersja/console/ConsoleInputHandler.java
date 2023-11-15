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

    public void initialize() {
        this.messageWriter = new ConsoleMessageWriter();
        this.parser = new ConsoleInputParser();
        this.input = new Scanner(System.in);

        messageWriter.printWelcomeMessage();

        start();
        close();
    }

    private void start() {
        boolean isRunning = true;

        var insert = new InsertOperation(input);
        var delete = new DeleteOperation(input);
        var update = new UpdateOperation(input);
        var select = new SelectOperation(input);

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

                case INSERT -> insert.start();
                case DELETE -> delete.start();
                case UPDATE -> update.start();
                case SELECT -> select.start();
            }
        }
    }

    private void close() {
        input.close();
    }
}
