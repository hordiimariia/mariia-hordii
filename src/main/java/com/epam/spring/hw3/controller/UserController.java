package com.epam.spring.hw3.controller;

import com.epam.spring.hw3.dto.UserDTO;
import com.epam.spring.hw3.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/users")
    public List<UserDTO> listUsers(){
        return userService.listUsers();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/user/{login}")
    public UserDTO getUser(@PathVariable String login){
        return userService.getUser(login);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/user")
    public UserDTO createUser (@RequestBody UserDTO userDTO){
        return userService.createUser(userDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/user/{oldLogin}")
    public UserDTO updateUser(@PathVariable String oldLogin, @RequestBody UserDTO userDTO){
        return userService.updateUser(oldLogin, userDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = "/user/{login}")
    public ResponseEntity<Void> deleteUser(@PathVariable String login){
        userService.deleteUser(login);
        return ResponseEntity.noContent().build();
    }

}
