package com.example.diplom.service;

import com.example.diplom.model.Contract;
import com.example.diplom.repository.ContractRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.NoSuchElementException;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class ContractServiceTest {
    @Mock
    ContractRepository contractRepository;

    ContractService contractService;

    @BeforeEach
    public void setUp() {
        contractService = new ContractService(contractRepository);
    }

    @Test
    void getContract_ok() {
        int id = 1;
        Contract contract = new Contract();
        contract.setId(id);
        contract.setContractDate(LocalDateTime.MAX);
        Mockito.when(contractRepository.findById(id)).thenReturn(Optional.of(contract));
        Contract contractById = contractService.getContractById(id);
        Assertions.assertEquals(contract, contractById);
    }

    @Test
    void getContract_bad() {
        Mockito.when(contractRepository.findById(2)).thenReturn(Optional.empty());
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            contractService.getContractById(2);
        });
    }
}