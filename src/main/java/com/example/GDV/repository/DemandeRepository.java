package com.example.GDV.repository;

import com.example.GDV.model.Chauffeur;
import com.example.GDV.model.Demande;
import com.example.GDV.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DemandeRepository extends JpaRepository<Demande, Long> {


    Optional<Demande> findDemandeByNom(String nom);

}
