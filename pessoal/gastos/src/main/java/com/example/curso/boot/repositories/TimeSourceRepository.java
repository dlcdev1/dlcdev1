package com.example.curso.boot.repositories;

import com.example.curso.boot.domains.TimeSource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeSourceRepository extends JpaRepository<TimeSource, Long> {
    TimeSource findByMesAndYear(String mes, Integer year);
}
