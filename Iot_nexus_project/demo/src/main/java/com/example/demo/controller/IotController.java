package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.service.IotService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")

public class IotController {
    private final IotService iotService;

    public IotController(IotService iotService){
        this.iotService = iotService;
    }

    @PostMapping("/rooms")
    public Room createRoom(@RequestBody Room room){
        return iotService.createRoom(room);
    }

    @GetMapping("/rooms")
    public List<Room> getAllRooms(){
        return iotService.getAllRooms();
    }

    @PostMapping("/rooms/{roomId}/devices")
    public Device addDevice(@PathVariable Long roomId, @RequestBody Device device){
        return iotService.addDevice(roomId, device);
    }

    @DeleteMapping("/rooms/{id}")
    public String deleteRoom(@PathVariable Long id){
        iotService.deleteDevice(id);
        return "Room deleted successfully";
    }

    @DeleteMapping("/devices/{id}")
    public String deleteDevice(@PathVariable Long id){
        iotService.deleteDevice(id);
        return "Device deleted successfully";
    }
}
