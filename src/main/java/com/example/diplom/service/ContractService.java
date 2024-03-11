package com.example.diplom.service;

import com.example.diplom.model.Contract;
import com.example.diplom.repository.ContractRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ContractService {

    private final ContractRepository contractRepository;


    public Contract getContractById(Integer id) {
        return contractRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }
    public List<Contract> getAllContacts(){
        return contractRepository.findAll();
    }

    public Contract saveContract(Contract contract){
        return contractRepository.save(contract);
    }
}
