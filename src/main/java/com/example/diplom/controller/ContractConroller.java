package com.example.diplom.controller;

import com.example.diplom.facade.FileFacade;
import com.example.diplom.model.Contract;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contract")
@RequiredArgsConstructor
public class ContractConroller {

    private final FileFacade fileFacade;

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
}
