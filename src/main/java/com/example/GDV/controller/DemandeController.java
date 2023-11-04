package com.example.GDV.controller;

import com.example.GDV.controller.api.DemandeApi;
import com.example.GDV.dto.DemandeDto;
import com.example.GDV.dto.FilterDemande;
import com.example.GDV.dto.RestPage;
import com.example.GDV.service.IdemandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class DemandeController implements DemandeApi {

    private  IdemandeService idemandeService ;

    @Autowired
    public DemandeController(IdemandeService idemandeService) {
        this.idemandeService = idemandeService;
    }


    @Override
    public DemandeDto save(DemandeDto dto) {
        return idemandeService.save(dto);
    }

    @Override
    public DemandeDto findById(Long id) {
        return idemandeService.findById(id);
    }

    @Override
    public DemandeDto findByCodeDemande(String codeDemmande) {
        return idemandeService.findByCodeDemande(codeDemmande);
    }

    @Override
    public List<DemandeDto> findAllDemandeByUtilisateurId(Long id) {
        return idemandeService.findAllDemandeByUtilisateurId(id);
    }

    @Override
    public List<DemandeDto> findAllDemandeByUtilisateurNom(String nom) {
        return idemandeService.findAllDemandeByUtilisateurNom(nom);
    }

    @Override
    public RestPage findAll(FilterDemande filter) {
        return idemandeService.findAll(filter);
    }

    @Override
    public void delete(Long id) {
        idemandeService.delete(id);
    }




}
