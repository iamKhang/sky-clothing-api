package com.iamkhangg.skyclothingapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iamkhangg.skyclothingapi.entities.User;
import com.iamkhangg.skyclothingapi.models.AuthenticationRequest;
import com.iamkhangg.skyclothingapi.models.AuthenticationResponse;
import com.iamkhangg.skyclothingapi.models.RegisterRequest;
import com.iamkhangg.skyclothingapi.services.UserDetailsServiceImpl;
import com.iamkhangg.skyclothingapi.services.UserService;
import com.iamkhangg.skyclothingapi.services.TokenBlacklistService;
import com.iamkhangg.skyclothingapi.utils.JwtUtil;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private UserService userService;

    @Autowired
    private TokenBlacklistService tokenBlacklistService;

    @PostMapping("/authenticate")
    public AuthenticationResponse authenticate(@RequestBody AuthenticationRequest request) throws Exception {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );

        final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmail());
        final String jwt = jwtUtil.generateToken(userDetails);
        final String fullName = ((User) userDetails).getFullName();

        return new AuthenticationResponse(jwt, fullName);
    }
    
    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request) {
        return userService.registerUser(request);
    }
    
    @PostMapping("/validate")
    public ResponseEntity<?> validateToken(@RequestHeader("Authorization") String authHeader) {
        try {
            if (authHeader != null && authHeader.startsWith("Bearer ")) {
                String token = authHeader.substring(7);
                String email = jwtUtil.extractUsername(token);
                UserDetails userDetails = userDetailsService.loadUserByUsername(email);
                
                if (jwtUtil.validateToken(token, userDetails)) {
                    User user = (User) userDetails;
                    return ResponseEntity.ok(new AuthenticationResponse(token, user.getFullName()));
                }
            }
            return ResponseEntity.badRequest().body("Invalid token");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Token validation failed");
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(@RequestHeader("Authorization") String authHeader) {
        try {
            if (authHeader != null && authHeader.startsWith("Bearer ")) {
                String token = authHeader.substring(7);
                
                if (jwtUtil.isTokenValid(token)) {
                    tokenBlacklistService.blacklistToken(token);
                    return ResponseEntity.ok().body("Logged out successfully");
                }
            }
            return ResponseEntity.badRequest().body("Invalid token");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Logout failed");
        }
    }
}
