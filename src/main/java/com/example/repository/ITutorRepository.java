package com.example.repository;

import com.example.model.Student;
import com.example.model.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface ITutorRepository extends JpaRepository<Tutor, Long> {
}
