package com.example.GDV.repository;

import com.example.GDV.model.Chauffeur;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ChauffeurRepository extends JpaRepository<Chauffeur, Long> {


    Optional<Chauffeur> findChauffeurByNom(String nom);

}

