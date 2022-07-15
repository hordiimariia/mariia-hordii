package com.epam.spring.hw3.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    private String firstName;
    private String lastName;
    private String login;
    private String password;
}
