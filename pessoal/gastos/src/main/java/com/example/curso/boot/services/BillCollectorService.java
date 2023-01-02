package com.example.curso.boot.services;

import com.example.curso.boot.domains.BillCollector;

import java.util.List;

public interface BillCollectorService {

    BillCollector add(final BillCollector billCollector);
    BillCollector findById(Long id);
    BillCollector update(BillCollector billCollector);
    void delete(Long id);
    List<BillCollector> findAll();

    BillCollector findByName(String name);
}
