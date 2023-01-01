package com.example.curso.boot.services;

import com.example.curso.boot.domains.BillCollector;
import com.example.curso.boot.repositories.BillCollectorsRepository;
import javassist.NotFoundException;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
@SpringBootTest
class BillCollectorServiceImplTest {

    @Autowired
    private BillCollectorsRepository repository;

    @Mock
    private BillCollectorService billCollectorService;

    @Test
    void save() throws NotFoundException {
        BillCollector billCollector = BillCollector.builder()
                .id(1L)
                .name("Cemig")
                .typeService("Eletrico")
                .build();


        when(repository.save(any())).thenReturn(billCollector);
        BillCollector save = billCollectorService.save(billCollector);

        assertNotNull(save);


    }

    @Test
    void findById() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void findAll() {
    }
}