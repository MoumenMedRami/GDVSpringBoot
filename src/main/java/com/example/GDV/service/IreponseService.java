package com.example.GDV.service;

import com.example.GDV.dto.DemandeDto;
import com.example.GDV.dto.ReponseDto;

import java.util.List;

public interface IreponseService {

    ReponseDto save(ReponseDto dto);

    ReponseDto findById(Long id);

    ReponseDto findByCodeReponse(String codeReponse);

    List<ReponseDto> findAllReponseByChauffeurId(Long id);

    List<ReponseDto> findAllReponseByChauffeurNom(String nom);

    List<ReponseDto> findAllReponseByDemandeId(Long id);

    List<ReponseDto> findAllReponseByDemandeCodeDemande(String codeDemande);


    List<ReponseDto> findAllReponseByStatusReponseCodeStatus(String CodeStatus);

    List<ReponseDto> findAll();

    void delete(Long id);

    List<ReponseDto> findAllReponseByStatusReponseId(Long id);

    ReponseDto updateDemande(Long idReponse, Long idDemande);

    ReponseDto updateChaffeur(Long idReponse, Long idChauffeur);

    ReponseDto updateStatusReponse(Long idReponse, Long idStatusReponse);
}
