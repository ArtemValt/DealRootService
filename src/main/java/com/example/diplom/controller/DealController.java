package com.example.diplom.controller;

import com.example.diplom.facade.DealFacade;
import com.example.diplom.model.Ownership;
import com.example.diplom.model.Root;
import com.example.diplom.model.User;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class DealController {

    private final DealFacade dealFacade;

    @GetMapping("/users")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(), mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok().body(dealFacade.getUsers());
    }

    @GetMapping("/ownership")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(), mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    public ResponseEntity<List<Ownership>> getOwnerShips(@RequestParam List<String> names) {
        return ResponseEntity.ok().body(dealFacade.getOwnerShips(names));
    }

    @GetMapping("/{numberCadastr}/root")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(), mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    public ResponseEntity<Root> getRoot(@PathVariable String numberCadastr) {
        return ResponseEntity.ok().body(dealFacade.getRoot(numberCadastr));
    }

    @GetMapping("/deal")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(), mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    public ResponseEntity<DealFacade.C> getTutorialById(@RequestParam Integer buyerId, @RequestParam List<Integer> sellerId) {
        return ResponseEntity.ok().body(dealFacade.getDeals(buyerId, sellerId));
    }

}