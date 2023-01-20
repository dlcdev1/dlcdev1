package com.example.curso.boot.services;

import com.example.curso.boot.domains.MES;
import com.example.curso.boot.domains.TimeSource;
import com.example.curso.boot.repositories.TimeSourceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@Service
public class TimeSourceImpl implements TimeSourceService {

    private TimeSourceRepository repo;

    public TimeSourceImpl(TimeSourceRepository repo) {
        this.repo = repo;
    }

    @Override
    public TimeSource add(final TimeSource timeSource) {
        TimeSource saveTimeSource = factoryMesYear(timeSource);
        return repo.save(saveTimeSource);
    }

    @Override
    public TimeSource findById(Long id) {
        return repo.findById(id).get();
    }

    @Override
    public Boolean findByMesAndYear(String mes, Integer year) {
        TimeSource byMesAndYear = repo.findByMesAndYear(mes, year);
        if (Objects.isNull(byMesAndYear)) {
            return false;
        }
        return true;
    }

    @Override
    public TimeSource update(TimeSource timeSource) throws NotFoundException {
        TimeSource updateTimeSource = factoryMesYear(timeSource);
        return repo.save(updateTimeSource);
    }

    private static TimeSource factoryMesYear(TimeSource timeSource) {
        final Integer year = timeSource.getYear();
        final String mes = timeSource.getMes();
        final LocalDate creatAt = LocalDate.of(
                year, MES.valueOf(mes.toUpperCase()).getDescricao(),
                LocalDate.now().getDayOfMonth()
        );

        String mesYear = mes + '-' + year;
        return TimeSource.builder()
                .year(timeSource.getYear())
                .mes(timeSource.getMes())
                .mesYear(mesYear)
                .creatAt(creatAt)
                .build();
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Override
    public List<TimeSource> findAll() {

        return repo.findAll().stream().sorted(
                        Collections.reverseOrder(
                                Comparator.comparing(
                                TimeSource::getCreatAt)
                        )
                )
                .collect(Collectors.toList());
    }

}
