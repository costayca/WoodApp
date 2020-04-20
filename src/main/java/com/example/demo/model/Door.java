package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public abstract class Door {

    private final UUID id;
    @NotBlank
    private final int color;
    @NotBlank
    private final int width;
    @NotBlank
    private final int height;
    private final int price;
    @NotBlank
    private final String material;
    private final String type;

    public abstract int computePrice();
    public abstract float computePriceMaterial();
    public abstract float computePriceType();

    public Door(@JsonProperty("id") UUID id, @JsonProperty("color") int color, @JsonProperty("width") int width, @JsonProperty("height") int height, @JsonProperty("material") String material, @JsonProperty("type") String type) {
        this.id = id;
        this.color = color;
        this.width = width;
        this.height = height;
        this.material = material;
        this.type = type;
        this.price = computePrice();
    }

    public UUID getId() {
        return id;
    }

    public int getColor() {
        return color;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getPrice() {
        return price;
    }

    public String getMaterial() {
        return material;
    }

    public String getType() {
        return type;
    }
}
