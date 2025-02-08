package com.userservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;


@SpringBootTest
@AutoConfigureMockMvc
class UserServiceApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldCreateUser() throws Exception {

//        RegisterRequest request = new RegisterRequest("Viki", "Georgieva",
//                "test@mail.com", "vikito1", 15, Gender.FEMALE, Role.USER);
//
//        mockMvc.perform(post("/api/v1/users/register")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(request)))
//                .andExpect(status().isCreated())
//                .andExpect(jsonPath("$.email").value("test@mail.com"))
//                .andExpect(jsonPath("$.id").isNotEmpty());


    }

    @Test
    void contextLoads() {
    }

}
