package com.example.demo.controllers;

import com.example.demo.Auth.JwtUtil;
import com.example.demo.entities.Customer;
import com.example.demo.services.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")

public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @PostMapping("/register")
    public Customer registerUser(@RequestParam String username, @RequestParam String password, @RequestParam String email,@RequestParam String address) {
        return userDetailsService.registerUser(username,password,email,address);
    }

@PostMapping("/login")
public String login(@RequestParam String username, @RequestParam String password) {
    Customer user = userDetailsService.getUserByUsername(username);
    if (user == null || !userDetailsService.passwordMatches(password, user.getPassword())) {
        throw new IllegalArgumentException("Invalid credentials");
    }
    return jwtUtil.generateToken(username);
}
}
