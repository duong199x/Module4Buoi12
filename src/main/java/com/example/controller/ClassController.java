package com.example.controller;

import com.example.model.ClassRoom;
import com.example.model.Student;
import com.example.service.IClassRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/classrooms")
@CrossOrigin("*")
public class ClassController {
    @Autowired
    private IClassRoomService iClassRoomService;
    @GetMapping("")
    public ResponseEntity<Iterable<ClassRoom>> getAll() {
        List<ClassRoom> classRooms = (List<ClassRoom>) iClassRoomService.findAll();
        if (classRooms.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(classRooms, HttpStatus.OK);
    }

}
