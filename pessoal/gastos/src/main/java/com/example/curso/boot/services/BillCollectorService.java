package com.example.curso.boot.services;

import com.example.curso.boot.domains.BillCollector;
import com.example.curso.boot.repositories.BillCollectorsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class BillCollectorService {
    private final BillCollectorsRepository repo;

    public BillCollectorService(BillCollectorsRepository repo) {
        this.repo = repo;
    }

    public BillCollector save(final BillCollector billCollector) {
        return repo.save(billCollector);
    }

    public BillCollector findById(Long id) {
        return repo.findById(id).get();
    }

    public BillCollector update(BillCollector billCollector) {
        return repo.save(billCollector);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public List<BillCollector> findAll() {
        List<BillCollector> all = repo.findAll();
        log.info("data gastos: {}", all);
        return all;
    }

}
