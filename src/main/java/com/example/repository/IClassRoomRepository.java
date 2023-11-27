package com.example.repository;

import com.example.model.ClassRoom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClassRoomRepository extends CrudRepository<ClassRoom, Long> {
    Iterable<ClassRoom> findAll();
    Iterable<ClassRoom> findAllByNameContaining(String name);
}
