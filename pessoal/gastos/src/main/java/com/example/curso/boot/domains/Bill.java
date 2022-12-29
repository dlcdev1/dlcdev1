package com.example.curso.boot.domains;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private BigDecimal value;

    @Column(name = "due_date")
    private LocalDate dueDate;

    @Column
    private Boolean paidOut = false;

    @OneToMany(mappedBy = "bill")
    private Set<Debtor> debtors;

    @ManyToOne
    @JoinColumn(name = "idBillCollector")
    private BillCollector billCollector;

    @ManyToOne
    @JoinColumn(name = "idBillTimeSource")
    private TimeSource timeSource;
}
