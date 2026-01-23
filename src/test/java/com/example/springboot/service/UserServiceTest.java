package com.example.springboot.service;

import com.example.springboot.dto.UserDto;
import com.example.springboot.model.User;
import com.example.springboot.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    private final User user = new User("John Doe", 25);

    @Test
    public void findAll() {
        when(userRepository.save(user)).thenReturn(user);
        when(userRepository.findAll()).thenReturn(List.of(user));

        UserDto userDto = new UserDto(user);
        userService.save(userDto);

        List<UserDto> all = userService.findAll();

        assertEquals(1, all.size());
        assertNotNull(all.get(0));
        verify(userRepository).findAll();
        verify(userRepository).save(user);
    }

}
