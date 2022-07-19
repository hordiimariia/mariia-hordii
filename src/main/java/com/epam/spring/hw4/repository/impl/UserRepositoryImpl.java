package com.epam.spring.hw4.repository.impl;

import com.epam.spring.hw4.exception.EntityNotFoundException;
import com.epam.spring.hw4.model.User;
import com.epam.spring.hw4.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class UserRepositoryImpl implements UserRepository {

    private final List<User> list = new ArrayList<>();

    @Override
    public List<User> listUsers() {
        log.info("listUsers");
        return new ArrayList<>(list);
    }

    @Override
    public User getUser(String login) {
        log.info("getUser {}", login);
        return list.stream()
                .filter(user -> user.getLogin().equals(login))
                .findFirst()
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public User createUser(User user) {
        log.info("createUser {}", user);
        list.add(user);
        return user;
    }

    @Override
    public User updateUser(String oldLogin, User user) {
        log.info("updateUser oldLogin {} to {}", oldLogin, user.getLogin());
        boolean isDeleted = list.removeIf(u -> u.getLogin().equals(oldLogin));
        if(isDeleted){
            list.add(user);
        }
        else {
            throw new EntityNotFoundException();
        }
        return user;
    }

    @Override
    public void deleteUser(String login) {
        log.info("deleteUser {}", login);
        list.removeIf(u -> u.getLogin().equals(login));
    }
}
