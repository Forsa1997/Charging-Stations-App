package de.volkswagen.controllers;

import de.volkswagen.security.services.UserDetailsImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ContextConfiguration(locations={"classpath:WEB-INF/application-context.xml"})
@AutoConfigureMockMvc
public class AuthControllerTest {

    @MockBean
    private UserDetailsImpl userDetails;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private MockMvc mockMvc;

  //  @BeforeEach
   // void setupMockMvc(){
    //    this.mockMvc = MockMvcBuilders.standaloneSetup(new AuthController()).build();
   // }


    @Test
    void shouldCreateMock() {
        assertNotNull(mockMvc);
    }











//    @Test
//    @DisplayName("addAuto_valid_returnsAuto")
//    void addAutoValidReturnsAuto() throws Exception {
//        User user = new User("Jürgen", "jürgen@gmx.de", "password");
//        when(userDetails.build(any(User.class))).thenReturn(userDetails.build(user));
//        mockMvc.perform(post("/signin").contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(user)))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("username").value("Jürgen"));
//    }
}
