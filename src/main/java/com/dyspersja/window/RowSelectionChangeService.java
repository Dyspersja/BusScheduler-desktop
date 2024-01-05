package com.dyspersja.window;

import java.util.ArrayList;
import java.util.List;

public class RowSelectionChangeService implements SceneChangeListener{

    private static RowSelectionChangeService instance;

    private final List<RowSelectionChangeListener> observers = new ArrayList<>();
    private Long currentSelectedRowId;

    private RowSelectionChangeService() {
        SceneChangeService.getInstance().addObserver(this);
    }

    public static RowSelectionChangeService getInstance() {
        if (instance == null) {
            instance = new RowSelectionChangeService();
        }
        return instance;
    }

    public void addObserver(RowSelectionChangeListener observer) {
        observers.add(observer);
    }

    public void changeSelectedRowId(Long selectedRowId) {
        this.currentSelectedRowId = selectedRowId;
        notifyObservers(selectedRowId);
    }

    public Long getSelectedRowId() {
        return this.currentSelectedRowId;
    }

    private void notifyObservers(Long selectedRowId) {
        for (RowSelectionChangeListener observer : observers) {
            if (selectedRowId != null) observer.onRowSelect(selectedRowId);
            else observer.onRowDeselect();
        }
    }

    @Override
    public void onSceneChange(Scene scene) {
        changeSelectedRowId(null);
    }
}
