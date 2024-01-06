package com.dyspersja.window;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OperationService {

    private static OperationService instance;

    private final List<OperationListener> observers = new ArrayList<>();

    public static OperationService getInstance() {
        if (instance == null) {
            instance = new OperationService();
        }
        return instance;
    }

    public void addObserver(OperationListener observer) {
        observers.add(observer);
    }

    public void performOperation(String description) {
        notifyObservers(description);
    }

    private void notifyObservers(String description) {
        for (OperationListener observer : observers) {
            observer.onOperationPerformed(description);
        }
    }
}
