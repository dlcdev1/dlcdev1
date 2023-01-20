package com.example.curso.boot.domains;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
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
    private Long id;

    @Column(nullable = false)
    private String mes;

    @Column(nullable = false)
    private Integer year;

    @Column(nullable = false)
    private String mesYear;

    @Column(name = "creat_at")
    @DateTimeFormat(pattern = "dd-MM-YYYY")
    private LocalDate creatAt;

    @OneToMany(mappedBy = "timeSource")
    private Set<Bill> bills;

    @OneToMany(mappedBy = "timeSource")
    private Set<Debtor> debtors;


}
