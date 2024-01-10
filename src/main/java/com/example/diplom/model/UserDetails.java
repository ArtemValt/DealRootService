package com.example.diplom.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
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
    @Email
    private String email;

}
