package com.example.demo.service;

import com.example.demo.dao.DoorDao;
import com.example.demo.model.Door;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DoorService {

    private final DoorDao doorDao;

    @Autowired
    public DoorService(@Qualifier("doorPostgres") DoorDao doorDao) {
        this.doorDao = doorDao;
    }

    public List<Door> selectAllDoors() {
        return doorDao.selectAllDoors();
    }

    public Optional<Door> selectDoorById(UUID uuid) {
        return doorDao.selectDoorById(uuid);
    }

    public int insertDoor(Door door) {
        return doorDao.insertDoor(door);
    }

    public int deleteDoorById(UUID uuid) {
        return doorDao.deleteDoorById(uuid);
    }

    public int updateDoorByUd(UUID uuid, Door door) {
        return doorDao.updateDoorById(uuid, door);
    }
}
