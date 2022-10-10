package com.example.couse_udemy.services;

import com.example.couse_udemy.entities.Order;
import com.example.couse_udemy.entities.Users;
import com.example.couse_udemy.repositories.OrderRepository;
import com.example.couse_udemy.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    public List<Order> findAll() {
        return repository.findAll();
    }

    public Order findById(Long id) {
        return repository.findById(id).get();
    }

}
