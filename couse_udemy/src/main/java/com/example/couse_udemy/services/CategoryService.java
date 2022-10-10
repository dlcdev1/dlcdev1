package com.example.couse_udemy.services;

import com.example.couse_udemy.entities.Category;
import com.example.couse_udemy.entities.Users;
import com.example.couse_udemy.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public List<Category> findAll() {
        return repository.findAll();
    }

    public Category findById(Long id) {
        return repository.findById(id).get();
    }

}
