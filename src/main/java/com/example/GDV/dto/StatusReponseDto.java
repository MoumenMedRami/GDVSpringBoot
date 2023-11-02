package com.example.GDV.dto;


import com.example.GDV.model.StatusReponse;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
//builder est utilisée pour générer automatiquement un constructeur de type "builder" pour une classe.
@Data
public class StatusReponseDto {

    private Long id ;


    private String autre;

    private String remarque;

    private String statusName;

    private String codeStatus;

    private List<ReponseDto> reponseDtos;


    public static StatusReponseDto fromEntity(StatusReponse statusReponse){

        if(statusReponse == null){

            return  null;
        }

        return  StatusReponseDto.builder()
                .id(statusReponse.getId())
                .statusName(statusReponse.getStatusName())
                .codeStatus(statusReponse.getCodeStatus())

                .autre(statusReponse.getAutre())
                .remarque(statusReponse.getRemarque())
                .build();
    }



    public static StatusReponse toEntity(StatusReponseDto statusReponseDto){

        if (statusReponseDto == null) {
            return  null;
        }
        StatusReponse statusReponse = new StatusReponse();



        statusReponse.setId(statusReponseDto.getId());
        statusReponse.setStatusName(statusReponseDto.getStatusName());
        statusReponse.setCodeStatus(statusReponseDto.getCodeStatus());
        statusReponse.setAutre(statusReponseDto.getAutre());
        statusReponse.setRemarque(statusReponseDto.getAutre());


        return statusReponse;
    }

}
