package com.example.diplom.service.impl;

import com.example.diplom.model.Ownership;
import com.example.diplom.repository.OwnershipRepository;
import com.example.diplom.service.OwnershipService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Service
public class OwnershipServiceImpl implements OwnershipService {

    private final OwnershipRepository ownershipRepository;

    @Override
    public List<Ownership> getOwnerShipsByName(List<String> names) {
        return ownershipRepository.getOwnershipByNames(names);
    }

    @Override
    public Ownership saveOrUpdate(Ownership ownership) {
        Integer ownershipId = ownership.getId();
        if (ownershipId != null) {
            Ownership ship = getOwnerShipById(ownershipId);
            return updateShip(ownership, ship);
        } else {
            return saveShip(ownership);
        }
    }

    private Ownership saveShip(Ownership ownership) {
        return ownershipRepository.save(ownership);
    }

    private Ownership updateShip(Ownership ownershipRequest, Ownership ownershipDb) {
        ownershipDb.setNumberOfShip(ownershipRequest.getNumberOfShip());
        ownershipDb.getOwners().clear();
        ownershipDb.setOwners(ownershipDb.getOwners());
        ownershipDb.setNumberEgrn(ownershipDb.getNumberEgrn());
        return ownershipRepository.save(ownershipDb);
    }

    private Ownership getOwnerShipById(Integer id) {
        return ownershipRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }
}
