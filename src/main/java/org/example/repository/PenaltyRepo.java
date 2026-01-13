package org.example.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import org.example.model.Penalty;

import java.util.List;

public class PenaltyRepo extends AbstractFileRepository<Penalty> {
    @Override
    protected TypeReference<List<Penalty>> getTypeReference() {
        return new TypeReference<>() {};
    }

    public PenaltyRepo(String filePath) {
        super(filePath, new TypeReference<List<Penalty>>() {});
    }
}
