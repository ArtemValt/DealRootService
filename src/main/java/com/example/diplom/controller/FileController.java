package com.example.diplom.controller;

import com.example.diplom.facade.FileFacade;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@RestController
@RequestMapping("/file")
@RequiredArgsConstructor
public class FileController {

    private final FileFacade fileFacade;

    @GetMapping
    @RequestMapping(path = "/{dealId}/download")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(), mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    public ResponseEntity<Resource> downloadFile(@PathVariable Integer dealId) throws IOException {

        File file = fileFacade.getFileWithoutBookMarks(dealId);
        ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(Path.of(file.getAbsolutePath())));

        return ResponseEntity.ok()
                .headers(getHttpHeaders())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .contentLength(file.length())
                .body(resource);
    }

    private static HttpHeaders getHttpHeaders() {
        HttpHeaders header = new HttpHeaders();
        header.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=dq.docx");
        header.add("Cache-Control", "no-cache, no-store, must-revalidate");
        header.add("Pragma", "no-cache");
        header.add("Expires", "0");
        return header;
    }
}
