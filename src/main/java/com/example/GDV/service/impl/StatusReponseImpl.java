package com.example.GDV.service.impl;

import com.example.GDV.dto.StatusReponseDto;
import com.example.GDV.service.IstatusReponseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
public class StatusReponseImpl implements IstatusReponseService {
    @Override
    public StatusReponseDto save(StatusReponseDto dto) {
        return null;
    }

    @Override
    public StatusReponseDto findById(Long id) {
        return null;
    }

    @Override
    public StatusReponseDto findByCodeStatus(String codeStatus) {
        return null;
    }

    @Override
    public List<StatusReponseDto> findAllStatusReponseByReponseId(Long id) {
        return null;
    }

    @Override
    public List<StatusReponseDto> findAllStatusReponseByReponseCodeReponse(String codeReponse) {
        return null;
    }

    @Override
    public List<StatusReponseDto> findAll() {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
