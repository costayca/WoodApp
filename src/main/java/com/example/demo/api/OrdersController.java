package com.example.demo.api;


import com.example.demo.model.Orders;
import com.example.demo.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("/api/v1/orders")
@RestController
public class OrdersController {
    private final OrdersService ordersService;

    @Autowired
    public OrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @GetMapping
    public List<Orders> getAllOrders() {
        return ordersService.getAllOrders();
    }

    @PostMapping
    public void insertOrders(@Valid @NotNull @RequestBody Orders orders) {
        ordersService.insertOrders(orders);
    }

    @GetMapping(path = "{id}")
    public Orders selectOrdersById(@PathVariable("id") UUID id) {
        return ordersService.selectOrdersById(id).orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deleteOrdersById(@PathVariable("id") UUID id) {
        ordersService.deleteOrdersById(id);
    }

    @PutMapping(path = "{id}")
    public void updateOrdersById(@PathVariable("id") UUID id, @Valid @NotNull @RequestBody Orders ordersToUpdate) {
        ordersService.updateOrdersById(id, ordersToUpdate);
    }
}
