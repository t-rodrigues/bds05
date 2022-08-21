package com.devsuperior.movieflix.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.movieflix.domain.dtos.UserDto;
import com.devsuperior.movieflix.infra.security.AuthService;

@RestController
@RequestMapping("/users")
public class UserController {

    private final AuthService authService;

    public UserController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("/profile")
    public UserDto profile() {
        var user = authService.getAuthenticated();
        return new UserDto(user);
    }

}
