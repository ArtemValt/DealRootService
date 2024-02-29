package com.example.diplom.service;

import com.example.diplom.model.UserMongo;
import com.example.diplom.security.jwtToken.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final JwtService jwtService;

    public UserMongo creteUser(UserMongo userMongo) {
        return userRepository.save(userMongo);
    }

    public String loginUser(String email, String password) {
        UserMongo user = userRepository.findByEmailAndPassword(email, password)
                .orElseThrow(() -> new UsernameNotFoundException("Пользователь не найден"));
        return jwtService.generateToken(user.getId(), user);
    }

}
