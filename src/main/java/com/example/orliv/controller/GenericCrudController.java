package com.example.orliv.controller;

import com.example.orliv.service.CrudService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public abstract class GenericCrudController<T, ID> {

    protected final CrudService<T, ID> service;

    protected GenericCrudController(CrudService<T, ID> service) {
        this.service = service;
    }

    @GetMapping("/all")
    public List<T> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<T> getById(@PathVariable ID id) {
        Optional<T> optionalEntity = service.findById(id);
        return optionalEntity.map(entity -> new ResponseEntity<>(entity, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public T create(@RequestBody T entity) {
        return service.create(entity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<T> update(@PathVariable ID id, @RequestBody T entity) {
        service.update(id, entity);
        return new ResponseEntity<>(entity, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<T> partialUpdate(@PathVariable ID id, @RequestBody T updates) {
        return service.findById(id)
                .map(entity -> {
                    service.update(id, entity);
                    return new ResponseEntity<>(entity, HttpStatus.OK);
                })
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable ID id) {
        if (!service.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    protected CrudService<T, ID> getCrudService() {
        return this.service;
    }

    @SuppressWarnings("unchecked")
    public <S extends CrudService<T, ID>> S getService(Class<S> clazz) {
        return (S) getCrudService();
    }

}