package com.kaluzny.oauth2.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class UserRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ClientRegistrationRepository clientRegistrationRepository;

    @Test
    void userEndpoint_whenNotAuthenticated_shouldRedirectToLogin() throws Exception {
        mockMvc.perform(get("/user"))
                .andExpect(status().is3xxRedirection());
    }

    @Test
    void userEndpoint_whenAuthenticated_shouldReturnUserInfo() throws Exception {
        OAuth2User oauth2User = new DefaultOAuth2User(
                Collections.emptyList(),
                Map.of(
                        "sub", "123456789",
                        "name", "Test User",
                        "email", "test@example.com",
                        "picture", "https://example.com/photo.jpg"
                ),
                "sub"
        );

        mockMvc.perform(get("/user")
                        .with(SecurityMockMvcRequestPostProcessors.oauth2Login().oauth2User(oauth2User)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Test User"))
                .andExpect(jsonPath("$.email").value("test@example.com"))
                .andExpect(jsonPath("$.picture").value("https://example.com/photo.jpg"));
    }
}
