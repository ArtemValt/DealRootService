package com.example.diplom.repository;

import com.example.diplom.model.Root;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RootRepository extends JpaRepository<Root, Integer> {
    Root findByNumberCadastr(String numberCadastr);
}
