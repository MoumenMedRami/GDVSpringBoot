package com.example.GDV.service;

import com.example.GDV.dto.StatusReponseDto;

import java.util.List;

public interface IstatusReponseService {

    StatusReponseDto save(StatusReponseDto dto);

    StatusReponseDto findById(Long id);

    StatusReponseDto findByCodeStatus(String codeStatus);

   // List<StatusReponseDto> findAllStatusReponseByReponseId(Long id);

  //  List<StatusReponseDto> findAllStatusReponseByReponseCodeReponse(String codeReponse);


    List<StatusReponseDto> findAll();

    void delete(Long id);
}
