package com.example.curso.boot.domains;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Entity
@SuppressWarnings("serial")
@Table(name = "BILLS")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Bill extends AbstractEntity <Long>{

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private BigDecimal value;

    @Column(name = "due_date")
    private LocalDate dueDate;

    @Column
    private Boolean paidOut = false;

    @ManyToMany(mappedBy = "bill")
    @JsonIgnoreProperties("bills")
    private Set<Debtor> debtors;

}
