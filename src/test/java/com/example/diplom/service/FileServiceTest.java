package com.example.diplom.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

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