package com.example.btlltw.repository;

import com.example.btlltw.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role getRoleById(int id);
}
