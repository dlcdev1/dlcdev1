package com.example.curso.boot.domains;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@SuppressWarnings("serial")
@Table(name = "BILL_COLLECTORS")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BillCollector extends AbstractEntity<Long> {

    @Column(nullable = false, unique = true)
    private String name;

    private String typeService;

    private String site;

    @OneToMany(mappedBy = "billCollector")
    private Set<Bill> bills;

}
