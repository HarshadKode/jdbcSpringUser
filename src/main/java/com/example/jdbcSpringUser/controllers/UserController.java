package com.example.jdbcSpringUser.controllers;

import com.example.jdbcSpringUser.Services.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;
}
