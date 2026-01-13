package org.example.service;

import com.fasterxml.jackson.core.type.TypeReference;
import org.example.model.Driver;
import org.example.model.DriverStatus;
import org.example.repository.AbstractFileRepository;
import org.example.repository.IRepository;

import java.util.List;

public class DriverService extends AbstractService<Driver> {
    public DriverService(IRepository<Driver> repository) {
        super(repository);
    }

    public List<Driver> filterByTeamAndStatus(String team ) {
        return repository.getAll().stream()
                .filter(driver -> driver.getTeam().equalsIgnoreCase(team) && driver.getStatus().equals(DriverStatus.ACTIVE))
                .toList();
    }

}
