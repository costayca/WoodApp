package com.example.demo.dao;

import com.example.demo.model.Order;
import com.example.demo.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrderDao {
    int insertOrder(UUID id, Order order);

    default int insertOrder(Order order) {
        UUID id = UUID.randomUUID();
        return insertOrder(id, order);
    }

    List<Order> selectAllOrders();

    Optional<Order> selectOrderById(UUID id);

    int deleteOrderById(UUID id);

    int updateOrderById(UUID id, Person person);
}
