package com.jeebhar.jeebhar.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "vlog")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Vlog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String instagramVideoUrl;
}
