package com.example.couse_udemy.services;

import com.example.couse_udemy.entities.Product;
import com.example.couse_udemy.entities.Users;
import com.example.couse_udemy.repositories.ProductRepository;
import com.example.couse_udemy.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> findAll() {
        return repository.findAll();
    }

    public Product findById(Long id) {
        return repository.findById(id).get();
    }

}
