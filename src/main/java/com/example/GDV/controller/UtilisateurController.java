package com.example.GDV.controller;


import com.example.GDV.controller.api.UtilisateurApi;
import com.example.GDV.dto.UtilisateurDto;
import com.example.GDV.service.IutilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UtilisateurController implements UtilisateurApi {

    private  IutilisateurService iutilisateurService;

    @Autowired
    public UtilisateurController(IutilisateurService iutilisateurService) {
        this.iutilisateurService = iutilisateurService;
    }


    @Override
    public UtilisateurDto save(UtilisateurDto dto) {
        return iutilisateurService.save(dto);
    }


    @Override
    public UtilisateurDto findById(Long id) {
        return iutilisateurService.findById(id);
    }

    @Override
    public UtilisateurDto findByEmail(String email) {
        return iutilisateurService.findByEmail(email);
    }

    @Override
    public List<UtilisateurDto> findAll() {
        return iutilisateurService.findAll();
    }

    @Override
    public void delete(Long id) {
        iutilisateurService.delete(id);
    }
}
