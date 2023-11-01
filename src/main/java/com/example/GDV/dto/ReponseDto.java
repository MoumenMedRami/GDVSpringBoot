package com.example.GDV.dto;


import com.example.GDV.model.Chauffeur;
import com.example.GDV.model.Reponse;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
//builder est utilisée pour générer automatiquement un constructeur de type "builder" pour une classe.
@Data
public class ReponseDto {


    private Long id ;

    private String autre;

    private String remarque;

    private String codeReponse;

    private DemandeDto demandeDto ;

    private List<StatusDto> statusesDtos ;

    private List<ChauffeurDto> chauffeursDtos ;


    public static ReponseDto fromEntity(Reponse reponse){

        if(reponse == null){

            return  null;
        }

        return  ReponseDto.builder()
                .id(reponse.getId())
                .codeReponse(reponse.getCodeReponse())
                .demandeDto(DemandeDto.fromEntity(reponse.getDemande()))
                .autre(reponse.getAutre())
                .remarque(reponse.getRemarque())
                .build();
    }



    public static  Reponse toEntity( ReponseDto reponseDto){

        if (reponseDto == null) {
            return  null;
        }
        Reponse  reponse = new Reponse();



        reponse.setId(reponseDto.getId());
        reponse.setCodeReponse(reponseDto.getCodeReponse());
        reponse.setAutre(reponseDto.getAutre());
        reponse.setRemarque(reponseDto.getRemarque());
        reponse.setDemande(DemandeDto.toEntity(reponseDto.getDemandeDto()));

        return  reponse;
    }



}
