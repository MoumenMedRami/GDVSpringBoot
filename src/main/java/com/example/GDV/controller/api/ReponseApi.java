package com.example.GDV.controller.api;

import com.example.GDV.dto.DemandeDto;
import com.example.GDV.dto.ReponseDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ReponseApi {

    @PostMapping("gdv/reponse/create")
    ReponseDto save(@RequestBody ReponseDto dto);

    @GetMapping( "gdv/reponse/{idReponse}")
    ReponseDto findById(@PathVariable("idReponse")  Long id);


    @GetMapping( "gdv/reponse/{codeReponse}")
    ReponseDto findByCodeReponse(@PathVariable("codeReponse") String codeReponse);

    @GetMapping( "gdv/reponse/chauffeur/{idChauffeur}")
    List<ReponseDto> findAllReponseByChauffeurId(@PathVariable("idChauffeur") Long id);

    @GetMapping( "gdv/reponse/chauffeur/{nomChauffeur}")
    List<ReponseDto> findAllReponseByChauffeurNom(@PathVariable("nomChauffeur") String nom);

    @GetMapping( "gdv/reponse/demande/{idDemande}")
    List<ReponseDto> findAllReponseByDemandeId(@PathVariable("idDemande") Long id);

    @GetMapping( "gdv/reponse/demande/{codeDemande}")
    List<ReponseDto> findAllReponseByDemandeCodeDemande(@PathVariable("codeDemande") String codeDemande);

    @GetMapping( "gdv/reponse/satatus/{idStatus}")
    List<ReponseDto> findAllReponseByStatusReponseId(@PathVariable("idStatus") Long id);

    @GetMapping( "gdv/reponse/status/{codeStatus}")
    List<ReponseDto> findAllReponseByStatusReponseCodeStatus(@PathVariable("codeStatus") String nom);



    @GetMapping( "gdv/reponse/all")
    List<ReponseDto> findAll();

    @DeleteMapping("gdv/reponse/delete/{idReponse}")
    void delete(@PathVariable("idReponse") Long id);


    @PatchMapping("gdv/reponse/update/demande/{idReponse}/{idDemande}")
    ReponseDto updateDemande(@PathVariable("idReponse") Long idReponse, @PathVariable("idDemande") Long idDemande);

    @PatchMapping("gdv/reponse/update/chaffeur/{idReponse}/{idChauffeur}")
    ReponseDto updateChaffeur(@PathVariable("idReponse") Long idReponse, @PathVariable("idChauffeur") Long idChauffeur);

    @PatchMapping("gdv/reponse/update/statusReponse/{idReponse}/{idStatusReponse}")
    ReponseDto updateStatusReponse(@PathVariable("idReponse") Long idReponse, @PathVariable("idStatusReponse") Long idStatusReponse);


}
