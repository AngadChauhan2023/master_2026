package com.api.management.secure.way.jwtservice;

import java.time.Instant;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.management.secure.way.entity.User;
import com.api.management.secure.way.refreshtoken.RefreshToken;
import com.api.management.secure.way.repository.RefreshTokenRepository;
import com.api.management.secure.way.repository.UserRepository;

@Service
public class RefreshTokenService {

    @Autowired
    private RefreshTokenRepository repository;

    @Autowired
    private UserRepository userRepository;

    public RefreshToken createRefreshToken(String username) {
        User user = userRepository.findByUsername(username);
        RefreshToken token = new RefreshToken();
        token.setUser(user);
        token.setToken(UUID.randomUUID().toString());
        token.setExpiryDate(Instant.now().plusSeconds(86400));
        return repository.save(token);
    }
}
