package com.jeebhar.jeebhar.service;

import com.jeebhar.jeebhar.entity.Footer;
import com.jeebhar.jeebhar.repository.FooterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FooterService {

    @Autowired
    private FooterRepository footerRepository;

    public Footer getFooterDetails() {
        return footerRepository.findAll().stream().findFirst().orElse(null);
    }

    public Footer saveFooterDetails(Footer footer) {
        return footerRepository.save(footer);
    }
}