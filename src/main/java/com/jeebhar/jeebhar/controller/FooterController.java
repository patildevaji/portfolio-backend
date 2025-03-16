package com.jeebhar.jeebhar.controller;

import com.jeebhar.jeebhar.entity.Footer;
import com.jeebhar.jeebhar.service.FooterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/footer")
public class FooterController {

    @Autowired
    private FooterService footerService;

    @GetMapping
    public Footer getFooterDetails() {
        return footerService.getFooterDetails();
    }

    @PostMapping
    public Footer saveFooterDetails(@RequestBody Footer footer) {
        return footerService.saveFooterDetails(footer);
    }
}