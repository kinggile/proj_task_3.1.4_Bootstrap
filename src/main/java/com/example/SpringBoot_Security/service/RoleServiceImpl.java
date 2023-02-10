package com.example.SpringBoot_Security.service;


import com.example.SpringBoot_Security.model.Role;
import com.example.SpringBoot_Security.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {
    private RoleRepository roleRepository;

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

//    @Override
//    public Set<Role> getAllRolesSet() {
//        Set<Role> roles = new HashSet<>();
//        roles.add(getAllRoles().get(0));
//        return roles;
//    }
}
