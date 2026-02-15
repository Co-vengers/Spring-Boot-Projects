package com.example.demo.service;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class IotService {
    private final RoomRepository roomRepository;
    private final DeviceRepository deviceRepository;

    public IotService(RoomRepository roomRepository, DeviceRepository deviceRepository){
        this.roomRepository = roomRepository;
        this.deviceRepository = deviceRepository;
    }

    public Room createRoom(Room room){
        return roomRepository.save(room);
    }

    public List<Room> getAllRooms(){
        return roomRepository.findAll();
    }

    public Device addDevice(Long roomId, Device device){
        Room existingRoom = roomRepository.findById(roomId).orElse(null);

        if(existingRoom != null){
            Room foundRoom = existingRoom;
            device.setRoom(foundRoom);
            return deviceRepository.save(device);
        }
        else{
            throw new RuntimeException("Room not found with id: " + roomId);
        }
    }

    public void deleteRoom(Long roomId){
        roomRepository.deleteById(roomId);
    }

    public void deleteDevice(Long deviceId){
        if(deviceRepository.findById(deviceId).orElse(null) != null){
            deviceRepository.deleteById(deviceId);
        }
        else{
            throw new RuntimeException("Device not found with id: " + deviceId);
        }
    }
}
