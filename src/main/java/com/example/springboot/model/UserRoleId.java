package com.example.springboot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Data
@Embeddable
@NoArgsConstructor
public class UserRoleId implements Serializable {

    @Column(name = "user_id")
    private Long user_id;

    @Column(name = "role_id")
    private Long role_id;
}
