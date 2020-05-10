package com.example.demo.service;

import com.example.demo.dao.OrdersDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("order")
public class OrderService implements Subject {

    private final OrdersDao ordersDao;
    private ArrayList<Observer> observers;
    private int totalDuration = 0;

    @Autowired
    public OrderService(@Qualifier("ordersPostgres") OrdersDao ordersDao) {
        this.ordersDao = ordersDao;
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
            observer.update(totalDuration);
        }
    }

    public void setTotalDuration(int totalDuration) {
        this.totalDuration = totalDuration;
        notifyObservers();
    }

    public int getTotalDuration() {
        return totalDuration;
    }
}
