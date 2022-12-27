package com.example.curso.boot.domains;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@SuppressWarnings("serial")
@Table(name = "DEBTORS")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Debtor extends AbstractEntity<Long> {

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private BigDecimal wage;

    @Column(name = "entry_date")
    private LocalDate entryDate;
    @ManyToOne
    @JoinColumn(name = "id_bill")
    private Bill bill;

}
