package com.epam.spring.homework3.service.model;

import lombok.Builder;
import lombok.Data;

import java.util.Objects;

@Data
@Builder
public class User {
    private int id;
    private String firstName;
    private String lastName;
    private String login;
    private String email;
    private String city;
    private double money;
    private UserRole role;
    private UserStatus status;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Double.compare(user.money, money) == 0 && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(login, user.login) && Objects.equals(email, user.email) && Objects.equals(city, user.city) && role == user.role && status == user.status;
    }
}
