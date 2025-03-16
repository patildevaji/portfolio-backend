package com.jeebhar.jeebhar.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "gallery")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Gallery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imageUrl;
}