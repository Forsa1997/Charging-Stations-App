package de.volkswagen.controllers;

import de.volkswagen.security.services.UserDetailsServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class AuthControllerTest {

    @MockBean
    private UserDetailsServiceImpl userDetails;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void canAuthenticate() throws Exception {
        mockMvc.perform(post("/api/auth/signup").contentType(MediaType.APPLICATION_JSON)
                        .content("{\"username\":\"useruser\",\"password\":\"password\",\"email\":\"test@test.de\"}"))
                .andExpect(status().isOk());
        mockMvc.perform(post("/api/auth/signin").contentType(MediaType.APPLICATION_JSON)
                        .content("{\"username\":\"useruser\",\"password\":\"password\"}"))
                .andExpect(status().isOk());
    }

    @Test
    void canSignup() throws Exception {
        mockMvc.perform(post("/api/auth/signup").contentType(MediaType.APPLICATION_JSON)
                        .content("{\"username\":\"useruser\",\"password\":\"password\",\"email\":\"test@test.de\"}"))
                .andExpect(status().isOk());
    }

    @Test
    void shouldCreateMock() {
        assertNotNull(mockMvc);
    }

}