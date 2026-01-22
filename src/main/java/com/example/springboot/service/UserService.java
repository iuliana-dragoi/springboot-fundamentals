package com.example.springboot.service;

import com.example.springboot.dto.UserDto;
import com.example.springboot.model.Role;
import com.example.springboot.model.User;
import com.example.springboot.repository.UserRepository;
import lombok.Getter;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDto> findAll() {
        List<User> users = userRepository.findAll();
        return users.stream().map(
                user -> new UserDto(
                        user.getName(),
                        user.getAge(),
                        user.getRoles().stream().map(Role::getName).collect(Collectors.toSet())
                )
        ).collect(Collectors.toList());
    }
}
