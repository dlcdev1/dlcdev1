package com.example.curso.boot.services;

import com.example.curso.boot.domains.Bill;
import com.example.curso.boot.domains.BillCollector;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BillCollectorService {

    BillCollector save(final BillCollector billCollector);
    BillCollector findById(Long id);
    BillCollector update(BillCollector billCollector);
    void delete(Long id);
    List<BillCollector> findAll();

    BillCollector findByName(String name);
}
