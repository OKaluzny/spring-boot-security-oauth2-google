package com.kaluzny.oauth2.web;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/")
public class UserRestController {

    @GetMapping("user")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal) {
        if (principal == null) {
            return Map.of();
        }
        return Map.of(
                "name", Objects.requireNonNullElse(principal.getAttribute("name"), ""),
                "email", Objects.requireNonNullElse(principal.getAttribute("email"), ""),
                "picture", Objects.requireNonNullElse(principal.getAttribute("picture"), "")
        );
    }
}
