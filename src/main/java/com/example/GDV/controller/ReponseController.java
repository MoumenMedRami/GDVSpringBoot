package com.example.GDV.controller;

import com.example.GDV.controller.api.ReponseApi;
import com.example.GDV.dto.ReponseDto;
import com.example.GDV.service.IreponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class ReponseController implements ReponseApi {


    private   IreponseService ireponseService;

    @Autowired
    public ReponseController(IreponseService ireponseService) {
        this.ireponseService = ireponseService;
    }

    @Override
    public ReponseDto save(ReponseDto dto) {
        return ireponseService.save(dto);
    }

    @Override
    public ReponseDto findById(Long id) {
        return ireponseService.findById(id);
    }

    @Override
    public ReponseDto findByCodeReponse(String codeReponse) {
        return ireponseService.findByCodeReponse(codeReponse);
    }

    @Override
    public List<ReponseDto> findAllReponseByChauffeurId(Long id) {
        return ireponseService.findAllReponseByChauffeurId(id);
    }

    @Override
    public List<ReponseDto> findAllReponseByChauffeurNom(String nom) {
        return ireponseService.findAllReponseByChauffeurNom(nom);
    }

    @Override
    public List<ReponseDto> findAllReponseByDemandeId(Long id) {
        return ireponseService.findAllReponseByDemandeId(id);
    }

    @Override
    public List<ReponseDto> findAllReponseByDemandeCodeDemande(String codeDemande) {
        return ireponseService.findAllReponseByDemandeCodeDemande(codeDemande);
    }

    @Override
    public List<ReponseDto> findAllReponseByStatusReponseId(Long id) {
        return ireponseService.findAllReponseByStatusReponseId(id);
    }

    @Override
    public List<ReponseDto> findAllReponseByStatusReponseCodeStatus(String nom) {
        return ireponseService.findAllReponseByStatusReponseCodeStatus(nom);
    }





    @Override
    public List<ReponseDto> findAll() {
        return ireponseService.findAll();
    }

    @Override
    public void delete(Long id) {

        ireponseService.delete(id);
    }

    @Override
    public ReponseDto updateDemande(Long idReponse, Long idDemande) {
        return ireponseService.updateDemande(idReponse, idDemande);

    }

    @Override
    public ReponseDto updateChaffeur(Long idReponse, Long idChauffeur) {
        return ireponseService.updateChaffeur(idReponse, idChauffeur);
    }

    @Override
    public ReponseDto updateStatusReponse(Long idReponse, Long idStatusReponse) {
        return ireponseService.updateStatusReponse(idReponse, idStatusReponse);
    }
}
