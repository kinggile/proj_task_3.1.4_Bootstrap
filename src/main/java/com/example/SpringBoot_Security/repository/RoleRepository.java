package com.example.SpringBoot_Security.repository;

import com.example.SpringBoot_Security.model.Role;
import com.example.SpringBoot_Security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
