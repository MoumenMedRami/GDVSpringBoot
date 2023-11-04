package com.example.GDV.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FilterDemande extends FilterAbstract {

    private String codeDemande;
    private String dateMission;
    private  String dateRetourMission;
    private String lieuMission;

}
