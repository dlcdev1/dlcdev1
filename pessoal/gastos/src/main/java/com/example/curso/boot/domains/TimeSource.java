package com.example.curso.boot.domains;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@SuppressWarnings("serial")
@Table(name = "TIME_SOURCE")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TimeSource extends AbstractEntity<Long> {

    @Column(nullable = false, length = 3)
    @Enumerated(EnumType.STRING)
    private MES mes;

    @Column(nullable = false, length = 4)
    private Integer Year;

    @OneToMany(mappedBy = "timeSource")
    private Set<Bill> bills;

}
