package com.example.hostel.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "rooms")
public class Room {

    @Id
    @Column(name = "room_no")
    private String roomNo;

    private int capacity;

    private boolean hasAC;

    private boolean hasAttachedWashroom;

    // important for allocation
    private int occupied;

    public Room() {}

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isHasAC() {
        return hasAC;
    }

    public void setHasAC(boolean hasAC) {
        this.hasAC = hasAC;
    }

    public boolean isHasAttachedWashroom() {
        return hasAttachedWashroom;
    }

    public void setHasAttachedWashroom(boolean hasAttachedWashroom) {
        this.hasAttachedWashroom = hasAttachedWashroom;
    }

    public int getOccupied() {
        return occupied;
    }

    public void setOccupied(int occupied) {
        this.occupied = occupied;
    }

    // helper
    public int getAvailableSeats() {
        return capacity - occupied;
    }
}
