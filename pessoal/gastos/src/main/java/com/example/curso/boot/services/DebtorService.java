package com.example.curso.boot.services;

import com.example.curso.boot.domains.Debtor;
import org.webjars.NotFoundException;

import java.util.List;

public interface DebtorService {

    Debtor add(final Debtor debtor);

    Debtor findById(Long id);

    Debtor update(Debtor debtor) throws NotFoundException;

    void delete(Long id);

    List<Debtor> findAll();

}
