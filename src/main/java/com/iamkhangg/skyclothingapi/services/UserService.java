package com.iamkhangg.skyclothingapi.services;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.iamkhangg.skyclothingapi.entities.User;
import com.iamkhangg.skyclothingapi.models.RegisterRequest;
import com.iamkhangg.skyclothingapi.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String registerUser(RegisterRequest request) {
        // Check if email is already used
        Optional<User> existingUser = userRepository.findByEmail(request.getEmail());
        if (existingUser.isPresent()) {
            return "Email is already in use";
        }

        // Check if date of birth is valid (e.g., not in the future)
        if (request.getDateOfBirth().isAfter(LocalDate.now())) {
            return "Date of birth is not valid";
        }

        User user = new User();
        user.setFullName(request.getFullName());
        user.setEmail(request.getEmail());
        user.setGender(request.getGender());
        user.setDateOfBirth(request.getDateOfBirth());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(request.getRole());
        userRepository.save(user);

        return "User registered successfully";
    }
}
