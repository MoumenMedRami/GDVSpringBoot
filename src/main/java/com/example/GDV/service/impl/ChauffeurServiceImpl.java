package com.example.GDV.service.impl;

import com.example.GDV.dto.ChauffeurDto;
import com.example.GDV.service.IchauffeurService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ChauffeurServiceImpl implements IchauffeurService {
    @Override
    public ChauffeurDto save(ChauffeurDto dto) {
        return null;
    }

    @Override
    public ChauffeurDto findById(Long id) {
        return null;
    }

    @Override
    public ChauffeurDto findByNom(String nom) {
        return null;
    }

    @Override
    public List<ChauffeurDto> findAll() {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
