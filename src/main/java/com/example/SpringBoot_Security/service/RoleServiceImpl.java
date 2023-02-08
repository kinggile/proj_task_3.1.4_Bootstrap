package com.example.SpringBoot_Security.service;


import com.example.SpringBoot_Security.model.Role;
import com.example.SpringBoot_Security.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
