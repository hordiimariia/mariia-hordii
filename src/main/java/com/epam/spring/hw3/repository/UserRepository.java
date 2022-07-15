package com.epam.spring.hw3.repository;

import com.epam.spring.hw3.model.User;
import java.util.List;

public interface UserRepository {

    List<User> listUsers();

    User getUser(String login);

    User createUser(User user);

    User updateUser(String oldLogin, User user);

    void deleteUser(String login);
}
