package org.example.repository;

import org.example.model.HasID;

import java.util.List;

public interface IRepository<T extends HasID> {
    T create(T entity);
    T read(Integer id);
    List<T> getAll();
    T update(T entity);
    void delete(Integer id);
}