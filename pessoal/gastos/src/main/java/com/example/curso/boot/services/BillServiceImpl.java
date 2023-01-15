package com.example.curso.boot.services;

import com.example.curso.boot.domains.Bill;
import com.example.curso.boot.domains.BillDto;
import com.example.curso.boot.repositories.BillRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class BillServiceImpl implements BillService {

    private BillRepository repo;

    public BillServiceImpl(BillRepository repo) {
        this.repo = repo;
    }


    @Override
    public Bill add(Bill bill) {
        return repo.save(bill);
    }

    @Override
    public Bill findById(Long id) {
        return repo.findById(id).get();
    }

    @Override
    public Bill update(Bill bill) throws NotFoundException {
        return repo.save(bill);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Override
    public BillDto findAll() {

        List<Bill> result = repo.findAll();

        BigDecimal wage = result.get(0).getTimeSource().getDebtors()
                .stream().map(w -> w.getWage()).collect(Collectors.toList()).get(0);

        return BillDto.builder()
                .wage(wage)
                .billList(result)
                .build();
    }
}
