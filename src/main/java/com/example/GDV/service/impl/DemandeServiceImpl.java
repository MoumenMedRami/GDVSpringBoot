package com.example.GDV.service.impl;

import com.example.GDV.dto.DemandeDto;
import com.example.GDV.exception.EntityNotFoundException;
import com.example.GDV.exception.ErrorCodes;
import com.example.GDV.exception.InvalidEntityException;
import com.example.GDV.model.Demande;
import com.example.GDV.model.Utilisateur;
import com.example.GDV.repository.DemandeRepository;
import com.example.GDV.repository.UtilisateurRepository;
import com.example.GDV.service.IdemandeService;
import com.example.GDV.validator.DemandeValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class DemandeServiceImpl implements IdemandeService {

    private final DemandeRepository demandeRepository ;

    private final UtilisateurRepository utilisateurRepository;

    @Autowired
    public DemandeServiceImpl(DemandeRepository demandeRepository, UtilisateurRepository utilisateurRepository) {
        this.demandeRepository = demandeRepository;
        this.utilisateurRepository = utilisateurRepository;
    }

    @Override
    public DemandeDto save(DemandeDto dto) {

        List<String> errosUtilisateur = new ArrayList<>();



        //verification si l'Demande est invalide

        List<String> errors = DemandeValidator.validate(dto);

        if(!errors.isEmpty()){
            //log de l'application pour les developpeur
            log.error("Demande n'est pas valide " , dto);
            throw  new InvalidEntityException("L'Demande  n'est pas valide" , ErrorCodes.DEMANDE_NOT_VALID, errors);
        }
//---------------- verivifier si lee utilisateur si il  existe------------------------



        if(dto.getUtilisateurDto() != null){


                    Optional<Utilisateur> utilisateur =  utilisateurRepository.findById(dto.getUtilisateurDto().getId());

                 if(utilisateur.isEmpty()){

                        errosUtilisateur.add("Le utilisateur avec l'ID "+dto.getUtilisateurDto().getId()+"n'existe pas");

                    }
                }else {
                 errosUtilisateur.add("Impossible d'enregistrer une Demande avec un utilisateur NULL ");

                }

                if( !errosUtilisateur.isEmpty()){
                    log.warn("utilisateur n'existe pas dans la base de donnée");

                    throw new InvalidEntityException("utilisateur n'existe pas dans la base de donnée",ErrorCodes.UTILISATEUR_NOT_FOUND, errosUtilisateur);

                }


                Demande saveDemande = demandeRepository.save(DemandeDto.toEntity(dto));

                return DemandeDto.fromEntity(saveDemande);



    }



    @Override
    public DemandeDto findById(Long id) {
        if (id == null) {
            log.error("demande  ID is null");
            return null;
        }

        return demandeRepository.findById(id).map(DemandeDto::fromEntity).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucune demande  avec l'ID = " + id + " n' ete trouve dans la BDD",
                        ErrorCodes.DEMANDE_NOT_FOUND)
        );
    }

    @Override
    public DemandeDto findByCodeDemande(String codeDemmande) {
        if (codeDemmande == null) {
            log.error("demande  codeDemmande is null");
            return null;
        }

        return demandeRepository.findDemandeByNomDemande(codeDemmande).map(DemandeDto::fromEntity).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucune demande  avec l'ID = " + codeDemmande + " n' ete trouve dans la BDD",
                        ErrorCodes.DEMANDE_NOT_FOUND)
        );
    }

    @Override
    public List<DemandeDto> findAllDemandeByUtilisateurId(Long id) {
        if (id == null) {
            log.error("utilisateur  id is null");
            return null;
        }

        return demandeRepository.findAllByUtilisateurId(id).stream()
                .map(DemandeDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<DemandeDto> findAllDemandeByUtilisateurNom(String nom) {
        if (nom == null) {
            log.error("nom utilisateur is null");
            return null;
        }

        return demandeRepository.findAllByUtilisateurNom(nom).stream()
                .map(DemandeDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<DemandeDto> findAll() {
        return demandeRepository.findAll().stream()
                .map(DemandeDto::fromEntity) // expresion lamda
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        if (id==null)
        {
            log.error("Mission ID is null");
            return;
        }
        demandeRepository.deleteById(id);
    }
}
