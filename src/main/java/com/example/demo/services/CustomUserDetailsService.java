package com.example.demo.services;

import com.example.demo.entities.Customer;
import com.example.demo.repositories.CustomerRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

@Autowired
    private CustomerRepository customerRepository;
@Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Customer user = customerRepository.findByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return org.springframework.security.core.userdetails.User.withUsername(user.getUserName())
                .password(user.getPassword())
                .authorities("USER") // תוסיפי כאן את התפקידים או הרשאות אם יש
                .build();
    }


    public boolean passwordMatches(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }

    // רישום משתמש חדש
    public  Customer registerUser(String username, String password, String email, String address) {
        if (customerRepository.findByUserName(username) != null) {
            throw new IllegalArgumentException("Username already exists");
        }
        String encodedPassword = passwordEncoder.encode(password); // הצפנת הסיסמה
        Customer user = new Customer(username,encodedPassword,email,address, Customer.Permission.ROLE_USER);
        return customerRepository.save(user);
    }

    // אימות משתמש - נמצא בשירות של Spring Security
    public Customer getUserByUsername(String username) {
        return customerRepository.findByUserName(username);
    }


    }

