package com.example.curso.boot.domains;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

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

    @ManyToMany
    @JoinTable(name = "debtor_bill",
            joinColumns = @JoinColumn(name = "debtor_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "bill_id", referencedColumnName = "id")
    )
    @JsonIgnoreProperties("debtor")
    private Set<Bill> bill;

}
