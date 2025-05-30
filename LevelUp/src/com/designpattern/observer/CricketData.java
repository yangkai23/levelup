package com.designpattern.observer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CricketData implements Subject {
    private int runs;
    private int wickets;
    private float overs;
    private List<Observer> observers;

    public CricketData() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unRegisterObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for (Iterator<Observer> itr = observers.listIterator(); itr.hasNext(); ) {
            Observer observer = itr.next();
            observer.update(runs, wickets, overs);
        }
    }

    public void dataChanged() {
        runs = getLatestRuns();
        wickets = getLatestWickets();
        overs = getLatestOvers();
        notifyObserver();
    }

    private float getLatestOvers() {
        return (float) 6.3;
    }

    private int getLatestWickets() {
        return 4;
    }

    private int getLatestRuns() {
        return 52;
    }
}
