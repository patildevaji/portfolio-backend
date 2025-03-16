package com.jeebhar.jeebhar.service;

import com.jeebhar.jeebhar.dto.ContactRequest;
import jakarta.mail.internet.MimeMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ContactServiceTest {

    @Mock
    private JavaMailSender mailSender;

    @InjectMocks
    private ContactService contactService;

    private ContactRequest contactRequest;

    @BeforeEach
    void setUp() {
        contactRequest = new ContactRequest();
        contactRequest.setName("John Doe");
        contactRequest.setEmail("johndoe@example.com");
        contactRequest.setPhone("+1234567890");
        contactRequest.setSubject("Inquiry");
        contactRequest.setMessage("I would like to collaborate.");
    }

    @Test
    void testSendContactEmail() throws Exception {
        MimeMessage mimeMessage = mock(MimeMessage.class);
        MimeMessageHelper helper = mock(MimeMessageHelper.class);

        when(mailSender.createMimeMessage()).thenReturn(mimeMessage);

        contactService.sendContactEmail(contactRequest);

        verify(mailSender, times(1)).send(mimeMessage);
    }
}
