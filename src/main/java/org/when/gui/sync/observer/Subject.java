package org.when.gui.sync.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: when
 * @create: 2021-09-28  10:43
 **/
public class Subject {
    private List<ChangeListener> listeners = new ArrayList<>();

    public void addListener(ChangeListener listener) {
        this.listeners.add(listener);
    }

    public void notifyListeners() {
        listeners.forEach(ChangeListener::update);
    }
}
