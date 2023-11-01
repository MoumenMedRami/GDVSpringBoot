package com.example.GDV.repository;

import com.example.GDV.model.Chauffeur;
import com.example.GDV.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RolesRepository extends JpaRepository<Roles, Long> {


    Optional<Roles> findRolesByRoleName(String roleName);

}
