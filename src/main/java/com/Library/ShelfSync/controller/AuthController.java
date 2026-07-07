package com.Library.ShelfSync.controller;

import com.Library.ShelfSync.dto.AuthResponse;
import com.Library.ShelfSync.dto.LoginRequest;
import com.Library.ShelfSync.dto.RegisterRequest;
import com.Library.ShelfSync.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/api/auth/register")
    ResponseEntity<AuthResponse> HandleRegister(@RequestBody RegisterRequest registerRequest){
        AuthResponse response = authService.register(registerRequest);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/api/auth/login")
    ResponseEntity<AuthResponse> HandleLogin(@RequestBody LoginRequest loginRequest){
        AuthResponse response = authService.login(loginRequest);
        return ResponseEntity.ok(response);
    }

}
