package com.example.couse_udemy.config;

import com.example.couse_udemy.entities.Users;
import com.example.couse_udemy.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    // injeção de dependencia
    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        Users u1 = new Users(null, "Maria Brown", "maria@gmail.com", "9888888", "123456");
        Users u2 = new Users(null, "Alex Green", "alex@gmail.com", "9777777", "123456");
        userRepository.saveAll(Arrays.asList(u1, u2));
    }
}
