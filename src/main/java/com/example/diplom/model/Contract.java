package com.example.diplom.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Document("contract")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Contract implements Serializable {

    @Id
    private Integer id;
    private Integer userId;
    private LocalDateTime contractDate;
    private String city;
    private UserDetails seller;
    private UserDetails buyer;
    private Room room;

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public static class UserDetails {
        private String name;
        private String secondName;
        private String surName;
        @Size(min = 4, max = 4, message = "serialPass need to have only 4 characters")
        private String serialPass;
        @Size(min = 6, max = 6, message = "numberPass need to have only 4 characters")
        private String numberPass;
        private LocalDateTime dateExt;
        private String whoExt;
        private String livingAddress;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public static class Room {
        private BigDecimal meters;
        private Integer floor;
        @NotBlank
        private String fullAddress;
        @NotBlank
        @Positive
        private String numberCadastr;
    }
}
