package com.example.demo.dao;

import com.example.demo.model.Orders;
import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("orderPostgres")
public class OrderDataAccessService implements OrderDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public OrderDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertOrder(UUID id, Orders orders) {
        return 0;
    }

    @Override
    public List<Orders> selectAllOrders() {
        return null;
    }

    @Override
    public Optional<Orders> selectOrderById(UUID id) {
        return Optional.empty();
    }

    @Override
    public int deleteOrderById(UUID id) {
        return 0;
    }

    @Override
    public int updateOrderById(UUID id, Person person) {
        return 0;
    }
}
