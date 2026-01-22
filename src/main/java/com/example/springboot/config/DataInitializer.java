package com.example.springboot.config;

import com.example.springboot.dto.UserDto;
import com.example.springboot.model.Role;
import com.example.springboot.model.User;
import com.example.springboot.repository.RoleRepository;
import com.example.springboot.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.Set;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public DataInitializer(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        Role role1 = new Role("ADMIN");
        Role role2 = new Role("USER");
        Role role3 = new Role("MODERATOR");

        roleRepository.save(role1);
        roleRepository.save(role2);
        roleRepository.save(role3);

        User user1 = new User("John Doe", 25, Set.of(role1, role2));
        User user2 = new User("Jane Smith", 30, Set.of(role2));
        User user3 = new User("Alice Brown", 28, Set.of(role3));

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);

        System.out.println("Data has been initialized successfully!");

        userRepository.findAll().forEach(user -> {
            UserDto userDTO = new UserDto(user);
            System.out.println(userDTO);
        });
    }
}
