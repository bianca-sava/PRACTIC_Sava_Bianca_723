package org.example.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import org.example.model.Driver;

import java.util.List;

public class DriverRepo extends AbstractFileRepository<Driver> {
    @Override
    protected TypeReference<List<Driver>> getTypeReference() {
        return new TypeReference<>() {};
    }

    public DriverRepo(String filePath) {
        super(filePath, new TypeReference<List<Driver>>() {});
    }
}
