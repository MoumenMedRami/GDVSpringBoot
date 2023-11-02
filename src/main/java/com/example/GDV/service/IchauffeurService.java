package com.example.GDV.service;

import com.example.GDV.dto.ChauffeurDto;
import com.example.GDV.dto.DemandeDto;

import java.util.List;

public interface IchauffeurService {

    ChauffeurDto save(ChauffeurDto dto);

    ChauffeurDto findById(Long id);

    ChauffeurDto findByNom(String nom);


    List<ChauffeurDto> findAll();

    void delete(Long id);
}
