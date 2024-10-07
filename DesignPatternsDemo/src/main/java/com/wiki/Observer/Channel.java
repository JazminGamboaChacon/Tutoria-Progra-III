package com.wiki.Observer;

import java.util.ArrayList;
import java.util.List;

class Channel {
private List<Observer> observers = new ArrayList<>();

public void subscribe(Observer observer) {
    observers.add(observer);
}

public void notifySubscribers(String message) {
    for (Observer observer : observers) {
        observer.update(message);
    }
}
}
