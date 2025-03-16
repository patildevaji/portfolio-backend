package com.jeebhar.jeebhar.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "footer")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Footer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String address;
    private String phone;
    private String email;
    private String youtubeUrl;
    private String instagramUrl;
    private String facebookUrl;
    private String tiktokUrl;
}