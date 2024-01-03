package com.example.diplom.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_root")
@Getter
@Setter
public class Root {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private BigDecimal meters;
    private Integer floor;
    private String fullAddress;
    private String numberCadastr;
    @OneToOne
    @JoinColumn(name = "ownership_id")
    private Ownership ownership;

}
