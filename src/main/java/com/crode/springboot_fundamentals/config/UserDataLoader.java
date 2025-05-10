package com.crode.springboot_fundamentals.config;

import com.crode.springboot_fundamentals.model.User;
import com.crode.springboot_fundamentals.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserDataLoader {

    @Bean
    public CommandLineRunner initUsers(UserRepository userRepository) {
        return args -> {
            userRepository.save(new User("John", 20));
            userRepository.save(new User("Alice", 38));
            userRepository.save(new User("Marry", 25));
            userRepository.save(new User("Michael", 18));
            userRepository.findAll().forEach(System.out::println);
        };
    }
}
