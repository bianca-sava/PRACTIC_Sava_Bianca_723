package org.example.service;

import org.example.model.HasID;
import org.example.repository.IRepository;

import java.util.List;

public abstract class AbstractService<T extends HasID> {

    protected final IRepository<T> repository;

    public AbstractService(IRepository<T> repository) {
        this.repository = repository;
    }

    public T add(T entity) { return repository.create(entity); }
    public T get(Integer id) { return repository.read(id); }
    public List<T> getAll() { return repository.getAll(); }
    public void update(T entity) { repository.update(entity); }
    public void remove(Integer id) { repository.delete(id); }
}


