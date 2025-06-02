package com.tsjosh.demo;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(controllers = HelloWorldController.class)
public class HelloWorldControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private GreetingService greetingService;

    @Test
    void shouldReturnGreetingSuccessfully() throws Exception{
        given(greetingService.sayHello("Tina")).willReturn("Hello Tina");

        mockMvc.perform(get("/api/hello?name={name}","Tina"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.greeting",is("Hello Tina")));
    }


}
