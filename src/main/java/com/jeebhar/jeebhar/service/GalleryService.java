package com.jeebhar.jeebhar.service;

import com.jeebhar.jeebhar.entity.Gallery;
import com.jeebhar.jeebhar.repository.GalleryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GalleryService {

    private final GalleryRepository galleryRepository;

    public GalleryService(GalleryRepository galleryRepository) {
        this.galleryRepository = galleryRepository;
    }

    public List<Gallery> getAllImages() {
        return galleryRepository.findAll();
    }

    public void addImage(Gallery gallery) {
        galleryRepository.save(gallery);
    }
}
