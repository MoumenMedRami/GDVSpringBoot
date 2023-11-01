package com.example.GDV.dto;


import com.example.GDV.model.StatusDemande;
import lombok.Builder;
import lombok.Data;

@Builder
//builder est utilisée pour générer automatiquement un constructeur de type "builder" pour une classe.
@Data
public class StatusDto {

    private Long id ;


    private String autre;

    private String remarque;

    private String statusName;

    private Boolean codeStatus;

   private ReponseDto reponseDto ;


    public static StatusDto fromEntity(StatusDemande statusDemande){

        if(statusDemande == null){

            return  null;
        }

        return  StatusDto.builder()
                .id(statusDemande.getId())
                .statusName(statusDemande.getStatusName())
                .codeStatus(statusDemande.getCodeStatus())
                .reponseDto(ReponseDto.fromEntity(statusDemande.getReponse()))
                .autre(statusDemande.getAutre())
                .remarque(statusDemande.getRemarque())
                .build();
    }



    public static StatusDemande toEntity(StatusDto statusDto){

        if (statusDto == null) {
            return  null;
        }
        StatusDemande statusDemande = new StatusDemande();



        statusDemande.setId(statusDto.getId());
        statusDemande.setStatusName(statusDto.getStatusName());
        statusDemande.setCodeStatus(statusDto.getCodeStatus());
        statusDemande.setAutre(statusDto.getAutre());
        statusDemande.setRemarque(statusDto.getAutre());
        statusDemande.setReponse(ReponseDto.toEntity(statusDto.getReponseDto()));

        return statusDemande;
    }

}
