package org.example.service;

import com.fasterxml.jackson.core.type.TypeReference;
import org.example.model.Driver;
import org.example.model.Penalty;
import org.example.repository.IRepository;

import java.util.List;

public class PenaltyService extends AbstractService<Penalty> {

    public PenaltyService(IRepository<Penalty> repository) {
        super(repository);
    }
}
