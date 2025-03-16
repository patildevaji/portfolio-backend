package com.jeebhar.jeebhar.service;
import com.jeebhar.jeebhar.entity.Vlog;

import com.jeebhar.jeebhar.repository.VlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VlogService {

    @Autowired
    private VlogRepository vlogRepository;

    public List<Vlog> getAllVlogs() {
        return vlogRepository.findAll();
    }

    public Vlog addVlog(Vlog vlog) {
        return vlogRepository.save(vlog);
    }
}