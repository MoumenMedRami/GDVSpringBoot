package com.example.GDV.controller.api;

import com.example.GDV.dto.ChauffeurDto;
import com.example.GDV.dto.DemandeDto;
import com.example.GDV.dto.UtilisateurDto;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ChauffeurApi {

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("gdv/chauffeur/create")
    ChauffeurDto save(@RequestBody ChauffeurDto dto);


    @GetMapping( "gdv/chauffeur/{idChauffeur}")
    ChauffeurDto findById(@PathVariable("idChauffeur") Long id);

    @GetMapping( "gdv/chauffeur/{nomChauffeur}")
    ChauffeurDto findByNom(@PathVariable("nomChauffeur")String nom);

    @GetMapping( "gdv/chauffeur/all")
    List<ChauffeurDto> findAll();

    @DeleteMapping("gdv/chauffeur/delete/{idChauffeur}")
    void delete(@PathVariable("idChauffeur")Long id);



}
