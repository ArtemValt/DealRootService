package com.example.diplom.controller;

import com.example.diplom.facade.FileFacade;
import com.example.diplom.model.Contract;
import com.example.diplom.service.ContractService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contract")
@RequiredArgsConstructor
public class ContractController {

    private final FileFacade fileFacade;
    private final ContractService contractService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(path = "/save")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(), mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    public ResponseEntity<Contract> downloadFile(@RequestBody Contract contract ) {
        Contract saveContact = fileFacade.saveContact(contract);
        return ResponseEntity.ok(saveContact);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(), mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    public ResponseEntity<List<Contract>> getContacts() {
        return ResponseEntity.ok(contractService.getAllContacts());
    }
}
