package com.epam.spring.homework3.service.repository;

import com.epam.spring.homework3.service.model.User;
import com.epam.spring.homework3.service.model.UserStatus;

import java.util.List;

public interface UserRepository {
    User getUser(String login);
    List<User> getAllUsers();

    User createUser(User user);

    User updateUserLogin(String oldLogin, User user);
    User updateUserStatus(User user, UserStatus status);

    void deleteUser(String login);
}
