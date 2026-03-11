package com.maxs.pay.authentication.controller;
import com.maxs.pay.authentication.entity.AuthUser; import com.maxs.pay.authentication.service.AuthService; import jakarta.validation.Valid; import com.maxs.pay.authentication.dto.*;
import org.springframework.http.ResponseEntity; import org.springframework.web.bind.annotation.*; import java.util.List;
@RestController @RequestMapping("/auth") public class AuthController { private final AuthService service; public AuthController(AuthService service){this.service=service;} 
    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@Valid @RequestBody RegisterRequest request){ return ResponseEntity.ok(service.register(request)); }
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody LoginRequest request){ return ResponseEntity.ok(service.login(request)); }
    @PostMapping("/refresh")
    public ResponseEntity<AuthResponse> refresh(@RequestBody RefreshRequest request){ return ResponseEntity.ok(service.refresh(request)); }
 }