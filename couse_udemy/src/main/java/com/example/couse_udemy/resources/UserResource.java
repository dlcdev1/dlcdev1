package com.example.couse_udemy.resources;

import com.example.couse_udemy.entities.Users;
import com.example.couse_udemy.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<Users>> findAll() {
        List<Users> usersList = service.findAll();
        return ResponseEntity.ok().body(usersList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Users> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

}
