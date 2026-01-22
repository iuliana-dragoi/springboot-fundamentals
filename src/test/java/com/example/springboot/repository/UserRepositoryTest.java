package com.example.springboot.repository;

import com.example.springboot.model.Role;
import com.example.springboot.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.List;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    private final User user = new User("John Doe", 25);

    @Test
    public void save() {
        User savedUser = userRepository.save(user);
        assertEquals(user, savedUser);
    }

    @Test
    public void findById() {
        userRepository.save(user);
        Object foundUser = userRepository.findById(user.getId()).orElseGet(null);
        assertEquals(user, foundUser);
    }

    @Test
    public void findUsersByRoleName() {
        Role roleAdmin = roleRepository.save(new Role("admin"));
        user.setRoles(Set.of(roleAdmin));
        userRepository.save(user);
        List<User> foundUser = userRepository.findUsersByRoleName(roleAdmin.getName());
        assertEquals(1, foundUser.size());
    }

    @Test
    public void findByAgeGreaterThan() {
        userRepository.save(user);
        User user2 = new User("Alice Wonder", 30);
        userRepository.save(user2);
        List<User> foundUser = userRepository.findByAgeGreaterThan(25);
        assertEquals(1, foundUser.size());
        assertEquals(30, foundUser.get(0).getAge());
    }

    @Test
    public void findByAgeLessThan() {
        userRepository.save(user);
        User user2 = new User("Alice Wonder", 30);
        userRepository.save(user2);
        List<User> foundUser = userRepository.findByAgeLessThan(29);
        assertEquals(1, foundUser.size());
        assertEquals(25, foundUser.get(0).getAge());
    }
}
