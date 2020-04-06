package com.example.demo.service;

import com.example.demo.dao.OrderDao;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CommandService implements Subject {

    private final OrderDao orderDao;
    private ArrayList<Observer> observers;
    private int totalDuration = 0;

    public CommandService(@Qualifier("postgres") OrderDao orderDao) {
        this.orderDao = orderDao;
        this.observers = new ArrayList<Observer>();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer: observers) {
            observer.update();
        }
    }

    public void setTotalDuration(int totalDuration) {
        this.totalDuration = totalDuration;
        notifyObservers();
    }
}
