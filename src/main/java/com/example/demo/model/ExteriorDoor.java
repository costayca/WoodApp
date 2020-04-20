package com.example.demo.model;

import java.util.UUID;

public class ExteriorDoor extends Door {
    public ExteriorDoor(UUID id, int color, int width, int height, String material, String type) {
        super(id, color, width, height, material, type);
    }

    @Override
    public int computePrice() {
        return Math.round((float) 20000 * getHeight() * getWidth() * computePriceMaterial() * computePriceType() / 10000 );
    }

    @Override
    public float computePriceMaterial() {
        float multiplier = 1;

        String material = getMaterial();
        switch (material) {
            case "Oak":
                multiplier *= 3;
                break;
            case "Ash":
                multiplier *= 2.25;
                break;
            case "Pine":
                multiplier *= 1.6;
                break;
        }
        return multiplier;
    }

    @Override
    public float computePriceType() {
        float multiplier = 1;

        String type = getType();
        switch (type) {
            case "Fiberglass":
                multiplier *= 2;
                break;
            case "Slider":
                multiplier *= 1.75;
                break;
            case "French":
                multiplier *= 1.25;
                break;
        }
        return multiplier;
    }
}
