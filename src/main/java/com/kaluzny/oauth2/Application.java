package com.kaluzny.oauth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableResourceServer// Without this, basic authentication is invoked
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
