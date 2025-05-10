package com.crode.springboot_fundamentals.service;

import com.crode.springboot_fundamentals.dto.RoleDto;
import com.crode.springboot_fundamentals.model.Role;
import com.crode.springboot_fundamentals.repository.RoleRepository;
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
