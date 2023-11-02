package com.example.GDV.controller.api;

import com.example.GDV.dto.UtilisateurDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;


public interface UtilisateurApi {

    @PostMapping("gdv/utilisateur/create")
    UtilisateurDto save(@RequestBody UtilisateurDto dto);


    @GetMapping( "gdv/utilisateur/{idUtilisateur}")
    UtilisateurDto findById(@PathVariable("idUtilisateur") Long id);

    @GetMapping( "gdv/utilisateur/find/{email}")
    UtilisateurDto findByEmail(@PathVariable("email") String email);

    @GetMapping("gdv/utilisateur/all")
    List<UtilisateurDto> findAll();

    @DeleteMapping("gdv/utilisateur/delete/{idUtilisateur}")
    void delete(@PathVariable("idUtilisateur") Long id);

}
