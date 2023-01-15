package com.example.curso.boot.services;

import com.example.curso.boot.domains.Bill;
import com.example.curso.boot.domains.BillDto;
import com.example.curso.boot.domains.Category;
import org.webjars.NotFoundException;

import java.util.List;

public interface BillService {

    Bill add(final Bill bill);

    Bill findById(Long id);

    Bill update(Bill bill) throws NotFoundException;

    void delete(Long id);

    BillDto findAll();

}
