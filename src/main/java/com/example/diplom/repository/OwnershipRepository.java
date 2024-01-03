package com.example.diplom.repository;

import com.example.diplom.model.Ownership;
import com.example.diplom.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OwnershipRepository extends JpaRepository<Ownership, Integer> {

    @Query("select o from Ownership o where exists (select 1 from User where name in(:names))")
    List<Ownership> getOwnershipByNames(List<String> names);
}
