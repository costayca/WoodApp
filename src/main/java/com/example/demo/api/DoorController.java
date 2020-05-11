package com.example.demo.api;

import com.example.demo.model.Door;
import com.example.demo.service.DoorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/v1/door")
@RestController
public class DoorController {
    private final DoorService doorService;

    @Autowired
    public DoorController(DoorService doorService) {
        this.doorService = doorService;
    }

    @GetMapping
    public List<Door> selectAllDoors() {
        return doorService.selectAllDoors();
    }
}
