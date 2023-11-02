package com.example.GDV.controller.api;

import com.example.GDV.dto.StatusReponseDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface StatusReponseApi {

    @PostMapping("gdv/statusReponse/create")
    StatusReponseDto save(@RequestBody StatusReponseDto dto);

    @GetMapping( "gdv/statusReponse/{idStatusReponse}")
    StatusReponseDto findById(@PathVariable("idStatusReponse") Long id);

    @GetMapping( "gdv/statusReponse/{codeStatus}")
    StatusReponseDto findByCodeStatus(@PathVariable("codeStatus") String codeStatus);

    @GetMapping( "gdv/statusReponse/reponse/{idReponse}")
    List<StatusReponseDto> findAllStatusReponseByReponseId(@PathVariable("idReponse") Long id);

    @GetMapping( "gdv/statusReponse/reponse/{codeReponse}")
    List<StatusReponseDto> findAllStatusReponseByReponseCodeReponse(@PathVariable("codeReponse") String codeReponse);


    @GetMapping( "gdv/statusReponse/all")
    List<StatusReponseDto> findAll();

    @DeleteMapping("gdv/statusReponse/delete/{idStatusReponse}")
    void delete(@PathVariable("idStatusReponse") Long id);
}
