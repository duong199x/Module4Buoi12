package com.example.repository;

import com.example.model.ClassRoom;
import com.example.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepository extends CrudRepository<Student, Long> {
    Iterable<Student> findAll();

    Iterable<Student> findAllByNameContaining(String name);

    Iterable<Student> findAllByClassRoom(ClassRoom classRoom);
}
