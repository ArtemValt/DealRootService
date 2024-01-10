package com.example.diplom.model;

import com.example.diplom.security.annotation.ValidEgrn;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ownership")
@Getter
@Setter
public class Ownership {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String numberOfShip;
    @ValidEgrn
    private String numberEgrn;

    @OneToMany(orphanRemoval = true)
    List<User> owners = new LinkedList<>();
}
