package com.example.orliv.service;

import java.util.List;
import java.util.Optional;

public interface CrudService<T, id> {
    List<T> findAll();

    Optional<T> findById(id id);

    T create(T entity);

    T update(id id, T entity);

    void delete(id id);

    T findOne(id id);

    Boolean existsById(id id);

    void beforeCreate(T entity);

    void afterCreate(T entity);
}