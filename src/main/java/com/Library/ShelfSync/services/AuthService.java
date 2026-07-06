package com.Library.ShelfSync.services;


import com.Library.ShelfSync.dto.AuthResponse;
import com.Library.ShelfSync.dto.LoginRequest;
import com.Library.ShelfSync.dto.RegisterRequest;
import com.Library.ShelfSync.models.UserEntity;
import com.Library.ShelfSync.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private Jwtservice jwtservice;

    public AuthResponse register (RegisterRequest request) {

        String encodedpassword = passwordEncoder.encode(request.getPassword());

        UserEntity user = new UserEntity(
                request.getFirstName(),
                request.getLastName(),
                request.getEmail(),
                encodedpassword,
                request.getPhoneNumber()
        );

        userRepo.save(user);

        String token = jwtservice.generateToken(request.getEmail());
        return new AuthResponse(token);
    }

    public AuthResponse login(LoginRequest request) {
        UserEntity user =  userRepo.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User Not Found"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid Password");
        }

        String token = jwtservice.generateToken(user.getEmail());
        return new AuthResponse(token);
    }

}