package com.example.curso.boot.services;

import com.example.curso.boot.domains.Bill;
import com.example.curso.boot.domains.TimeSource;
import org.webjars.NotFoundException;

import java.sql.Time;
import java.util.List;

public interface TimeSourceService {

    TimeSource add(final TimeSource timeSource);

    TimeSource findById(Long id);

    TimeSource update(TimeSource timeSource) throws NotFoundException;

    void delete(Long id);

    List<TimeSource> findAll();

}
