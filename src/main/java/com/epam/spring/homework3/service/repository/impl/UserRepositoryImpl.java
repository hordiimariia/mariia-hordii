package com.epam.spring.homework3.service.repository.impl;

import com.epam.spring.homework3.service.model.User;
import com.epam.spring.homework3.service.model.UserStatus;
import com.epam.spring.homework3.service.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserRepositoryImpl implements UserRepository {

    private final List<User> list = new ArrayList<>();

    @Override
    public User getUser(String login) {
        return list.stream()
                .filter(user -> user.getLogin().equals(login))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("User is not found!"));
    }

    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>(list);
    }

    @Override
    public User createUser(User user) {
        list.add(user);
        return user;
    }

    @Override
    public User updateUserLogin(String oldLogin, User user) {
        boolean isDeleted = list.removeIf(u -> u.getLogin().equals(oldLogin));
        if (isDeleted) {
            list.add(user);
        } else {
            throw new RuntimeException("User is not found!");
        }
        return user;
    }

    @Override
    public User updateUserStatus(User user, UserStatus status) {
        boolean isDeleted = list.removeIf(u -> u.getLogin().equals(user.getLogin()));
        if (isDeleted) {
            list.add(user);
        } else {
            throw new RuntimeException("User is not found!");
        }
        return user;
    }

    @Override
    public void deleteUser(String login) {
        list.removeIf(user -> user.getLogin().equals(login));
    }
}
