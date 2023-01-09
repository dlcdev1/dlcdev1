package com.example.curso.boot.services;

import com.example.curso.boot.domains.BillCollector;
import com.example.curso.boot.repositories.BillCollectorsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class BillCollectorServiceImpl implements BillCollectorService {
    private final BillCollectorsRepository repo;

    public BillCollector add(final BillCollector billCollector) {
        log.info("Bill collector {}", billCollector);
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
        return repo.findAll().stream().sorted(
                Comparator.comparing(BillCollector::getName))
                .collect(Collectors.toList());
    }

    @Override
    public BillCollector findByName(String name) {
        return repo.findByName(name);
    }

}
