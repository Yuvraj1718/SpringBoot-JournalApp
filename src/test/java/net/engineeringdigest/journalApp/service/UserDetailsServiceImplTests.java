package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.ArrayList;

public class UserDetailsServiceImplTests {

    @InjectMocks // Use this instead of autowired in tests
    private UserDetailsService userDetailsService;

    // @MockBean is used with autowired
    // @Mock is used with InjectMocks

    // UserDetailsService is class ki repo na chle jo niche di h voh repo chle...
    @Mock // Actual repo nhi chle gi mock ho jaayegi repo...
    private UserRepository userRepository;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void loadUserByUsernameTest(){
        when(userRepository.findByUserName(ArgumentMatchers.anyString()))
                .thenReturn(User
                        .builder()
                        .userName("ram")
                        .password("abc")
                        .roles(new ArrayList<>())
                        .build());
        UserDetails user = userDetailsService.loadUserByUsername("ram");
        Assertions.assertNotNull(user);
    }
}