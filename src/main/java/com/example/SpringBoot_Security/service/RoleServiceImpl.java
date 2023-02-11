package com.example.SpringBoot_Security.service;


import com.example.SpringBoot_Security.Init;
import com.example.SpringBoot_Security.model.Role;
import com.example.SpringBoot_Security.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
//    public Set<Role> setAdminRole() {
//        HashSet<Role> roleAdmin = new HashSet<>();
//        roleAdmin.add(new Role("ROLE_ADMIN"));
//        return roleAdmin;
//    }
//
//    @Override
//    public Set<Role> setUserRole() {
//        HashSet<Role> roleUser = new HashSet<>();
//        roleUser.add(new Role("ROLE_USER"));
//        return roleUser;    }
}
