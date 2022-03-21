package de.volkswagen.controllers;

import de.volkswagen.security.services.UserDetailsServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@AutoConfigureMockMvc
@SpringBootTest
class TestControllerTest {

    @MockBean
    private UserDetailsServiceImpl userDetails;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldMVC(){
        assertNotNull(mockMvc);
    }
}