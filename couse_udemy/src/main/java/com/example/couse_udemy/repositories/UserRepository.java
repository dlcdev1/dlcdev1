package com.example.couse_udemy.repositories;

import com.example.couse_udemy.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
}