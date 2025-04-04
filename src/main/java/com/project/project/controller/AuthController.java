package com.project.project.controller;

import com.project.project.entity.User;
import com.project.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    // Endpoint de login
    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> credentials) {
        Map<String, String> response = new HashMap<>();

        String username = credentials.get("username");
        String password = credentials.get("password");

        if (userService.validateUser(username, password)) {
            response.put("message", "Login successful");
        } else {
            response.put("message", "Invalid username or password");
        }

        return response;
    }

    // Endpoint para registrar un usuario (opcional, solo para pruebas)
    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.registerUser(user);
    }
}


