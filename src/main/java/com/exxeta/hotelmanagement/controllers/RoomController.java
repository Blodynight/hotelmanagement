package com.exxeta.hotelmanagement.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.exxeta.hotelmanagement.enums.RoomSize;
import com.exxeta.hotelmanagement.models.Room;
import com.exxeta.hotelmanagement.services.RoomService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RoomController {
    @Autowired
    RoomService roomService;

    @GetMapping("/room/{roomNumber}")
    public Room getRoom(@PathVariable int roomNumber) {
        return roomService.getRoom(roomNumber);
    }

    @GetMapping("/rooms")
    public List<Room> getMethodName() {
        return roomService.getAllRooms();
    }
    

    @PutMapping("room/{roomNumber}")
    public Room putMethodName(@PathVariable int roomNumber, @RequestParam RoomSize size, @RequestParam boolean minibar) {
        return roomService.createRoom(roomNumber, size, minibar);
    }

    @PatchMapping("room/{roomNumber}")
    public Room patchRoom(@PathVariable int roomNumber, @RequestParam RoomSize size, @RequestParam String minibar){
        return roomService.patchRoom(roomNumber, size, minibar);
    }

}
