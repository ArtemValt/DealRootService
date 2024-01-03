package com.example.diplom.service.impl;

import com.example.diplom.model.User;
import com.example.diplom.repository.UserRepository;
import com.example.diplom.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        List<User> all = userRepository.findAll();
        return null;
    }

    @Override
    public User findUserById(Integer userId) {
        return userRepository.findById(userId).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<User> findUsersById(List<Integer> userId) {
        return userRepository.findAllById(userId);
    }
}
