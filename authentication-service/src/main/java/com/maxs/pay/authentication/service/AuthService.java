package com.maxs.pay.authentication.service;

import com.maxs.pay.authentication.dto.AuthResponse;
import com.maxs.pay.authentication.dto.LoginRequest;
import com.maxs.pay.authentication.dto.RefreshRequest;
import com.maxs.pay.authentication.dto.RegisterRequest;
import com.maxs.pay.authentication.entity.AuthUser;
import com.maxs.pay.authentication.exception.ResourceNotFoundException;
import com.maxs.pay.authentication.repository.AuthUserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final AuthUserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthService(AuthUserRepository repository, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public AuthResponse register(RegisterRequest request){
        AuthUser user = new AuthUser();
        user.setEmail(request.email());
        user.setPasswordHash(passwordEncoder.encode(request.password()));
        user.setRole(request.role());
        user.setActive(Boolean.TRUE);
        repository.save(user);
        return tokenResponse(user.getEmail(), user.getRole());
    }

    public AuthResponse login(LoginRequest request){
        AuthUser user = repository.findByEmail(request.email()).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        if(!passwordEncoder.matches(request.password(), user.getPasswordHash())) throw new IllegalArgumentException("Invalid credentials");
        return tokenResponse(user.getEmail(), user.getRole());
    }

    public AuthResponse refresh(RefreshRequest request){
        return new AuthResponse(request.refreshToken(), request.refreshToken(), "Bearer", 3600);
    }

    private AuthResponse tokenResponse(String subject, String role){
        String token = jwtService.generate(subject, role);
        String refresh = jwtService.generate(subject, role);
        return new AuthResponse(token, refresh, "Bearer", 3600);
    }
}
