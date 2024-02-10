package com.example.diplom.repository;

import com.example.diplom.model.Contract;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ContractRepository extends MongoRepository<Contract, Integer> {
}
