package com.kaluzny.oauth2.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/")
public class UserRestController {

    @GetMapping("user")
    @ResponseStatus(HttpStatus.OK)
    public Principal user(Principal user) {
        return user;
    }
}
