package com.example.GDV.service;

import com.example.GDV.dto.UtilisateurDto;

import java.util.List;

public interface IutilisateurService {


    UtilisateurDto save(UtilisateurDto dto);

    UtilisateurDto findById(Long id);

    List<UtilisateurDto> findAll();

    void delete(Long id);

    UtilisateurDto findByEmail(String email);


}
