package com.example.diplom.service;

import com.example.diplom.model.UserMongo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<UserMongo, Integer> {

    Optional<UserMongo> findByEmail(String email);

    Optional<UserMongo> findByEmailAndPassword(String email,String password);

}
