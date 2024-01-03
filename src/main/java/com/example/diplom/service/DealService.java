package com.example.diplom.service;

import com.example.diplom.model.Deal;
import com.example.diplom.model.User;

import java.util.List;

public interface DealService {
    Deal getDeals(Integer buyerId, List<Integer> sellerIds);
}
