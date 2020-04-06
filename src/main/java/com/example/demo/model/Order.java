package com.example.demo.model;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class Order {

    private final UUID uuid;
    @NotBlank
    private final UUID customerUuid;
    @NotBlank
    private final int duration;

    public Order(UUID uuid, @NotBlank UUID customerUuid, @NotBlank int duration) {
        this.uuid = uuid;
        this.customerUuid = customerUuid;
        this.duration = duration;
    }

    public UUID getUuid() {
        return uuid;
    }

    public UUID getCustomerUuid() {
        return customerUuid;
    }

    public int getDuration() {
        return duration;
    }
}
