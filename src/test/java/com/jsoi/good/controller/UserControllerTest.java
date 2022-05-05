package com.jsoi.good.controller;

import com.jsoi.good.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class UserControllerTest {
    @Autowired
    private MockMvc mvc;
    @MockBean
    UserServiceImpl userServiceImpl;

    @Test
    void checkTest() throws Exception {
        String join = "join";
        mvc.perform(get("/test"))
                .andExpect(status().isOk());
    }
}