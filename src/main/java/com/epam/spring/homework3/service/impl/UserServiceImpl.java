package com.epam.spring.homework3.service.impl;

import com.epam.spring.homework3.controller.dto.UserDTO;
import com.epam.spring.homework3.service.UserService;
import com.epam.spring.homework3.service.model.User;
import com.epam.spring.homework3.service.model.UserStatus;
import com.epam.spring.homework3.service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public UserDTO getUser(String login) {
        User user = userRepository.getUser(login);
        return mapUserToUserDTO(user);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.getAllUsers()
                .stream()
                .map(this::mapUserToUserDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = mapUserDTOToUser(userDTO);
        user = userRepository.createUser(user);
        return mapUserToUserDTO(user);
    }

    @Override
    public UserDTO updateUserLogin(String oldLogin, UserDTO userDTO) {
        User user = mapUserDTOToUser(userDTO);
        user = userRepository.updateUserLogin(oldLogin, user);
        return mapUserToUserDTO(user);
    }

    @Override
    public UserDTO updateUserStatus(UserDTO userDTO, UserStatus status) {
        User user = mapUserDTOToUser(userDTO);
        user = userRepository.updateUserStatus(user, status);
        return mapUserToUserDTO(user);
    }

    @Override
    public void deleteUser(String login) {
        userRepository.deleteUser(login);
    }

    private UserDTO mapUserToUserDTO(User user) {
        return UserDTO.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .build();
    }

    private User mapUserDTOToUser(UserDTO userDTO) {
        return User.builder()
                .firstName(userDTO.getFirstName())
                .lastName(userDTO.getLastName())
                .email(userDTO.getEmail())
                .build();
    }
}
