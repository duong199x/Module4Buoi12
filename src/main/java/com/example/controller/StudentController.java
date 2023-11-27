package com.example.controller;

import com.example.model.Student;
import com.example.service.IClassRoomService;
import com.example.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/students")
@CrossOrigin("*")
public class StudentController {
    @Autowired
    private IStudentService iStudentService;

    @GetMapping("")
    public ResponseEntity<Iterable<Student>> getAll() {
        List<Student> students = (List<Student>) iStudentService.findAll();
        if (students.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Student> add(@RequestBody Student student) {
        iStudentService.save(student);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Student> delete(@PathVariable Long id) {
        iStudentService.remove((long) Math.toIntExact(id));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Student> edit(@PathVariable Long id, @RequestBody Student student) {
        student.setId(id);
        iStudentService.save(student);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Iterable<Student>> getByname(@RequestParam String name) {
        List<Student> students = (List<Student>) iStudentService.findByName(name);
        if (students.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Student> findById(@PathVariable Long id) {
        Optional<Student> student = iStudentService.findById((long) Math.toIntExact(id));
        return new ResponseEntity<>(student.get(), HttpStatus.OK);
    }

}
