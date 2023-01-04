package com.example.curso.boot.repositories;

import com.example.curso.boot.domains.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
