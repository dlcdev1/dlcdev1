package com.example.couse_udemy.services;

import com.example.couse_udemy.entities.Users;
import com.example.couse_udemy.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<Users> findAll() {
        return repository.findAll();
    }

    public Users findById(Long id) {
        return repository.findById(id).get();
    }

}
