package com.example.demo.service;

import com.example.demo.model.Door;
import com.example.demo.model.ExteriorDoor;
import com.example.demo.model.InteriorDoor;

import java.util.UUID;

public class DoorFactory {
    public Door createDoor(String doorClass, UUID id, String color, int width, int height, String material, String type) {
        Door door = null;

        if (doorClass.equals("Exterior")) {
            door = new ExteriorDoor(id, color, width, height, material, type);
        } else if (doorClass.equals("Interior")) {
            door = new InteriorDoor(id, color, width, height, material, type);
        }

        return door;
    }
}
