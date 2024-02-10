package com.example.diplom.facade;

import com.example.diplom.model.Contract;
import com.example.diplom.service.ContractService;
import com.example.diplom.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Transactional
public class FileFacade {
    private final FileService fileService;
    private final ContractService contractService;

    public Contract saveContact(Contract contract) {
        return contractService.saveContract(contract);
    }

    public File getFileWithoutBookMarks(Integer contractId) {
        Contract contract = contractService.getContractById(contractId);
        Map<String, String> bookMarksForContract = getBookMarksForContract(contract);
        return fileService.getFileWithoutBookMarks(bookMarksForContract);
    }

    private Map<String, String> getBookMarksForContract(Contract contract) {
        Map<String, String> map = new HashMap<>();
        map.put("city", contract.getCity());
        map.put("conractDate", contract.getContractDate().toString());
        return map;
    }


}
