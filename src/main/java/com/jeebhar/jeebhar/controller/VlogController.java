package com.jeebhar.jeebhar.controller;

import com.jeebhar.jeebhar.entity.Vlog;
import com.jeebhar.jeebhar.service.VlogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vlog")
@CrossOrigin(origins = "*")
public class VlogController {

    private final VlogService vlogService;

    public VlogController(VlogService vlogService) {
        this.vlogService = vlogService;
    }

    @GetMapping
    public ResponseEntity<List<Vlog>> getAllVlogs() {
        return ResponseEntity.ok(vlogService.getAllVlogs());
    }

    @PostMapping
    public ResponseEntity<String> addVlog(@RequestBody Vlog vlog) {
        vlogService.addVlog(vlog);
        return ResponseEntity.status(201).body("Vlog added successfully!");
    }
}
