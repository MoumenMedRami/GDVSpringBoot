package com.example.GDV.service;

import com.example.GDV.dto.DemandeDto;

import java.util.List;

public interface IdemandeService {

    DemandeDto save(DemandeDto dto);

    DemandeDto findById(Long id);

    DemandeDto findByCodeDemande(String codeDemmande);

    List<DemandeDto> findAllDemandeByUtilisateurId(Long id);

    List<DemandeDto> findAllDemandeByUtilisateurNom(String nom);

    List<DemandeDto> findAll();

    void delete(Long id);
}
