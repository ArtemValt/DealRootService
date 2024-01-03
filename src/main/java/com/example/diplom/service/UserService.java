package com.example.diplom.service;


import com.example.diplom.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User findUserById(Integer userId);
    List<User> findUsersById(List<Integer> userId);

}
