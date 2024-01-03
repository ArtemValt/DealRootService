package com.example.diplom.repository;

import com.example.diplom.model.Deal;
import com.example.diplom.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DealRepository extends JpaRepository<Deal, Integer> {
    @Query("""
            select d FROM Deal d
            join d.seller s
            where d.buyer.id = :buyerId and s.id in (:sellersId)
            """)
    Deal findByBuyerAndSeller(Integer buyerId, List<Integer> sellersId);
}
