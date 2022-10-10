package com.example.couse_udemy.repositories;

import com.example.couse_udemy.entities.Product;
import com.example.couse_udemy.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
