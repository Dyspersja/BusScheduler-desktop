package com.dyspersja.window;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OperationService {

    private static OperationService instance;

    private final List<OperationListener> observers = new ArrayList<>();
    private boolean isListening = true;

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
        if (isListening) {
            observers.forEach(observer -> observer.onOperationPerformed(description));
        }
    }

    public void suppressChangeNotifications() {
        this.isListening = false;
    }

    public void resumeChangeNotifications() {
        this.isListening = true;
    }
}
