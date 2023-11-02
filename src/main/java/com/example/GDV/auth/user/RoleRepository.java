package com.example.GDV.auth.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Integer> {
    public Role findRoleByRoleName(String roleName);
}
