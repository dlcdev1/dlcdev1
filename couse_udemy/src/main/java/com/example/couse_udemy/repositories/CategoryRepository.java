package com.example.couse_udemy.repositories;

import com.example.couse_udemy.entities.Category;
import com.example.couse_udemy.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
