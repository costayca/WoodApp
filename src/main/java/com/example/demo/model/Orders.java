package com.example.demo.model;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.UUID;

public class Orders {

    private final UUID id;
    @NotBlank
    private final UUID customerId;
    @NotBlank
    private final int duration;
    @NotBlank
    private final List<UUID> products;

    public Orders(UUID uuid, @NotBlank UUID customerUuid, @NotBlank int duration, @NotBlank List<UUID> products) {
        this.id = uuid;
        this.customerId = customerUuid;
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
}
