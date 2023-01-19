package com.example.curso.boot.repositories;

import com.example.curso.boot.domains.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BillRepository extends JpaRepository<Bill, Long> {
    @Query("SELECT time from Bill time where time.timeSource.id = ?1")
    List<Bill> findBillByTimeSourceId(Long id);
}
