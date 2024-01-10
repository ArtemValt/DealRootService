package com.example.diplom.service;

import com.example.diplom.model.Ownership;

import java.util.List;

public interface OwnershipService {
    List<Ownership> getOwnerShipsByName(List<String> names);

    Ownership saveOrUpdate(Ownership ownership);

}
