package com.example.GDV.service.impl;

import com.example.GDV.dto.ChauffeurDto;
import com.example.GDV.dto.DemandeDto;
import com.example.GDV.dto.ReponseDto;
import com.example.GDV.dto.StatusReponseDto;
import com.example.GDV.exception.EntityNotFoundException;
import com.example.GDV.exception.ErrorCodes;
import com.example.GDV.exception.InvalidEntityException;
import com.example.GDV.exception.InvalidOperationException;
import com.example.GDV.model.Chauffeur;
import com.example.GDV.model.Demande;
import com.example.GDV.model.Reponse;
import com.example.GDV.model.StatusReponse;
import com.example.GDV.repository.ChauffeurRepository;
import com.example.GDV.repository.DemandeRepository;
import com.example.GDV.repository.ReponseRepository;
import com.example.GDV.repository.StatusReponseRepository;
import com.example.GDV.service.IreponseService;
import com.example.GDV.validator.ReponseValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@Slf4j
public class ReponseServiceImpl  implements IreponseService {




    private final ReponseRepository reponseRepository;

    private final ChauffeurRepository chauffeurRepository;

    private final DemandeRepository  demandeRepository;

    private final StatusReponseRepository statusReponseRepository ;

    @Autowired
    private ReponseServiceImpl(ReponseRepository reponseRepository, ChauffeurRepository chauffeurRepository, DemandeRepository demandeRepository, StatusReponseRepository statusReponseRepository) {
        this.reponseRepository = reponseRepository;
        this.chauffeurRepository = chauffeurRepository;
        this.demandeRepository = demandeRepository;
        this.statusReponseRepository = statusReponseRepository;
    }


    @Override
    public ReponseDto save(ReponseDto dto) {
        List<String> errosDemande= new ArrayList<>();
        List<String> errosStatusReponse= new ArrayList<>();
        List<String> errosChauffeur= new ArrayList<>();



        //verification si l'Reponse est invalide

        List<String> errors = ReponseValidator.validate(dto);

        if(!errors.isEmpty()){
            //log de l'application pour les developpeur
            log.error("Reponse n'est pas valide " , dto);
            throw  new InvalidEntityException("L'Reponse n'est pas valide" , ErrorCodes.REPONSE_NOT_VALID, errors);
        }
//---------------- verivifier  le chauffeur si il  existe------------------------



        if(dto.getChauffeursDto() != null){


            Optional<Chauffeur> chauffeur =  chauffeurRepository.findById(dto.getChauffeursDto().getId());

            if(chauffeur.isEmpty()){

                errosChauffeur.add("Le chauffeur avec l'ID "+dto.getChauffeursDto().getId()+"n'existe pas");

            }
        }else {
            errosChauffeur.add("Impossible d'enregistrer un chauffeur avec un chauffeur NULL ");

        }

        if( !errosChauffeur.isEmpty()){
            log.warn("chauffeur n'existe pas dans la base de donnée");

            throw new InvalidEntityException("chauffeur n'existe pas dans la base de donnée",ErrorCodes.CHAUFFEUR_NOT_FOUND, errosChauffeur);

        }
//-------------------------------------------------------------------------------------------------------


        //---------------- verivifier  le Demande si il  existe------------------------



        if(dto.getDemandeDto() != null){


            Optional<Demande> demande =  demandeRepository.findById(dto.getDemandeDto().getId());

            if(demande.isEmpty()){

                errosDemande.add("Le Demande avec l'ID "+dto.getDemandeDto().getId()+"n'existe pas");

            }
        }else {
            errosDemande.add("Impossible d'enregistrer une Reponse avec une Demande NULL ");

        }

        if( !errosDemande.isEmpty()){
            log.warn("Demande n'existe pas dans la base de donnée");

            throw new InvalidEntityException("Demande n'existe pas dans la base de donnée",ErrorCodes.DEMANDE_NOT_FOUND, errosDemande);

        }
//-------------------------------------------------------------------------------------------------------



        //---------------- verivifier  le StatusReponse si il  existe------------------------



        if(dto.getStatusReponseDto() != null){


            Optional<StatusReponse> statusReponse =  statusReponseRepository.findById(dto.getStatusReponseDto().getId());

            if(statusReponse.isEmpty()){

                errosStatusReponse.add("Le StatusReponse avec l'ID "+dto.getStatusReponseDto().getId()+"n'existe pas");

            }
        }else {
            errosStatusReponse.add("Impossible d'enregistrer une Reponse avec un StatusReponse NULL ");

        }

        if( !errosStatusReponse.isEmpty()){
            log.warn("Reponse n'existe pas dans la base de donnée");

            throw new InvalidEntityException("Reponse n'existe pas dans la base de donnée",ErrorCodes.STATUS_REPONSE_NOT_VALID, errosStatusReponse);

        }
//-------------------------------------------------------------------------------------------------------







        Reponse saveReponse = reponseRepository.save(ReponseDto.toEntity(dto));

        return ReponseDto.fromEntity(saveReponse);
    }

    @Override
    public ReponseDto findById(Long id) {
        if (id == null) {
            log.error("Reponse  ID is null");
            return null;
        }

        return reponseRepository.findById(id).map(ReponseDto::fromEntity).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucune Reponse  avec l'ID = " + id + " n' ete trouve dans la BDD",
                        ErrorCodes.REPONSE_NOT_FOUND)
        );
    }

    @Override
    public ReponseDto findByCodeReponse(String codeReponse) {
        if (codeReponse == null) {
            log.error("Reponse  CODE  is null");
            return null;
        }

        return reponseRepository.findReponseByCodeReponse(codeReponse).map(ReponseDto::fromEntity).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucune Reponse  avec l'ID = " + codeReponse + " n' ete trouve dans la BDD",
                        ErrorCodes.REPONSE_NOT_FOUND)
        );
    }

    @Override
    public List<ReponseDto> findAllReponseByChauffeurId(Long id) {
        if (id == null) {
            log.error("Chauffeur  ID is null");
            return null;
        }



        return reponseRepository.findAllByChauffeurId(id).stream()
                .map(ReponseDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<ReponseDto> findAllReponseByChauffeurNom(String nom) {
        if (nom == null) {
            log.error("chauffeur nom   is null");
            return null;
        }



        return reponseRepository.findAllByChauffeurNom(nom).stream()
                .map(ReponseDto::fromEntity)
                .collect(Collectors.toList());
    }



    @Override
    public List<ReponseDto> findAllReponseByDemandeId(Long id) {
        if (id == null) {
            log.error("Demande Id   is null");
            return null;
        }



        return reponseRepository.findAllByDemandeId(id).stream()
                .map(ReponseDto::fromEntity)
                .collect(Collectors.toList());
    }



    @Override
    public List<ReponseDto> findAllReponseByDemandeCodeDemande(String codeDemande) {
        if (codeDemande == null) {
            log.error("codeDemande   is null");
            return null;
        }



        return reponseRepository.findAllByDemandeCodeDemande(codeDemande).stream()
                .map(ReponseDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<ReponseDto> findAllReponseByStatusReponseCodeStatus(String CodeStatus) {
        if (CodeStatus == null) {
            log.error("CodeStatus   is null");
            return null;
        }



        return reponseRepository.findAllByStatusReponseCodeStatus(CodeStatus).stream()
                .map(ReponseDto::fromEntity)
                .collect(Collectors.toList());
    }
    @Override
    public List<ReponseDto> findAllReponseByStatusReponseId(Long id) {
        if (id == null) {
            log.error("Id Status Reponse   is null");
            return null;
        }



        return reponseRepository.findAllByStatusReponseId(id).stream()
                .map(ReponseDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<ReponseDto> findAll() {
        return reponseRepository.findAll().stream()
                .map(ReponseDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        if (id == null) {
            log.error("Article ID is null");
            return;
        }

        reponseRepository.deleteById(id);
    }





    @Override
    public ReponseDto updateDemande(Long idReponse, Long idDemande) {
        checkIdReponse(idReponse);
        if (idDemande == null) {
            log.error("L'ID du demande is NULL");
            throw new InvalidOperationException("Impossible de modifier l'etat de la reponse avec un ID demande null",
                    ErrorCodes.REPONSE_NON_MODIFIABLE);
        }

        Optional<Demande> demande = demandeRepository.findById(idDemande);
        if (demande.isEmpty()) {
            throw new EntityNotFoundException(
                    "Aucune demande n'a ete trouve avec l'ID " + idDemande, ErrorCodes.DEMANDE_NOT_FOUND);
        }

        ReponseDto reponseDto = findById(idReponse);

        reponseDto.setDemandeDto(DemandeDto.fromEntity(demande.get()));

        return ReponseDto.fromEntity(
                reponseRepository.save(ReponseDto.toEntity(reponseDto))
        );
    }

    @Override
    public ReponseDto updateChaffeur(Long idReponse, Long idChauffeur) {
        checkIdReponse(idReponse);
        if (idChauffeur == null) {
            log.error("L'ID du Chauffeur is NULL");
            throw new InvalidOperationException("Impossible de modifier l'etat de la reponse avec un ID idChauffeur null",
                    ErrorCodes.REPONSE_NON_MODIFIABLE);
        }

        Optional<Chauffeur> chauffeur = chauffeurRepository.findById(idChauffeur);
        if (chauffeur.isEmpty()) {
            throw new EntityNotFoundException(
                    "Aucun chauffeur n'a ete trouve avec l'ID " + idChauffeur, ErrorCodes.CHAUFFEUR_NOT_FOUND);
        }

        ReponseDto reponseDto = findById(idReponse);

        reponseDto.setChauffeursDto(ChauffeurDto.fromEntity(chauffeur.get()));

        return ReponseDto.fromEntity(
                reponseRepository.save(ReponseDto.toEntity(reponseDto))
        );
    }

    @Override
    public ReponseDto updateStatusReponse(Long idReponse, Long idStatusReponse) {
        checkIdReponse(idReponse);
        if (idStatusReponse == null) {
            log.error("L'ID du StatusReponse is NULL");
            throw new InvalidOperationException("Impossible de modifier l'etat de la reponse avec un ID idStatusReponse null",
                    ErrorCodes.REPONSE_NON_MODIFIABLE);
        }

        Optional<StatusReponse> statusReponse = statusReponseRepository.findById(idStatusReponse);
        if (statusReponse.isEmpty()) {
            throw new EntityNotFoundException(
                    "Aucun chauffeur n'a ete trouve avec l'ID " + idStatusReponse, ErrorCodes.STATUS_REPONSE_NOT_FOUND);
        }

        ReponseDto reponseDto = findById(idReponse);

        reponseDto.setStatusReponseDto(StatusReponseDto.fromEntity(statusReponse.get()));

        return ReponseDto.fromEntity(
                reponseRepository.save(ReponseDto.toEntity(reponseDto))
        );
    }






    private void checkIdReponse(Long idReponse) {
        if (idReponse == null) {
            log.error("Commande client ID is NULL");
            throw new InvalidOperationException("Impossible de modifier l'etat de la reponse avec un ID null",
                    ErrorCodes.REPONSE_NON_MODIFIABLE);
        }
    }
}
