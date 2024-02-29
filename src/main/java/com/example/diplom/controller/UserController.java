package com.example.diplom.controller;

import com.example.diplom.model.UserMongo;
import com.example.diplom.service.UserService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(path = "/save")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(), mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})

    public ResponseEntity<UserMongo> createUser(@RequestBody UserMongo userMongo) {
        return ResponseEntity.ok(userService.creteUser(userMongo));
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(path = "/login")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(), mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})

    public ResponseEntity<String> loginUser(@RequestParam String email, @RequestParam String password) {
        return ResponseEntity.ok(userService.loginUser(email, password));
    }


}
