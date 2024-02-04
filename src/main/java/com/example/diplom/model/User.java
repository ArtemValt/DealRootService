package com.example.diplom.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.codehaus.jackson.annotate.JsonIgnore;

import java.time.LocalDateTime;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_contact")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "deal_id")
    @JsonIgnore
    private Deal deal;
}
