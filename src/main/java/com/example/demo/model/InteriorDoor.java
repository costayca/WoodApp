package com.example.demo.model;

import java.util.UUID;

public class InteriorDoor extends Door {

    public InteriorDoor(UUID id, String color, int width, int height, String material, String type) {
        super(id, color, width, height, material, type);
    }

    @Override
    public int computePrice() {
        return Math.round((float) 12000 * getHeight() * getWidth() * computePriceMaterial() * computePriceType() / 10000 );
    }

    @Override
    public float computePriceMaterial() {
        float multiplier = 1;

        String material = getMaterial();
        switch (material) {
            case "Oak":
                multiplier *= 2;
                break;
            case "Ash":
                multiplier *= 1.75;
                break;
            case "Pine":
                multiplier *= 1.25;
                break;
            case "Evergreen":
                multiplier *= 1.15;
                break;
        }
        return multiplier;
    }

    @Override
    public float computePriceType() {
        float multiplier = 1;

        String type = getType();
        switch (type) {
            case "Bi-fold":
                multiplier *= 2;
                break;
            case "Glass":
                multiplier *= 1.75;
                break;
            case "Panel":
                multiplier *= 1.25;
                break;
        }
        return multiplier;
    }
}
