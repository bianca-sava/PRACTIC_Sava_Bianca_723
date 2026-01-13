package org.example.service;

import com.fasterxml.jackson.core.type.TypeReference;
import org.example.model.Driver;
import org.example.repository.AbstractFileRepository;
import org.example.repository.IRepository;

import java.util.List;

public class DriverService extends AbstractService<Driver> {
    public DriverService(IRepository<Driver> repository) {
        super(repository);
    }

}
