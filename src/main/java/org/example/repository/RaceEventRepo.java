package org.example.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import org.example.model.Penalty;
import org.example.model.RaceEvent;

import java.util.List;

public class RaceEventRepo extends AbstractFileRepository<RaceEvent>{
    @Override
    protected TypeReference<List<RaceEvent>> getTypeReference() {
        return new TypeReference<>() {};
    }

    public RaceEventRepo(String filePath) {
        super(filePath, new TypeReference<List<RaceEvent>>() {});
    }
}
