package com.example.demo.service;

import com.example.demo.dao.OrdersDao;
import com.example.demo.model.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("order")
public class OrdersService implements Subject {

    private final OrdersDao ordersDao;
    private ArrayList<Observer> observers;
    private int totalDuration = 0;

    @Autowired
    public OrdersService(@Qualifier("ordersPostgres") OrdersDao ordersDao) {
        this.ordersDao = ordersDao;
        this.observers = new ArrayList<Observer>();
    }

    public List<Orders> getAllOrders() {
        return ordersDao.selectAllOrders();
    }

    public int insertOrders(Orders orders) {
        return ordersDao.insertOrder(orders);
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
