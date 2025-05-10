package com.crode.springboot_fundamentals.service;

import com.crode.springboot_fundamentals.dto.UserDto;
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
        return userRepository.findAll().stream().map(UserService::mapToUserDto).collect(Collectors.toList());
    }

    private static UserDto mapToUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setName(user.getName());
        userDto.setAge(user.getAge());
        return userDto;
    }
}
