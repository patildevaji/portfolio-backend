package com.jeebhar.jeebhar.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jeebhar.jeebhar.dto.ContactRequest;
import com.jeebhar.jeebhar.service.ContactService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@ExtendWith(MockitoExtension.class)
public class ContactControllerTest {

    private final MockMvc mockMvc;

    @Mock
    private ContactService contactService;

    @InjectMocks
    private ContactController contactController;

    private final ObjectMapper objectMapper = new ObjectMapper();

    public ContactControllerTest() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(contactController).build();
    }

    @Test
    void testSendEmailEndpoint() throws Exception {
        ContactRequest contactRequest = new ContactRequest();
        contactRequest.setName("John Doe");
        contactRequest.setEmail("johndoe@example.com");
        contactRequest.setPhone("+1234567890");
        contactRequest.setSubject("Collaboration Inquiry");
        contactRequest.setMessage("Hey, I would like to collaborate with you!");

        mockMvc.perform(post("/api/contact")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(contactRequest)))
                .andExpect(status().isOk())
                .andExpect(content().string("Message sent successfully!"));

        verify(contactService, times(1)).sendContactEmail(any(ContactRequest.class));
    }
}
