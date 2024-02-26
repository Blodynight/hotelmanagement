package com.exxeta.hotelmanagement.repositories;

import com.exxeta.hotelmanagement.models.Room;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JPA-Repository that maps room entity to the correlating database entry
 * @see com.exxeta.hotelmanagement.models.Room
 */
public interface RoomRepository extends JpaRepository<Room, Integer>{

    Room findById(int id);
}