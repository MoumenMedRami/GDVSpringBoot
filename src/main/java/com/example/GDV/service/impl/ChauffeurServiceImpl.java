package com.example.GDV.service.impl;

import com.example.GDV.dto.ChauffeurDto;
import com.example.GDV.dto.DemandeDto;
import com.example.GDV.exception.EntityNotFoundException;
import com.example.GDV.exception.ErrorCodes;
import com.example.GDV.exception.InvalidEntityException;
import com.example.GDV.model.Chauffeur;
import com.example.GDV.repository.ChauffeurRepository;
import com.example.GDV.service.IchauffeurService;
import com.example.GDV.validator.ChauffeurValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ChauffeurServiceImpl implements IchauffeurService {


    private final ChauffeurRepository chauffeurRepository;

    public ChauffeurServiceImpl(ChauffeurRepository chauffeurRepository) {
        this.chauffeurRepository = chauffeurRepository;
    }

    @Override
    public ChauffeurDto save(ChauffeurDto dto) {
        List<String> errosUtilisateur = new ArrayList<>();



        //verification si l'Demande est invalide

        List<String> errors = ChauffeurValidator.validate(dto);

        if(!errors.isEmpty()){
            //log de l'application pour les developpeur
            log.error("Chauffeur n'est pas valide " , dto);
            throw  new InvalidEntityException("L'Chauffeur  n'est pas valide" , ErrorCodes.CHAUFFEUR_NOT_VALID, errors);
        }






        Chauffeur saveChauffeur = chauffeurRepository.save(ChauffeurDto.toEntity(dto));

        return ChauffeurDto.fromEntity(saveChauffeur);


    }

    @Override
    public ChauffeurDto findById(Long id) {
        if (id == null) {
            log.error("CHAFFEUR  ID is null");
            return null;
        }

        return chauffeurRepository.findById(id).map(ChauffeurDto::fromEntity).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucune demande  avec l'ID = " + id + " n' ete trouve dans la BDD",
                        ErrorCodes.CHAUFFEUR_NOT_FOUND)
        );
    }

    @Override
    public ChauffeurDto findByNom(String nom) {
        if (nom == null) {
            log.error("CHAFFEUR  nom is null");
            return null;
        }

        return chauffeurRepository.findChauffeurByNom(nom).map(ChauffeurDto::fromEntity).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucune demande  avec l'ID = " + nom + " n' ete trouve dans la BDD",
                        ErrorCodes.CHAUFFEUR_NOT_FOUND)
        );
    }

    @Override
    public List<ChauffeurDto> findAll() {
        return chauffeurRepository.findAll().stream()
                .map(ChauffeurDto::fromEntity) // expresion lamda
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        if (id==null)
        {
            log.error("Mission ID is null");
            return;
        }
        chauffeurRepository.deleteById(id);

    }
}
