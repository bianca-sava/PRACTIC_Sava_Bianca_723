package org.example.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import org.example.model.HasID;
import org.example.util.JsonIO;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class AbstractFileRepository<T extends HasID> implements IRepository<T> {
    protected final Path filePath;
    protected List<T> memoryData;

    public AbstractFileRepository(String filename, TypeReference<List<T>> typeRef) {
        this.filePath = Path.of(filename);
        this.memoryData = JsonIO.readOrCreate(filePath, "[]", typeRef);
    }

    protected abstract TypeReference<List<T>> getTypeReference();

    protected void saveToFile() {
        JsonIO.writePretty(filePath, memoryData);
    }

    @Override
    public T create(T entity) {

        if (entity.getId() == null) {
            int maxId = memoryData.stream().mapToInt(HasID::getId).max().orElse(0);
            entity.setId(maxId + 1);
        }
        memoryData.add(entity);
        saveToFile();
        return entity;
    }

    @Override
    public T read(Integer id) {
        return memoryData.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<T> getAll() {
        return new ArrayList<>(memoryData);
    }

    @Override
    public T update(T entity) {
        Optional<T> existing = memoryData.stream()
                .filter(e -> e.getId().equals(entity.getId()))
                .findFirst();

        if (existing.isPresent()) {
            int index = memoryData.indexOf(existing.get());
            memoryData.set(index, entity);
            saveToFile();
            return entity;
        }
        return null;
    }

    @Override
    public void delete(Integer id) {
        memoryData.removeIf(e -> e.getId().equals(id));
        saveToFile();
    }
}