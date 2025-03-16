package com.jeebhar.jeebhar.controller;

import com.jeebhar.jeebhar.entity.Gallery;
import com.jeebhar.jeebhar.service.GalleryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gallery")
@CrossOrigin(origins = "*")
public class GalleryController {

    private final GalleryService galleryService;

    public GalleryController(GalleryService galleryService) {
        this.galleryService = galleryService;
    }

    @GetMapping
    public ResponseEntity<List<Gallery>> getAllImages() {
        return ResponseEntity.ok(galleryService.getAllImages());
    }

    @PostMapping
    public ResponseEntity<String> addImage(@RequestBody Gallery gallery) {
        galleryService.addImage(gallery);
        return ResponseEntity.status(201).body("Image added successfully!");
    }
}
