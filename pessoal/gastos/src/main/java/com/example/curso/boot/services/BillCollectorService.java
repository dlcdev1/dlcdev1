package com.example.curso.boot.services;

import com.example.curso.boot.domains.BillCollector;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BillCollectorService {

    BillCollector save(final BillCollector billCollector) throws NotFoundException;
    BillCollector findById(Long id);
    BillCollector update(BillCollector billCollector);
    void delete(Long id) throws NotFoundException;
    List<BillCollector> findAll();

}
