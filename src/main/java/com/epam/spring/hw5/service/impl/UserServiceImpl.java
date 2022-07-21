package com.epam.spring.hw5.service.impl;

import com.epam.spring.hw5.dto.UserDTO;
import com.epam.spring.hw5.model.User;
import com.epam.spring.hw5.repository.UserRepository;
import com.epam.spring.hw5.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<UserDTO> listUsers() {
        log.info("Getting list of users...");
        return userRepository.findAll()
                .stream()
                .map(this::mapUserToUserDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO getUser(String login) {
        log.info("Finding User by login {}...", login);
        User user = userRepository.findByLogin(login);
        log.info("User with login {} is found!", login);
        return mapUserToUserDTO(user);
    }

    @Override
    @Transactional
    public UserDTO createUser(UserDTO userDTO) {
        log.info("Creating User with login {}...", userDTO.getLogin());
        User user = mapUserDTOtoUser(userDTO);
        user = userRepository.save(user);
        log.info("User with login {} successfully created!", userDTO.getLogin());
        return mapUserToUserDTO(user);
    }

    @Override
    @Transactional
    public UserDTO updateUser(String oldLogin, UserDTO userDTO) {
        log.info("updateUser with login {} to new login {}", oldLogin, userDTO.getLogin());
        User user = userRepository.findByLogin(oldLogin);
        user.setLogin(userDTO.getLogin());
        userRepository.save(user);
        log.info("User with login {} successfully updated!", userDTO.getLogin());
        return mapUserToUserDTO(user);
    }

    @Override
    @Transactional
    public void deleteUser(String login) {
        log.info("deleteUser with login {}", login);
        User user = userRepository.findByLogin(login);
        userRepository.delete(user);
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
                .id(0L)
                .firstName(userDTO.getFirstName())
                .lastName(userDTO.getLastName())
                .login(userDTO.getLogin())
                .password(userDTO.getPassword())
                .build();
    }
}
