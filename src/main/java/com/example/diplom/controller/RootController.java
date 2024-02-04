package com.example.diplom.controller;

import com.example.diplom.facade.DealFacade;
import com.example.diplom.model.Ownership;
import com.example.diplom.model.Root;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("root")
@RequiredArgsConstructor
public class RootController {
    private final DealFacade facade;
    @PostMapping("/save-uodate-root")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(), mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    public ResponseEntity<Root> saveOrUpdateOwnership(@Valid Root root) {
        Root rootResponse = facade.saveOrUpdateRoot(root);
        return ResponseEntity.ok().body(rootResponse);
    }
}
