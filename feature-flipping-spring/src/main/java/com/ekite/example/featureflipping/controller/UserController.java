package com.ekite.example.featureflipping.controller;

import com.ekite.example.featureflipping.model.user.Developer;
import com.ekite.example.featureflipping.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping()
    public List<Developer> getUsers() {
        return userService.getUsers();
    }
}
