package com.example.service;

import com.example.model.ClassRoom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IClassRoomService extends IGenerateService<ClassRoom>{
    Iterable<ClassRoom> findByName( String name);
}
