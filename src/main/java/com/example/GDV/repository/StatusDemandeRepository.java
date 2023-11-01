package com.example.GDV.repository;

import com.example.GDV.model.Roles;
import com.example.GDV.model.StatusDemande;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StatusDemandeRepository extends JpaRepository<StatusDemande, Long> {


    Optional<StatusDemande> findStatusDemandeByStatusName(String nom);

}