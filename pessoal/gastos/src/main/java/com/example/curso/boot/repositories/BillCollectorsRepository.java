package com.example.curso.boot.repositories;

import com.example.curso.boot.domains.BillCollector;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillCollectorsRepository extends JpaRepository<BillCollector, Long> {
}
