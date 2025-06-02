package com.tsjosh.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.BDDMockito.given;
import static org.assertj.core.api.Assertions.assertThat;



@ExtendWith(MockitoExtension.class)
public class GreetingServiceTest {

    @Mock
    private ApplicationProperties properties;

    @InjectMocks
    private GreetingService greetingService;

    @BeforeEach
    void setUp(){
        given(properties.getGreeting()).willReturn("Hello");

    }

    @Test
    void shouldGreetWithDefaultNameWhenNameIsNoProvided(){
        given(properties.getDefaultName()).willReturn("World");

        String greeting = greetingService.sayHello(null);

        Assertions.assertEquals("Hello World", greeting);
        assertThat(greeting).isEqualTo("hello world");
    }

    @Test
    void shouldGreetWithGivenName(){

        String greeting =greetingService.sayHello("John");

        assertThat(greeting).isEqualTo("Hello John");
    }
}
