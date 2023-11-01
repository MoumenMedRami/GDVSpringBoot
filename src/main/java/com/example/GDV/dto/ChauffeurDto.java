package com.example.GDV.dto;


import com.example.GDV.model.Chauffeur;
import com.example.GDV.model.Reponse;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.Instant;

@Builder
//builder est utilisée pour générer automatiquement un constructeur de type "builder" pour une classe.
@Data
public class ChauffeurDto {


    private Long id ;


    private String autre;

    private String remarque;

    private String nom;

    private String prenom;

    private String nomArabe;

    private String prenomArabe;

    private String telephone;

    private ReponseDto reponseDto;

    public static ChauffeurDto fromEntity(Chauffeur chauffeur){

        if(chauffeur == null){

            return  null;
        }

        return  ChauffeurDto.builder()
                .id(chauffeur.getId())
                .nom(chauffeur.getNom())
                .prenom(chauffeur.getPrenom())
                .nomArabe(chauffeur.getNomArabe())
                .prenomArabe(chauffeur.getPrenomArabe())
                .reponseDto(ReponseDto.fromEntity(chauffeur.getReponse()))
                .telephone(chauffeur.getTelephone())
                .autre(chauffeur.getAutre())
                .remarque(chauffeur.getRemarque())
                .build();
    }



    public static  Chauffeur toEntity( ChauffeurDto chauffeurDto){

        if (chauffeurDto == null) {
            return  null;
        }
        Chauffeur  chauffeur = new Chauffeur();



                         chauffeur.setId(chauffeurDto.getId());
                         chauffeur.setNom(chauffeurDto.getNom());
                         chauffeur.setPrenom(chauffeurDto.getPrenom());
                         chauffeur.setPrenomArabe(chauffeurDto.getPrenomArabe());
                         chauffeur.setNomArabe(chauffeurDto.getPrenomArabe());
                         chauffeur.setTelephone(chauffeurDto.getTelephone());
                         chauffeur.setAutre(chauffeurDto.getAutre());
                         chauffeur.setRemarque(chauffeurDto.getRemarque());
                         chauffeur.setReponse(ReponseDto.toEntity(chauffeurDto.getReponseDto()));

        return  chauffeur;
    }




}
