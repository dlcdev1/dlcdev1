package com.example.curso.boot.domains;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TimeSource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private java.lang.Long id;

    @Column(nullable = false, length = 3)
    @Enumerated(EnumType.STRING)
    private MES mes;

    @Column(nullable = false, length = 4)
    private Integer Year;

//    @OneToMany(mappedBy = "timeSource")
//    private Set<Bill> bills;

}
