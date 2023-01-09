package com.example.curso.boot.services;

import com.example.curso.boot.domains.TimeSource;
import com.example.curso.boot.repositories.TimeSourceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@Service
public class TimeSourceImpl implements TimeSourceService {

    private TimeSourceRepository repo;

    public TimeSourceImpl(TimeSourceRepository repo) {
        this.repo = repo;
    }

    @Override
    public TimeSource add(final TimeSource timeSource) {
        return repo.save(timeSource);
    }

    @Override
    public TimeSource findById(Long id) {
        return repo.findById(id).get();
    }

    @Override
    public Boolean findByMesAndYear(String mes, Integer year) {
        TimeSource byMesAndYear = repo.findByMesAndYear(mes, year);
        if (Objects.isNull(byMesAndYear)) {
            return false;
        }
        return true;
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
        return repo.findAll().stream().sorted(
                Comparator.comparing(
                        TimeSource::getYear)
                )
                .collect(Collectors.toList());
    }
}