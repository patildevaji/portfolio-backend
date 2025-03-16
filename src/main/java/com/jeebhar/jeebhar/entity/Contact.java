package com.jeebhar.jeebhar.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "contact")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String phone;
    private String subject;
    private String message;
}