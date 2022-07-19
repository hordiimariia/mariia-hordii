package com.epam.spring.hw4.service.impl;

import com.epam.spring.hw4.dto.UserDTO;
import com.epam.spring.hw4.model.User;
import com.epam.spring.hw4.repository.UserRepository;
import com.epam.spring.hw4.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<UserDTO> listUsers() {
        log.info("get list of users");
        return userRepository.listUsers()
                .stream()
                .map(this::mapUserToUserDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO getUser(String login) {
        log.info("getUser by login {}", login);
        User user = userRepository.getUser(login);
        return mapUserToUserDTO(user);
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        log.info("createUser with login {}", userDTO.getLogin());
        User user = mapUserDTOtoUser(userDTO);
        user = userRepository.createUser(user);
        return mapUserToUserDTO(user);
    }

    @Override
    public UserDTO updateUser(String oldLogin, UserDTO userDTO) {
        log.info("updateUser with login {} to new login {}", oldLogin, userDTO.getLogin());
        User user = mapUserDTOtoUser(userDTO);
        user = userRepository.updateUser(oldLogin, user);
        return mapUserToUserDTO(user);
    }

    @Override
    public void deleteUser(String login) {
        log.info("deleteUser with login {}", login);
        userRepository.deleteUser(login);
    }

    private UserDTO mapUserToUserDTO(User user) {
        return UserDTO.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .login(user.getLogin())
                .build();
    }

    private User mapUserDTOtoUser(UserDTO userDTO) {
        return User.builder()
                .firstName(userDTO.getFirstName())
                .lastName(userDTO.getLastName())
                .login(userDTO.getLogin())
                .password(userDTO.getPassword())
                .build();
    }
}
