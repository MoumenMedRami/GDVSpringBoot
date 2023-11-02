package com.example.GDV.controller;


import com.example.GDV.controller.api.ChauffeurApi;
import com.example.GDV.dto.ChauffeurDto;

import com.example.GDV.service.IchauffeurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ChauffeurController implements ChauffeurApi {

   private  IchauffeurService ichauffeurService;

    @Autowired
    public ChauffeurController(IchauffeurService ichauffeurService) {
        this.ichauffeurService = ichauffeurService;
    }


    @Override
    public ChauffeurDto save(ChauffeurDto dto) {
        return ichauffeurService.save(dto);
    }

    @Override
    public ChauffeurDto findById(Long id) {
        return ichauffeurService.findById(id);
    }

    @Override
    public ChauffeurDto findByNom(String nom) {
        return ichauffeurService.findByNom(nom);
    }

    @Override
    public List<ChauffeurDto> findAll() {
        return ichauffeurService.findAll();
    }

    @Override
    public void delete(Long id) {
        ichauffeurService.delete(id);
    }
}
