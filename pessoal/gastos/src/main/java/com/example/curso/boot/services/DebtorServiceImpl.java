package com.example.curso.boot.services;

import com.example.curso.boot.domains.Bill;
import com.example.curso.boot.domains.Debtor;
import com.example.curso.boot.repositories.BillRepository;
import com.example.curso.boot.repositories.DebtorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

@Slf4j
@Service
public class DebtorServiceImpl implements DebtorService {

    private DebtorRepository repo;

    @Override
    public Debtor add(Debtor debtor) {
        return repo.save(debtor);
    }

    @Override
    public Debtor findById(Long id) {
        return repo.findById(id).get();
    }

    @Override
    public Debtor update(Debtor debtor) throws NotFoundException {
        return repo.save(debtor);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Override
    public List<Debtor> findAll() {
        return repo.findAll();
    }
}
