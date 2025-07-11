package com.github.bruce_mig.reactive_user_management.controller;

import com.github.bruce_mig.reactive_user_management.model.User;
import com.github.bruce_mig.reactive_user_management.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/reactive")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public Flux<User> getUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/filter/address")
    public Mono<User> getUserByAddress(@RequestParam String address){
        return userRepository.findByAddress(address);
    }

    @GetMapping("/filter/age")
    public Flux<User> getUserByAge(@RequestParam int age){
        return userRepository.findByAgeLessThan(age);
    }

}
