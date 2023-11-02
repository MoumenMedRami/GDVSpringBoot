package com.example.GDV.repository;

import com.example.GDV.model.Chauffeur;
import com.example.GDV.model.Demande;
import com.example.GDV.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DemandeRepository extends JpaRepository<Demande, Long> {


    Optional<Demande> findDemandeByNomDemande(String nomDemande);

    List<Demande> findAllByUtilisateurId(Long id);

    List<Demande>  findAllByUtilisateurNom(String nom);
}
