package com.example.demo.dao;

import com.example.demo.model.Door;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DoorDao {
    List<Door> selectAllDoors();

    Optional<Door> selectDoorById(UUID id);

    int insertDoor(Door door);

    int deleteDoorById(UUID id);

    int updateDoorById(UUID id, Door door);
}
