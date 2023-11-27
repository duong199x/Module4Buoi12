package com.example.service.impl;

import com.example.model.ClassRoom;
import com.example.repository.IClassRoomRepository;
import com.example.service.IClassRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ClassRoomService implements IClassRoomService {
    private final IClassRoomRepository iClassRoomRepository;

    @Autowired
    public ClassRoomService(IClassRoomRepository iClassRoomRepository) {
        this.iClassRoomRepository = iClassRoomRepository;
    }

    @Override
    public Iterable<ClassRoom> findAll() {
        return iClassRoomRepository.findAll();
    }

    @Override
    public void save(ClassRoom classRoom) {
        iClassRoomRepository.save(classRoom);
    }

    @Override
    public Optional<ClassRoom> findById(Long id) {
        return iClassRoomRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        iClassRoomRepository.deleteById(id);
    }

    @Override
    public Iterable<ClassRoom> findByName(String name) {
        return iClassRoomRepository.findAllByNameContaining(name);
    }
}
