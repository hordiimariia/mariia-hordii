package com.epam.spring.hw6.test.util;

import com.epam.spring.hw6.dto.OrderDTO;
import com.epam.spring.hw6.dto.UserDTO;
import com.epam.spring.hw6.model.Order;
import com.epam.spring.hw6.model.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TestDataUtil {
    public static final String FIRST_NAME = "FirstName";
    public static final String LAST_NAME = "LastName";
    public static final String LOGIN = "test_firstlastname";
    public static final String PASSWORD = "test_password";

    public static final Long ID = 0L;
    public static final String CITY_FROM = "Lviv";
    public static final String CITY_TO = "Kyiv";
    public static final String PARCEL_TYPE = "Package";

    public static User createUser(){
        return User.builder()
                .id(ID)
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .login(LOGIN)
                .password(PASSWORD)
                .build();
    }

    public static UserDTO createUserDTO(){
        return UserDTO.builder()
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .login(LOGIN)
                .password(null)
                .repeatPassword(null)
                .build();
    }

    public static Order createOrder(){
        return Order.builder()
                .id(ID)
                .cityFrom(CITY_FROM)
                .cityTo(CITY_TO)
                .parcelType(PARCEL_TYPE)
                .user(createUser())
                .build();
    }

    public static OrderDTO createOrderDTO(){
        return OrderDTO.builder()
                .cityFrom(CITY_FROM)
                .cityTo(CITY_TO)
                .parcelType(PARCEL_TYPE)
                .userDTO(createUserDTO())
                .build();
    }

}
