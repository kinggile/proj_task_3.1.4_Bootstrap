package com.example.SpringBoot_Security.service;

import com.example.SpringBoot_Security.model.Role;

import java.util.List;
import java.util.Set;

public interface RoleService {
    void save(Role role);

    List<Role> getAllRoles();

//    Set<Role> getAllRolesSet();
}
