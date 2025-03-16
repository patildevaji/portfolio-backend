package com.jeebhar.jeebhar.controller;

import com.jeebhar.jeebhar.dto.ContactRequest;
import com.jeebhar.jeebhar.service.ContactService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contact")
@CrossOrigin(origins = "*")  // Allow frontend requests
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping
    public ResponseEntity<String> sendEmail(@RequestBody ContactRequest contactRequest) {
        contactService.sendContactEmail(contactRequest);
        return ResponseEntity.ok("Message sent successfully!");
    }
}
