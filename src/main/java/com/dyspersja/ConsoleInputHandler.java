package com.dyspersja;

import java.util.Scanner;

public class ConsoleInputHandler {
    public void start() {
        System.out.println("Welcome to Bus Transport Management application" + "\n" +
                "Enter name of the operation you want to perform or type " +
                "'help' for a brief introduction and list of available commands.");

        runLoop();
    }

    private void runLoop() {
        boolean isRunning = true;
        Scanner input = new Scanner(System.in);

        while(isRunning) {
            String userInput = input.nextLine();
            System.out.println(userInput);
        }
    }
}
