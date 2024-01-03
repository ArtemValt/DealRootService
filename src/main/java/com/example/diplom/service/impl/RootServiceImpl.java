package com.example.diplom.service.impl;

import com.example.diplom.model.Root;
import com.example.diplom.repository.RootRepository;
import com.example.diplom.service.RootService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RootServiceImpl implements RootService {
    private final RootRepository rootRepository;

    @Override
    public Root getRoot(String numberCadastr) {
        return rootRepository.findByNumberCadastr(numberCadastr);
    }
}
