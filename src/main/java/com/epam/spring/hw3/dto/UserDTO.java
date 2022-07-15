package com.epam.spring.hw3.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTO {
    private String firstName;
    private String lastName;
    private String login;
    private String password;
    private String repeatPassword;
}
