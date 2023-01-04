package com.example.curso.boot.services;

import com.example.curso.boot.domains.BillCollector;
import com.example.curso.boot.repositories.BillCollectorsRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class BillCollectorServiceImplTest {

    @Mock
    private BillCollectorsRepository repository;

    @InjectMocks
    private BillCollectorServiceImpl service;


    @Test
    void testAddNewBillCollertor() {

        BillCollector billCollector = BillCollector.builder()
                .name("Cemig")
                .build();

        BillCollector billCollectorMock = BillCollector.builder()
                .id(1L)
                .name("Cemig")
                .build();


        when(repository.save(any(BillCollector.class))).thenReturn(billCollectorMock);

        final var result = service.add(billCollector);

        assertEquals(1L, result.getId());
        assertEquals(result.getName(), billCollector.getName());
        assertNotNull(result);

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