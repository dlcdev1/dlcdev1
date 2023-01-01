package com.example.curso.boot.services;

import com.example.curso.boot.domains.BillCollector;
import com.example.curso.boot.repositories.BillCollectorsRepository;
import javassist.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class BillCollectorServiceImpl implements BillCollectorService {
    private final BillCollectorsRepository repo;

    public BillCollectorServiceImpl(BillCollectorsRepository repo) {
        this.repo = repo;
    }

    public BillCollector save(final BillCollector billCollector) throws NotFoundException {
        log.info("Bill collector {}", billCollector);
        if (Objects.isNull(repo.findByName(billCollector.getName()))) {
            return repo.save(billCollector);
        }
        throw new NotFoundException(String.format("Usuario '%s' ja existe.", billCollector.getName()));
    }

    public BillCollector findById(Long id) {
        return repo.findById(id).get();
    }

    public BillCollector update(BillCollector billCollector) {
        return repo.save(billCollector);
    }

    public void delete(Long id) throws NotFoundException {
        log.info("id", id);
        BillCollector byId = findById(id);
        if (Objects.isNull(findById(id))) {
            throw new NotFoundException("Usuario nao existe.");
        }
        repo.deleteById(id);
    }

    public List<BillCollector> findAll() {
        List<BillCollector> all = repo.findAll();
        log.info("data gastos: {}", all);
        return all;
    }

}
