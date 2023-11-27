package com.example.service;

import java.util.Optional;

public interface IGenerateService<E> {
    Iterable<E> findAll();

    void save(E e);

    Optional<E> findById(Long id);

    void remove(Long id);
}
