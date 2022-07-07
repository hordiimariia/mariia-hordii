package com.epam.spring.homework3.controller.dto;

import com.epam.spring.homework3.service.model.UserRole;
import com.epam.spring.homework3.service.model.UserStatus;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTO {
    private int id;
    private String firstName;
    private String lastName;
    private String login;
    private String email;
    private String city;
    private double money;
    private UserRole role;
    private UserStatus status;
}
