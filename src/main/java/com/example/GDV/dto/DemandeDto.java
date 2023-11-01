package com.example.GDV.dto;


import com.example.GDV.model.Chauffeur;
import com.example.GDV.model.Demande;
import com.example.GDV.model.Reponse;
import com.example.GDV.model.Utilisateur;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@Builder
//builder est utilisée pour générer automatiquement un constructeur de type "builder" pour une classe.
@Data
public class DemandeDto {


    private Long id ;

    private String autre;

    private String remarque;

    private String nomDemande;

    private String codeDemmande;

    private Date dateCreationDemande ;

    private String numeroMission;

    private String motif;

    private String dateMission;

    private String dateRetourMission;

    private String lieuMission;


    private List<ReponseDto> reponsesDtos ;

    private UtilisateurDto utilisateurDto;








    public static DemandeDto fromEntity(Demande demande) {

        if(demande == null){

            return  null;
        }

        return  DemandeDto.builder()
                .id(demande.getId())
                .nomDemande(demande.getNomDemande())
                .codeDemmande(demande.getCodeDemmande())
                .dateCreationDemande(demande.getDateCreationDemande())
                .numeroMission(demande.getNumeroMission())
                .motif(demande.getMotif())
                . dateMission(demande.getDateMission())
                .dateRetourMission(demande.getDateRetourMission())
                .lieuMission(demande.getLieuMission())

                . utilisateurDto(UtilisateurDto.fromEntity(demande.getUtilisateur()))
                .autre(demande.getAutre())
                .remarque(demande.getRemarque())
                .build();
    }

    public static Demande toEntity(DemandeDto demandeDto) {

        if (demandeDto == null) {
            return  null;
        }
        Demande demande = new Demande();



             demande.setId(demandeDto.getId());
        demande.setNomDemande(demandeDto.getNomDemande());
        demande .setCodeDemmande(demandeDto.getCodeDemmande());
        demande .setDateCreationDemande(demandeDto.getDateCreationDemande());
        demande .setNumeroMission(demandeDto.getNumeroMission());
        demande .setMotif(demandeDto.getMotif());
        demande . setDateMission(demandeDto.getDateMission());
        demande .setDateRetourMission(demandeDto.getDateRetourMission());
        demande .setLieuMission(demandeDto.getLieuMission());


        demande .setUtilisateur(UtilisateurDto.toEntity(demandeDto.getUtilisateurDto()));
        demande .setAutre(demandeDto.getAutre());
        demande .setRemarque(demandeDto.getRemarque());



        return  demande;
    }
}
