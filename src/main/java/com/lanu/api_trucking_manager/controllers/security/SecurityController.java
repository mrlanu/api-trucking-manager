package com.lanu.api_trucking_manager.controllers.security;

import com.lanu.api_trucking_manager.entities.security.User;
import com.lanu.api_trucking_manager.exceptions.UserAlreadyExistsException;
import com.lanu.api_trucking_manager.services.security.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/signup")
public class SecurityController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User registerUser(@Valid @RequestBody User user) {
        if (userService.existByUsername(user.getUsername())){
            throw new UserAlreadyExistsException("User " + user.getUsername() + " already exists");
        }
        return userService.save(user);
    }
}
