package com.example.SpringBoot_Security;

import com.example.SpringBoot_Security.model.Role;
import com.example.SpringBoot_Security.model.User;
import com.example.SpringBoot_Security.repository.RoleRepository;
import com.example.SpringBoot_Security.repository.UserRepository;
import com.example.SpringBoot_Security.service.RoleService;
import com.example.SpringBoot_Security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Component
public class Init {

    private final UserService userService;
    private final RoleService roleService;

    private final Role roleAdmin = new Role("ROLE_ADMIN");
    private final Role roleUser = new Role("ROLE_USER");

    @Autowired
    public Init(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @Transactional
    @Bean
    public void addUser() {
        roleService.save(roleAdmin);
        roleService.save(roleUser);


        User admin = new User("admin", "$2a$12$x2jGJqzzWh7mp1c4bNW/MePnpkb5Q.garsy0PN9cmK3Ja0UQ3N432",
                "admin@mail.ru", setAdminRole()); // pass = admin
        User user = new User("user", "$2a$12$AyaqSH0/6oYd6yBC2sKfgutia.m2Cz//roNJ0scMTDYmBEba8.87q",
                "user@mail.ru", setRoleUser()); // pass = user

        userService.save(admin);
        userService.save(user);

    }

    public Set<Role> setAdminRole() {
        Set<Role> adminSet = new HashSet<>();
        adminSet.add(roleAdmin);

        return adminSet;
    }

    public Set<Role> setRoleUser() {
        Set<Role> userSet = new HashSet<>();
        userSet.add(roleUser);

        return userSet;
    }
}
