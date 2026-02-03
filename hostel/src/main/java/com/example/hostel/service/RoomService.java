package com.example.hostel.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.hostel.entity.Room;
import com.example.hostel.repository.RoomRepository;

@Service
public class RoomService {

    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    // 1. Add room
    public Room addRoom(Room room) {
        room.setOccupied(0);
        return roomRepository.save(room);
    }
    public void deleteRoom(String roomNo) {
        roomRepository.deleteById(roomNo);
    }


    // 2. View all rooms
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    // 3. Search rooms
    public List<Room> searchRooms(int students,
                                  boolean needsAC,
                                  boolean needsWashroom) {

        return roomRepository.findSuitableRooms(
                students,
                needsAC,
                needsWashroom
        );
    }

    // 4. Allocate room
    @Transactional
    public Room allocateRoom(int students,
                             boolean needsAC,
                             boolean needsWashroom) {

        List<Room> rooms =
                roomRepository.findSuitableRooms(
                        students,
                        needsAC,
                        needsWashroom
                );

        if (rooms.isEmpty()) {
            return null;
        }

        // smallest room already first
        Room selected = rooms.get(0);

        selected.setOccupied(
                selected.getOccupied() + students
        );

        return roomRepository.save(selected);
    }
}
