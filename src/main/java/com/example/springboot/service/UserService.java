package com.example.springboot.service;

import com.example.springboot.dto.UserDto;
import com.example.springboot.model.User;

import java.util.List;

public interface UserService {

    List<UserDto> findAll();
    User save(UserDto userDto);
}
