package com.example.curso.boot.services;

import com.example.curso.boot.domains.TimeSource;
import com.example.curso.boot.repositories.TimeSourceRepository;
import org.webjars.NotFoundException;

import java.util.List;

public class TimeSourceImpl implements TimeSourceService{

    private TimeSourceRepository repo;


    @Override
    public TimeSource add(TimeSource timeSource) {
        return repo.save(timeSource);
    }

    @Override
    public TimeSource findById(Long id) {
        return repo.findById(id).get();
    }

    @Override
    public TimeSource update(TimeSource timeSource) throws NotFoundException {
        return repo.save(timeSource);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Override
    public List<TimeSource> findAll() {
        return repo.findAll();
    }
}
