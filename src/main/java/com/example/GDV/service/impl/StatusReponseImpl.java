package com.example.GDV.service.impl;

import com.example.GDV.dto.ChauffeurDto;
import com.example.GDV.dto.StatusReponseDto;
import com.example.GDV.exception.EntityNotFoundException;
import com.example.GDV.exception.ErrorCodes;
import com.example.GDV.exception.InvalidEntityException;
import com.example.GDV.model.StatusReponse;
import com.example.GDV.repository.StatusReponseRepository;
import com.example.GDV.service.IstatusReponseService;
import com.example.GDV.validator.StatusDemandeValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Slf4j
public class StatusReponseImpl implements IstatusReponseService {


    private final StatusReponseRepository statusReponseRepository;

    public StatusReponseImpl(StatusReponseRepository statusReponseRepository) {
        this.statusReponseRepository = statusReponseRepository;
    }


    @Override
    public StatusReponseDto save(StatusReponseDto dto) {
        List<String> errosStatusReponse = new ArrayList<>();

        //verification si l'Demande est invalide

        List<String> errors = StatusDemandeValidator.validate(dto);

        if(!errors.isEmpty()){
            //log de l'application pour les developpeur
            log.error("StatusReponse n'est pas valide " , dto);
            throw  new InvalidEntityException("L'StatusReponse  n'est pas valide" , ErrorCodes.STATUS_REPONSE_NOT_VALID, errors);
        }






        StatusReponse saveStatusReponse = statusReponseRepository.save(StatusReponseDto.toEntity(dto));

        return StatusReponseDto.fromEntity(saveStatusReponse);
    }

    @Override
    public StatusReponseDto findById(Long id) {
        if (id == null) {
            log.error("statusReponse  ID is null");
            return null;
        }

        return statusReponseRepository.findById(id).map(StatusReponseDto::fromEntity).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucune demande  avec l'ID = " + id + " n' ete trouve dans la BDD",
                        ErrorCodes.STATUS_REPONSE_NOT_FOUND)
        );
    }

    @Override
    public StatusReponseDto findByCodeStatus(String codeStatus) {
        if (codeStatus == null) {
            log.error("statusReponse  codeStatus is null");
            return null;
        }

        return statusReponseRepository.findBycodeStatus(codeStatus).map(StatusReponseDto::fromEntity).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucune demande  avec l'ID = " + codeStatus + " n' ete trouve dans la BDD",
                        ErrorCodes.STATUS_REPONSE_NOT_FOUND)
        );
    }

    @Override
    public List<StatusReponseDto> findAllStatusReponseByReponseId(Long id) {
        if (id == null) {
            log.error("statusReponse  id is null");
            return null;
        }

        return statusReponseRepository.findAllByReponseId(id).stream()
                .map(StatusReponseDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public List<StatusReponseDto> findAllStatusReponseByReponseCodeReponse(String codeReponse) {
        if (codeReponse == null) {
            log.error("statusReponse  codeReponse is null");
            return null;
        }

        return statusReponseRepository.findAllByReponseCodeReponse(codeReponse).stream()
                .map(StatusReponseDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public List<StatusReponseDto> findAll() {
        return statusReponseRepository.findAll().stream()
                .map(StatusReponseDto::fromEntity) // expresion lamda
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {

        if (id==null)
        {
            log.error("Mission ID is null");
            return;
        }
        statusReponseRepository.deleteById(id);

    }
}
