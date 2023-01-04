package com.example.curso.boot.services;

import com.example.curso.boot.domains.BillCollector;
import com.example.curso.boot.domains.Category;
import org.webjars.NotFoundException;

import java.util.List;

public interface CategoryService {

    Category add(final Category category);

    Category findById(Long id);

    Category update(Category category) throws NotFoundException;

    void delete(Long id);

    List<Category> findAll();

    boolean findByBillCollectors(Long id);

}
