package com.api.management.secure.way.jwtservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.api.management.secure.way.dto.LoginRequest;
import com.api.management.secure.way.dto.RegisterRequest;
import com.api.management.secure.way.entity.AuthResponse;
import com.api.management.secure.way.entity.User;
import com.api.management.secure.way.repository.UserRepository;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private RefreshTokenService refreshTokenService;

    public AuthResponse register(RegisterRequest request) {

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(encoder.encode(request.getPassword()));
        user.setRole(request.getRole());

        userRepository.save(user);

        String accessToken = jwtService.generateToken(user.getUsername());
        String refreshToken = refreshTokenService
                .createRefreshToken(user.getUsername())
                .getToken();

        return new AuthResponse(accessToken, refreshToken);
    }

    public AuthResponse login(LoginRequest request) {

        User user = userRepository
                .findByUsername(request.getUsername());

        if (!encoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        String accessToken = jwtService.generateToken(user.getUsername());
        String refreshToken = refreshTokenService
                .createRefreshToken(user.getUsername())
                .getToken();

        return new AuthResponse(accessToken, refreshToken);
    }
}