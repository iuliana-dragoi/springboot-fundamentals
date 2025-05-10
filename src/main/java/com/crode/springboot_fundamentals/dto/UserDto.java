package com.crode.springboot_fundamentals.dto;

import com.crode.springboot_fundamentals.model.Role;
import com.crode.springboot_fundamentals.model.User;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    @NotBlank
    String name;

    @Min(18)
    int age;

    Set<String> roles;

    public UserDto(User user) {
        this.name = user.getName();
        this.age = user.getAge();
        this.roles = user.getRoles().stream().map(Role::getName).collect(Collectors.toSet());
    }
}
