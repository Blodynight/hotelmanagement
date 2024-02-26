package com.exxeta.hotelmanagement.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.exxeta.hotelmanagement.enums.RoomSize;
import com.exxeta.hotelmanagement.models.Room;
import com.exxeta.hotelmanagement.repositories.RoomRepository;

/**
 * The room service class is the business logic
 * TODO: Implement manual exception handler on business logic so user can get clear error messages (i.e input a room number thats already used)
 */
@Service
public class RoomService {

    @Autowired
    RoomRepository roomRepository;

    /**
     * Creates new room if there is no room with the same room number
     * @param roomNumber    identifier of the room
     * @param roomSize      Size of the room
     * @param minibar       boolean if the room has a minibar or not
     * @return              created room
     */
    public Room createRoom(int roomNumber, RoomSize roomSize, boolean minibar){
        Room room = new Room(roomNumber, roomSize, minibar);
        if(roomRepository.findById(roomNumber) != null){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "There already exists a room with the number[" + roomNumber + "]");
        } else {
            roomRepository.save(room);
            return room;
        }
    }

    public void deleteRoom(int roomNumber){
        Room room = roomRepository.findById(roomNumber);
        if(room != null){
            roomRepository.delete(room);
        }else{
            throw new IllegalArgumentException("Room is null");
        }
        
    }

    /**
     * Searches Room by given room number if it exists
     * @param roomNumber    given identifier of a room
     * @return              found room
     */
    public Room getRoom(int roomNumber){
        Room room = roomRepository.findById(roomNumber);
        if(room != null){
            return room;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Changes variables of room depending on if they have been sent in the request as a parameter
     * !This is a rather bad solution, since in the future we may have to add a lot of columns and for every column we would need another if-statement!
     * !Furthermore this is a bad solution because boolean cannot be null meaning we have to either use Boolean or another Type that can be nulled, in this case String!
     * @param roomNumber    the identifier of the room
     * @param size          new (or not) size sent with the request
     * @param minibar       new (or not) variable referring to if the room has a minibar or not
     * @return              room with changed variables
     */
    public Room patchRoom(int roomNumber, RoomSize size, String minibar){
        Room room = roomRepository.findById(roomNumber);

        if(room == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        
        if(minibar != null){
            room.setMinibar(Boolean.parseBoolean(minibar));
        }

        if(size != null){
            room.setSize(size);
        }

        roomRepository.save(room);

        return room;
    }

    /**
     * Finds and returns all existing rooms
     * May be updated later to support different parameters (by overloading or other means)
     * @return  all existing rooms
     */
    public List<Room> getAllRooms(){
        return roomRepository.findAll();
    }
}
