package com.epam.spring.hw6.controller;

import com.epam.spring.hw6.dto.UserDTO;
import com.epam.spring.hw6.service.UserService;
import com.epam.spring.hw6.test.config.TestConfig;
import com.epam.spring.hw6.test.util.TestDataUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static com.epam.spring.hw6.test.util.TestDataUtil.LOGIN;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserController.class)
@AutoConfigureMockMvc
@Import(TestConfig.class)
public class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    UserService userService;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void listUsersTest() throws Exception {
        UserDTO userDTO = TestDataUtil.createUserDTO();

        when(userService.listUsers()).thenReturn(Collections.singletonList(userDTO));

        mockMvc
                .perform(get("/api/users"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].login").value(userDTO.getLogin()));
    }

    @Test
    void getUser() throws Exception {
        UserDTO userDTO = TestDataUtil.createUserDTO();

        when(userService.getUser(LOGIN)).thenReturn(userDTO);

        mockMvc
                .perform(get("/api/user/" + LOGIN))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.login").value(userDTO.getLogin()));
    }

    @Test
    void createUserTest() throws Exception {
        UserDTO userDTO = TestDataUtil.createUserDTO();
        userDTO.setPassword("password");
        userDTO.setRepeatPassword("password");

        when(userService.createUser(any())).thenReturn(userDTO);

        mockMvc
                .perform(post("/api/user")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(userDTO)))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.login").value(userDTO.getLogin()));

        verify(userService, times(1)).createUser(userDTO);
    }

    @Test
    void updateUserTest() throws Exception {
        UserDTO userDTO = TestDataUtil.createUserDTO();

        when(userService.updateUser(LOGIN, userDTO)).thenReturn(userDTO);

        mockMvc
                .perform(put("/api/user/" + LOGIN)
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(userDTO)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.login").value(userDTO.getLogin()));
    }

    @Test
    void deleteUserTest() throws Exception {
        doNothing().when(userService).deleteUser(LOGIN);

        mockMvc
                .perform(delete("/api/user/" + LOGIN))
                .andDo(print())
                .andExpect(status().isNoContent());
    }
}
