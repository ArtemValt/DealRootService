package com.example.diplom.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;

public record FileToDownload(MediaType mediaType, InputStreamResource inputStreamResource) {}
