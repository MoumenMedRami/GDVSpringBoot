package com.example.GDV.service;

import com.example.GDV.dto.DemandeDto;
import com.example.GDV.dto.FilterDemande;
import com.example.GDV.dto.RestPage;
import com.example.GDV.model.Demande;

import java.util.List;

public interface IdemandeService {

    DemandeDto save(DemandeDto dto);

    DemandeDto findById(Long id);

    DemandeDto findByCodeDemande(String codeDemmande);

    List<DemandeDto> findAllDemandeByUtilisateurId(Long id);

    List<DemandeDto> findAllDemandeByUtilisateurNom(String nom);


    RestPage findAll(FilterDemande filter);

    void delete(Long id);


}
