package com.example.hostel.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.hostel.entity.Room;

import com.example.hostel.service.RoomService;

@Controller
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    // Home -> list rooms
    @GetMapping("/")
    public String home(Model model) {

        model.addAttribute("rooms", roomService.getAllRooms());
        return "rooms";
    }

    // ---------- Add room UI ----------

    @GetMapping("/add-room")
    public String addRoomForm(Model model) {
        model.addAttribute("room", new Room());
        return "add-room";
    }
    @PostMapping("/delete-room")
    public String deleteRoom(@RequestParam String roomNo) {

        roomService.deleteRoom(roomNo);
        return "redirect:/";
    }


    @PostMapping("/add-room")
    public String saveRoom(@ModelAttribute Room room) {

        roomService.addRoom(room);
        return "redirect:/";
    }

    // ---------- Search + Allocate UI ----------

    @GetMapping("/search-allocate")
    public String searchPage() {
        return "search-allocate";
    }

    @PostMapping("/search")
    public String searchRooms(@RequestParam int students,
                              @RequestParam boolean needsAC,
                              @RequestParam boolean needsWashroom,
                              Model model) {

        List<Room> rooms =
                roomService.searchRooms(students, needsAC, needsWashroom);

        model.addAttribute("rooms", rooms);
        return "search-allocate";
    }

    @PostMapping("/allocate")
    public String allocate(@RequestParam int students,
                           @RequestParam boolean needsAC,
                           @RequestParam boolean needsWashroom,
                           Model model) {

        Room room =
                roomService.allocateRoom(students, needsAC, needsWashroom);

        if (room == null) {
            model.addAttribute("message", "No room available");
        } else {
            model.addAttribute("message",
                    "Allocated Room : " + room.getRoomNo());
        }

        return "search-allocate";
    }
}
