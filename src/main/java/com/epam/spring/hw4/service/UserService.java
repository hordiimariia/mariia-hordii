package com.epam.spring.hw4.service;

import com.epam.spring.hw4.dto.UserDTO;

import java.util.List;

public interface UserService {

    List<UserDTO> listUsers();

    UserDTO getUser(String login);

    UserDTO createUser(UserDTO userDTO);

    UserDTO updateUser(String oldLogin, UserDTO userDTO);

    void deleteUser(String login);
}
