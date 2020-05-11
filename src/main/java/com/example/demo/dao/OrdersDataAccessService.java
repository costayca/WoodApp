package com.example.demo.dao;

import com.example.demo.model.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Array;
import java.sql.Connection;
import java.util.*;

@Repository("ordersPostgres")
public class OrdersDataAccessService implements OrdersDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public OrdersDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertOrder(Orders orders) {
        final String sql = "INSERT INTO orders (id, customerid, duration, products) VALUES (?, ?, ?, ?)";
        UUID[] uuids = new UUID[orders.getProducts().size()];
        uuids = orders.getProducts().toArray(uuids);
        UUID[] finalUuids = uuids;
        Array uuidsArray = jdbcTemplate.execute((Connection c) -> c.createArrayOf("uuid", finalUuids));
        return jdbcTemplate.update(sql, orders.getId(), orders.getCustomerId(), orders.getDuration(), uuidsArray);
    }

    @Override
    public List<Orders> selectAllOrders() {
        final String sql = "SELECT id, customerid, duration, products FROM orders";
        return jdbcTemplate.query(sql, ((resultSet, i) -> {
            UUID id = UUID.fromString(resultSet.getString("id"));
            UUID customerId = UUID.fromString(resultSet.getString("customerid"));
            int duration = resultSet.getInt("duration");
            List<UUID> products = new ArrayList<>(Arrays.asList((UUID[]) resultSet.getArray("products").getArray()));

            return new Orders(id, customerId, duration, products);
        }));
    }

    @Override
    public Optional<Orders> selectOrderById(UUID id) {
        final String sql = "SELECT id, customerid, duration, products FROM orders WHERE id = ?";
        Orders order = jdbcTemplate.queryForObject(sql, new Object[]{id}, ((resultSet, i) -> {
            UUID orderId = UUID.fromString(resultSet.getString("id"));
            UUID customerId = UUID.fromString(resultSet.getString("customerid"));
            int duration = resultSet.getInt("duration");
            List<UUID> products = new ArrayList<>(Arrays.asList((UUID[]) resultSet.getArray("products").getArray()));

            return new Orders(orderId, customerId, duration, products);
        }));

        return Optional.ofNullable(order);
    }

    @Override
    public void deleteOrderById(UUID id) {
        final String sql = "DELETE FROM orders WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void updateOrderById(UUID id, Orders orders) {
        final String sql = "UPDATE orders SET customerId = ?, duration = ?, products = ? WHERE id = ?";
        UUID[] uuids = new UUID[orders.getProducts().size()];
        uuids = orders.getProducts().toArray(uuids);
        UUID[] finalUuids = uuids;
        Array uuidsArray = jdbcTemplate.execute((Connection c) -> c.createArrayOf("uuid", finalUuids));
        jdbcTemplate.update(sql, orders.getCustomerId(), orders.getDuration(), uuidsArray, id);
    }
}
