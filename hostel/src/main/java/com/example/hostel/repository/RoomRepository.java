package com.example.hostel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.hostel.entity.Room;

public interface RoomRepository extends JpaRepository<Room, String> {

    @Query("""
        SELECT r FROM Room r
        WHERE (r.capacity - r.occupied) >= :students
          AND r.hasAC = :needsAC
          AND r.hasAttachedWashroom = :needsWashroom
        ORDER BY r.capacity ASC
    """)
    List<Room> findSuitableRooms(int students,
                                 boolean needsAC,
                                 boolean needsWashroom);
}
