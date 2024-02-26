package com.exxeta.hotelmanagement.models;

import com.exxeta.hotelmanagement.enums.RoomSize;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;

@Entity
public class Room {
    @Id
    private int roomNumber;

    @Enumerated(EnumType.STRING)
    private RoomSize size;

    private boolean minibar;

    private boolean booked;

    public Room(int id, RoomSize size, boolean minibar, boolean booked){
        this.roomNumber = id;
        this.size = size;
        this.minibar = minibar;
        this.booked = booked;
    }

    protected Room(){
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public RoomSize getSize(){
        return this.size;
    }
    
    public void setSize(RoomSize size){
        this.size = size;
    }

    public boolean getMinibar(){
        return this.minibar;
    }
    
    public void setMinibar(boolean minibar){
        this.minibar = minibar;
    }

    public boolean getBooked(){
        return this.booked;
    }

    public void setBooked(boolean booked){
        this.booked = booked;
    }
}
