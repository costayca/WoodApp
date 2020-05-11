package com.example.demo.api;

import com.example.demo.model.Door;
import com.example.demo.model.ExteriorDoor;
import com.example.demo.model.InteriorDoor;
import com.example.demo.service.DoorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

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

    @GetMapping(path = "{id}")
    public Door selectDoorById(@PathVariable("id") UUID id) {
        return doorService.selectDoorById(id).orElse(null);
    }

    @PostMapping(path = "/exterior")
    public int insertDoor(@Valid @NotNull @RequestBody ExteriorDoor door) {
        return doorService.insertDoor(door);
    }

    @PostMapping(path = "/interior")
    public int insertDoor(@Valid @NotNull @RequestBody InteriorDoor door) {
        return doorService.insertDoor(door);
    }

    @DeleteMapping(path = "{id}")
    public int deleteDoorById(@PathVariable("id") UUID id) {
        return doorService.deleteDoorById(id);
    }

    @PutMapping(path = "/exterior/{id}")
    public int updateDoorById(@PathVariable("id") UUID id, @Valid @NotNull @RequestBody ExteriorDoor door) {
        return doorService.updateDoorByUd(id, door);
    }

    @PutMapping(path = "/interior/{id}")
    public int updateDoorById(@PathVariable("id") UUID id, @Valid @NotNull @RequestBody InteriorDoor door) {
        return doorService.updateDoorByUd(id, door);
    }
}
