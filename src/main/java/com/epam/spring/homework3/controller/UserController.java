package com.epam.spring.homework3.controller;

import com.epam.spring.homework3.controller.dto.UserDTO;
import com.epam.spring.homework3.service.UserService;
import com.epam.spring.homework3.service.model.UserStatus;
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
    @GetMapping(value = "/user/{login}")
    public UserDTO getUser(@PathVariable String login) {
        return userService.getUser(login);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/user")
    public List<UserDTO> getAll(){
        return userService.getAllUsers();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/user")
    public UserDTO createUser(@RequestBody UserDTO userDTO) {
        return userService.createUser(userDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/user/{oldLogin}")
    public UserDTO updateUserLogin(@PathVariable String oldLogin, @RequestBody UserDTO user) {
        return userService.updateUserLogin(oldLogin, user);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/user/{status}")
    public UserDTO updateUserStatus(@RequestBody UserDTO userDTO, @RequestBody UserStatus status) {
        return userService.updateUserStatus(userDTO, status);
    }

    @DeleteMapping(value = "/user/{login}")
    public ResponseEntity<Void> deleteUser(@PathVariable String login){
        userService.deleteUser(login);
        return ResponseEntity.noContent().build();
    }
}
