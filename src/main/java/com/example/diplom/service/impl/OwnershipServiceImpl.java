package com.example.diplom.service.impl;

import com.example.diplom.model.Ownership;
import com.example.diplom.repository.OwnershipRepository;
import com.example.diplom.service.OwnershipService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class OwnershipServiceImpl implements OwnershipService {

    private final OwnershipRepository ownershipRepository;

    @Override
    public List<Ownership> getOwnerShipsByName(List<String> names) {
        return ownershipRepository.getOwnershipByNames(names);
    }
}
