package com.example.GDV.dto;


import com.example.GDV.model.Chauffeur;
import com.example.GDV.model.Reponse;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.Instant;
import java.util.List;

@Builder
//builder est utilisée pour générer automatiquement un constructeur de type "builder" pour une classe.
@Data
public class ChauffeurDto {


    private Long id ;


    private String autre;

    private String remarque;

    private String nom;

    private String prenom;



    private String telephone;


    private List<ReponseDto> reponsesDtos ;

    public static ChauffeurDto fromEntity(Chauffeur chauffeur){

        if(chauffeur == null){

            return  null;
        }

        return  ChauffeurDto.builder()
                .id(chauffeur.getId())
                .nom(chauffeur.getNom())
                .prenom(chauffeur.getPrenom())

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
                         chauffeur.setTelephone(chauffeurDto.getTelephone());
                         chauffeur.setAutre(chauffeurDto.getAutre());
                         chauffeur.setRemarque(chauffeurDto.getRemarque());


        return  chauffeur;
    }




}
