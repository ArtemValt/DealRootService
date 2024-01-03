package com.example.diplom.service.impl;

import com.example.diplom.model.Deal;
import com.example.diplom.model.User;
import com.example.diplom.repository.DealRepository;
import com.example.diplom.service.DealService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DealServiceImpl implements DealService {
    private final DealRepository dealRepository;

    @Override
    public Deal getDeals(Integer buyerId, List<Integer> sellerIds) {
        return dealRepository.findByBuyerAndSeller(buyerId, sellerIds);
    }
}
