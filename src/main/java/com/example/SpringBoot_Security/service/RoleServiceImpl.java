package com.example.SpringBoot_Security.service;


import com.example.SpringBoot_Security.Init;
import com.example.SpringBoot_Security.model.Role;
import com.example.SpringBoot_Security.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void save(Role role) {
        roleRepository.save(role);
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role getOneRole(Long id) {
        Optional<Role> foundOneRole = roleRepository.findById(id);
        return foundOneRole.orElse(null);
    }
}
