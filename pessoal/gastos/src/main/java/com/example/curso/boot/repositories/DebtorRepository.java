package com.example.curso.boot.repositories;

import com.example.curso.boot.domains.Debtor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DebtorRepository extends JpaRepository<Debtor, Long> {
}
