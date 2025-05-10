package com.crode.springboot_fundamentals.service;

import com.crode.springboot_fundamentals.dto.UserDto;
import com.crode.springboot_fundamentals.model.Role;
import com.crode.springboot_fundamentals.model.User;
import com.crode.springboot_fundamentals.repository.UserRepository;
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
