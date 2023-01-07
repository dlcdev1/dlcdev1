package com.example.curso.boot.services;

import com.example.curso.boot.domains.Bill;
import com.example.curso.boot.repositories.BillRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

@Slf4j
@Service
public class BillServiceImpl implements BillService {

    private BillRepository repo;

    public BillServiceImpl(BillRepository repo) {
        this.repo = repo;
    }


    @Override
    public Bill add(Bill bill) {
        return repo.save(bill);
    }

    @Override
    public Bill findById(Long id) {
        return repo.findById(id).get();
    }

    @Override
    public Bill update(Bill bill) throws NotFoundException {
        return repo.save(bill);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Override
    public List<Bill> findAll() {
        return repo.findAll();
    }
}
