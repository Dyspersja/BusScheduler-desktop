package com.dyspersja.window;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Scene {

    SCENE_1("Scene 1"),
    SCENE_2("Scene 2"),
    SCENE_3("Scene 3"),
    TICKET_ZONES("Ticket Zones");

    private final String sceneName;

    @Override
    public String toString() {
        return this.sceneName;
    }
}
