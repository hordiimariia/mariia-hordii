package com.epam.spring.homework3.service;

import com.epam.spring.homework3.controller.dto.UserDTO;
import com.epam.spring.homework3.service.model.UserStatus;

import java.util.List;

public interface UserService {
    UserDTO getUser(String login);
    List<UserDTO> getAllUsers();

    UserDTO createUser(UserDTO userDTO);

    UserDTO updateUserLogin(String oldLogin, UserDTO userDTO);

    UserDTO updateUserStatus(UserDTO userDTO, UserStatus status);

    void deleteUser(String login);
}
