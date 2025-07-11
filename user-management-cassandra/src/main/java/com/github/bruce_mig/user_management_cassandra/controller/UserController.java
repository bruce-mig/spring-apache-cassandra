package com.github.bruce_mig.user_management_cassandra.controller;

import com.github.bruce_mig.user_management_cassandra.model.User;
import com.github.bruce_mig.user_management_cassandra.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    private final UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<List<User>> getUsers(){
        List<User> users = repository.findAll();
        return ResponseEntity.ok(users);
    }
    @GetMapping("/filter")
    public ResponseEntity<List<User>> getUserFilterByAge(@RequestParam int age){
        List<User> users = repository.findByAgeGreaterThan(age);
        return ResponseEntity.ok(users);
    }

    @PostConstruct
    public void saveUser(){
        List<User> users = new ArrayList<>();
        users.add(new User(6347, "User1", "Earth", 25));
        users.add(new User(6348, "User2", "Earth", 28));
        users.add(new User(6349, "User3", "Earth", 27));
        users.add(new User(6350, "User4", "Earth", 22));
        repository.saveAll(users);
    }
}
