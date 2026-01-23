package com.example.springboot.dto;

import com.example.springboot.model.Role;
import com.example.springboot.model.User;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    @NotBlank
    String name;

    @Min(18)
    int age;

    Set<Role> roles;

    public UserDto(User user) {
        this.name = user.getName();
        this.age = user.getAge();
        this.roles = user.getRoles();
    }
}
