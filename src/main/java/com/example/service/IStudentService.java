package com.example.service;

import com.example.model.ClassRoom;
import com.example.model.Student;

import java.util.List;

public interface IStudentService extends IGenerateService<Student> {
    Iterable<Student> findByName(String name);

    Iterable<Student> findByClass(ClassRoom classRoom);
    Iterable<Student> findStudentByTutors(List<Long> tutorsId);
}
