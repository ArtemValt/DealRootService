package com.example.diplom.facade;


import com.example.diplom.model.Deal;
import com.example.diplom.model.Ownership;
import com.example.diplom.model.Root;
import com.example.diplom.model.User;
import com.example.diplom.service.DealService;
import com.example.diplom.service.OwnershipService;
import com.example.diplom.service.RootService;
import com.example.diplom.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DealFacade {

    private final UserService userService;
    private final OwnershipService ownershipService;
    private final RootService rootService;
    private final DealService dealService;

    @Cacheable(value = "user", unless="#result == null")
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @Cacheable("ownerShips")
    public List<Ownership> getOwnerShips(List<String> names) {
        return ownershipService.getOwnerShipsByName(names);
    }

    @Cacheable("root")
    public Root getRoot(String numberCadastr) {
        return rootService.getRoot(numberCadastr);
    }

    @Cacheable("deal")
    public Deal getDeals(Integer buyerId, List<Integer> sellersIds) {
        return dealService.getDeals(buyerId, sellersIds);
    }

    public Ownership saveOrUpdateOwnreship(Ownership ownership) {
        return ownershipService.saveOrUpdate(ownership);
    }

    public Root saveOrUpdateRoot(Root root) {
        return rootService.saveOrUpdate(root);
    }
}
