package de.volkswagen.controllers;

import de.volkswagen.repository.UserRepository;
import de.volkswagen.security.services.UserDetailsServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.http.MediaType;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.client.RequestMatcher;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.sql.DataSource;

import static org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType.H2;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class AuthControllerTest  {

    //@MockBean
    private UserDetailsServiceImpl userDetails;

    @Autowired
    private MockMvc mockMvc;

//    @MockBean
//    private UserRepository userRepository;

    @Test
    void canSingIn() throws Exception {
        mockMvc.perform(post("/api/auth/signup").contentType(MediaType.APPLICATION_JSON)
                        .content("{\"username\":\"useruser\",\"password\":\"password\",\"email\":\"test@test.de\"}"))
                .andExpect(status().isOk());
        mockMvc.perform(post("/api/auth/signin").contentType(MediaType.APPLICATION_JSON)
                        .content("{\"username\":\"useruser\",\"password\":\"password\"}"))
                .andExpect(status().isOk());
    }

    @Test
    void canSignUp() throws Exception {
        mockMvc.perform(post("/api/auth/signup").contentType(MediaType.APPLICATION_JSON)
                        .content("{\"username\":\"useruser\",\"password\":\"password\",\"email\":\"test@test.de\"}"))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username="admin",roles={"USER","ADMIN"})
    void adminCanAccessAdminContent() throws Exception {
        mockMvc.perform(get("/api/test/admin")).andExpect(status().isOk());
    }

    @Test
    @WithMockUser
    void userCanNotAccessAdminAndModContent() throws Exception {
        mockMvc.perform(get("/api/test/admin")).andExpect(status().isForbidden());
        mockMvc.perform(get("/api/test/mod")).andExpect(status().isForbidden());
    }

    @Test
    void canRegisterAnAdmin() throws Exception {

        mockMvc.perform(post("/api/auth/signup").contentType(MediaType.APPLICATION_JSON)
                        .content("{\"username\":\"useruser\",\"password\":\"password\",\"email\":\"test@test.de\",\"role\":[\"ROLE_ADMIN\"]}"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(MockMvcResultMatchers.content().json("{\"message\":\"User registered successfully with Roles: [ROLE_ADMIN]\"}"));
//TODO:

    }



    @Test
    void shouldCreateMock() {
        assertNotNull(mockMvc);
    }

}