package com.jeebhar.jeebhar.service;

import com.jeebhar.jeebhar.dto.ContactRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class ContactService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendContactEmail(ContactRequest contactRequest) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo("your-email@gmail.com");  // The email where you receive inquiries
            helper.setSubject("New Contact Request from " + contactRequest.getName());
            helper.setFrom(contactRequest.getEmail()); // Sender's email
            helper.setReplyTo(contactRequest.getEmail());

            String emailContent = "<p><strong>Name:</strong> " + contactRequest.getName() + "</p>"
                    + "<p><strong>Email:</strong> " + contactRequest.getEmail() + "</p>"
                    + "<p><strong>Phone:</strong> " + contactRequest.getPhone() + "</p>"
                    + "<p><strong>Subject:</strong> " + contactRequest.getSubject() + "</p>"
                    + "<p><strong>Message:</strong> " + contactRequest.getMessage() + "</p>";

            helper.setText(emailContent, true); // Enable HTML

            mailSender.send(message);

        } catch (MessagingException e) {
            throw new RuntimeException("Failed to send email", e);
        }
    }
}