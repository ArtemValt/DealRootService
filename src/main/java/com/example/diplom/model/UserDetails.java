package com.example.diplom.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user_details")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String password;
    @ToString.Exclude
    private String email;

}
