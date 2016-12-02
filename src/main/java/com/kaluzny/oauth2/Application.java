package com.kaluzny.oauth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;

@SpringBootApplication
@EnableOAuth2Sso // Without this, basic authentication is invoked
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
