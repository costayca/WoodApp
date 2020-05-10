package com.example.demo.service;

import com.example.demo.model.Door;

import java.util.UUID;

public class AdminService {
    private DoorFactory doorFactory;

    public AdminService() {
        this.doorFactory = new DoorFactory();
    }

    private Door createDoor(String doorClass, UUID id, String color, int width, int height, String material, String type) {
        return doorFactory.createDoor(doorClass, id, color, width, height, material, type);
    }
}
