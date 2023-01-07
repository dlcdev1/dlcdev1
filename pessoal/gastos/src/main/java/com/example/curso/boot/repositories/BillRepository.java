package com.example.curso.boot.repositories;

import com.example.curso.boot.domains.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<Bill, Long> {
}
