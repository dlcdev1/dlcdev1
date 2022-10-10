package com.example.couse_udemy.repositories;

import com.example.couse_udemy.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
