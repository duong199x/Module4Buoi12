package com.example.repository;

import com.example.model.ClassRoom;
import com.example.model.Student;
import com.example.model.Tutor;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Long> {

    Iterable<Student> findAllByNameContaining(String name);

    Iterable<Student> findAllByClassRoom(ClassRoom classRoom);

    Iterable<Student> findByTutorsIdIn(List<Long> tutorsId);
}
