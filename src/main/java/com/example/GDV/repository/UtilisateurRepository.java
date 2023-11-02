package com.example.GDV.repository;

import com.example.GDV.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {


    Optional<Utilisateur> findUtilisateurByNom(String nom);

    Optional<Utilisateur> findUtilisateurByEmail(String email);
}

