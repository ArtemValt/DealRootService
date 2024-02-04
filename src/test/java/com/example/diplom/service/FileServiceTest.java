package com.example.diplom.service;

import com.example.diplom.repository.DealRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.File;
import java.util.Map;

@ExtendWith(MockitoExtension.class)
class FileServiceTest {

    FileService fileService;

    @BeforeEach
    public void setUp() {
        fileService = new FileService();
    }

    @Test
    public void download_ok() {
        fileService.getFileWithoutBookMarks(Map.of("book","qw132"));
    }
}