package com.example.orliv.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public abstract class GenericCrudService<T, id> implements CrudService<T, id> {

    private final CrudRepository<T, id> repository;

    public GenericCrudService(CrudRepository<T, id> repository) {
        this.repository = repository;
    }


    @Override
    public void beforeCreate(T entity) {
        //a nothingness burger
    }

    @Override
    public void afterCreate(T entity) {
        //not happening sauce
    }

    @Override
    public List<T> findAll() {
        Iterable<T> all = this.repository.findAll();

        if (all instanceof List) {
            return (List<T>) all;
        }

        List<T> result = new ArrayList<>();
        all.forEach(result::add);
        return result;
    }

    @Override
    public Optional<T> findById(id id) {
        return this.repository.findById(id);
    }


    @Override
    public T create(T entity) {
        this.beforeCreate(entity);

        T save = this.repository.save(entity);

        this.afterCreate(entity);

        return save;
    }

    @Override
    public T update(id id, T entity) {
        this.findById(id);
        return this.repository.save(entity);
    }

    @Override
    public void delete(id id) {
        this.repository.deleteById(id);
    }

    @Override
    public T findOne(id id) {
        return this.repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Entity not found for id: " + id));
    }

    @Override
    public Boolean existsById(id id) {
        return this.repository.existsById(id);
    }

    protected CrudRepository<T, id> getCrudRepository() {
        return this.repository;
    }

    @SuppressWarnings("unchecked")
    public <S extends JpaRepository<T, id>> S getRepository(Class<S> clazz) {
        return (S) getCrudRepository();
    }

}
