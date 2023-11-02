package com.example.GDV.controller.api;

import com.example.GDV.dto.DemandeDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface DemandeApi {

    @PostMapping("gdv/demande/create")
    DemandeDto save(@RequestBody  DemandeDto dto);
    @GetMapping( "gdv/demande/{idDemande}")
    DemandeDto findById(@PathVariable("idDemande")  Long id);

    @GetMapping( "gdv/demande/{CodeDemmande}")
    DemandeDto findByCodeDemande(@PathVariable("CodeDemmande")  String codeDemmande);

    @GetMapping( "gdv/demande/utilisateur/{idUtilisateur}")
    List<DemandeDto> findAllDemandeByUtilisateurId(@PathVariable("idUtilisateur")  Long id);

    @GetMapping( "gdv/demande/utilisateur/{nomUtilisateur}")
    List<DemandeDto> findAllDemandeByUtilisateurNom(@PathVariable("nomUtilisateur")  String nom);

    @GetMapping( "gdv/demande/all")
    List<DemandeDto> findAll();
    @DeleteMapping("gdv/demande/delete/{idDemande}")
    void delete(@PathVariable("idDemande")  Long id);



}
