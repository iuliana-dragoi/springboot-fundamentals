package com.example.springboot.service;

import com.example.springboot.dto.RoleDto;
import com.example.springboot.model.Role;
import com.example.springboot.repository.RoleRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleService {

    private RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<RoleDto> findAll() {
        List<Role> roles = roleRepository.findAll();
        return roles.stream().map(
                role -> new RoleDto(role.getName())
        ).collect(Collectors.toList());
    }
}
