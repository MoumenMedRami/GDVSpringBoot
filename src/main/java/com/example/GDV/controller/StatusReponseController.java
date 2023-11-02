package com.example.GDV.controller;

import com.example.GDV.controller.api.StatusReponseApi;
import com.example.GDV.dto.StatusReponseDto;
import com.example.GDV.service.IstatusReponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class StatusReponseController implements StatusReponseApi {


    private  IstatusReponseService istatusReponseService;

    @Autowired
    public StatusReponseController(IstatusReponseService istatusReponseService) {
        this.istatusReponseService = istatusReponseService;
    }

    @Override
    public StatusReponseDto save(StatusReponseDto dto) {
        return istatusReponseService.save(dto);
    }

    @Override
    public StatusReponseDto findById(Long id) {
        return istatusReponseService.findById(id);
    }

    @Override
    public StatusReponseDto findByCodeStatus(String codeStatus) {
        return istatusReponseService.findByCodeStatus(codeStatus);
    }
/*
    @Override
    public List<StatusReponseDto> findAllStatusReponseByReponseId(Long id) {
        return istatusReponseService.findAllStatusReponseByReponseId(id);
    }*/
/*
    @Override
    public List<StatusReponseDto> findAllStatusReponseByReponseCodeReponse(String codeReponse) {
        return istatusReponseService.findAllStatusReponseByReponseCodeReponse(codeReponse);
    }*/

    @Override
    public List<StatusReponseDto> findAll() {
        return istatusReponseService.findAll();
    }

    @Override
    public void delete(Long id) {
        istatusReponseService.delete(id);
    }
}
