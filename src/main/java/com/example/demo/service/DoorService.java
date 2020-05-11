package com.example.demo.service;

import com.example.demo.dao.DoorDao;
import com.example.demo.model.Door;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
