package com.example.SpringBoot_Security.service;

import com.example.SpringBoot_Security.model.Role;
import com.example.SpringBoot_Security.repository.RoleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.util.*;

@Service
@Transactional(readOnly = true)
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    @Transactional
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

    @Override
    public Set<Role> getRoles(long[] roleId) {
        Set<Role> roleResult = new HashSet<>();

        if (roleId == null) {
            roleResult.add(roleRepository.findById(2L).orElse(null));
        } else {
            for (long id : roleId) {
                List<Role> roles = getAllRoles();
                roleResult.add(roles.stream().filter(role -> role.getId() == id).findAny().orElse(null));
            }
        }

        return roleResult;
    }
}
