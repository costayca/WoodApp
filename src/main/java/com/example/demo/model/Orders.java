package com.example.demo.model;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class Orders {

    private final UUID id;
    @NotBlank
    private final UUID customerId;
    @NotBlank
    private final int duration;

    public Orders(UUID uuid, @NotBlank UUID customerUuid, @NotBlank int duration) {
        this.id = uuid;
        this.customerId = customerUuid;
        this.duration = duration;
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
}
