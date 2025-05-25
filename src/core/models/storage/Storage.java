/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.models.storage;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vangu
 */
public abstract class Storage {
    public Storage() {
    }

    public abstract void addItem(Object object);
    
 private final List<Runnable> observers = new ArrayList<>();

    public void addObserver(Runnable observer) {
        observers.add(observer);
    }

    public void notifyObservers() {
        for (Runnable o : observers) {
            o.run();
        }
    }
}
