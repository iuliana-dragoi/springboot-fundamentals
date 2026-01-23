package com.example.springboot.service;

import com.example.springboot.dto.UserDto;
import com.example.springboot.model.User;
import com.example.springboot.repository.UserRepository;
import lombok.Getter;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserDto> findAll() {
        List<User> users = userRepository.findAll();
        return users.stream().map(
                user -> new UserDto(
                        user.getName(),
                        user.getAge(),
                        user.getRoles()
                )
        ).collect(Collectors.toList());
    }

    @Override
    public User save(UserDto userDto) {
        User user = new User(userDto.getName(), userDto.getAge(), userDto.getRoles());
        return userRepository.save(user);
    }
}
