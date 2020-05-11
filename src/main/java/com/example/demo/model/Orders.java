package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

public class Orders {

    private final UUID id;
    @NotNull
    private final UUID customerId;
    @NotNull
    private final int duration;
    @NotNull
    private final List<UUID> products;

    public Orders(@JsonProperty("id") UUID id,@JsonProperty("customerid") UUID customerId,@JsonProperty("duration") int duration,@JsonProperty("products") List<UUID> products) {
        this.id = id;
        this.customerId = customerId;
        this.duration = duration;
        this.products = products;
    }

    public UUID getId() {
        return id;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public int getDuration() {
        return duration;
    }

    public List<UUID> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", duration=" + duration +
                ", products=" + products +
                '}';
    }
}
