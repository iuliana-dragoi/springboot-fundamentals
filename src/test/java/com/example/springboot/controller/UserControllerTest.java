package com.example.springboot.controller;

import com.example.springboot.dto.UserDto;
import com.example.springboot.model.User;
import com.example.springboot.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;


    private final User user = new User("John Doe", 25);

    @Test
    @WithMockUser
    public void create() throws Exception {
        UserDto userDto = new UserDto(user);
        when(userService.save(any(UserDto.class))).thenReturn(user);

        MvcResult mvcResult = mockMvc.perform(post("/users/create")
                .with(csrf())
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                            {
                              "name": "John Doe",
                              "age": 25
                            }
                        """))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("John Doe"))
                .andExpect(jsonPath("$.age").value(25))
                .andReturn();

        ObjectMapper objectMapper = new ObjectMapper();
        User result = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), User.class);
        assertEquals(user.getId(), result.getId());
        assertEquals(user.getName(), result.getName());
        assertEquals(user.getAge(), result.getAge());
        verify(userService).save(userDto);
    }

    @Test
    @WithMockUser
    public void findAll() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/users/findAll").with(csrf()))
            .andExpect(status().isOk())
        ;
    }
}
