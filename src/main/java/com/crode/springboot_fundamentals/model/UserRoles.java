package com.crode.springboot_fundamentals.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "user_roles")
@NoArgsConstructor
public class UserRoles {

    @EmbeddedId
    private UserRoleId id;
}
