package com.epam.spring.hw5.repository;

import com.epam.spring.hw5.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByLogin(String login);
}
