package com.example.demo.dao;

import com.example.demo.model.Orders;
import com.example.demo.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrdersDao {
    int insertOrder(UUID id, Orders orders);

    default int insertOrder(Orders orders) {
        UUID id = UUID.randomUUID();
        return insertOrder(id, orders);
    }

    List<Orders> selectAllOrders();

    Optional<Orders> selectOrderById(UUID id);

    int deleteOrderById(UUID id);

    int updateOrderById(UUID id, Person person);
}
