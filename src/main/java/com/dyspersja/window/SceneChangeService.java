package com.dyspersja.window;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SceneChangeService {

    private static SceneChangeService instance;

    private final List<SceneChangeListener> observers = new ArrayList<>();
    private Scene currentScene;

    public static SceneChangeService getInstance() {
        if (instance == null) {
            instance = new SceneChangeService();
        }
        return instance;
    }

    public void addObserver(SceneChangeListener observer) {
        observers.add(observer);
    }

    public void changeScene(Scene scene) {
        this.currentScene = scene;
        notifyObservers(scene);
    }

    public void reloadScene() {
        changeScene(currentScene);
    }

    public Scene getScene() {
        return this.currentScene;
    }

    private void notifyObservers(Scene scene) {
        for (SceneChangeListener observer : observers) {
            observer.onSceneChange(scene);
        }
    }
}
