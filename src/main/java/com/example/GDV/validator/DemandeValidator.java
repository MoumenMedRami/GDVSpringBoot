package com.example.GDV.validator;

import com.example.GDV.dto.ChauffeurDto;
import com.example.GDV.dto.DemandeDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class DemandeValidator {

    public static List<String> validate(DemandeDto demandeDto) {

        List<String> errors = new ArrayList<>();

        if (demandeDto == null) {
            errors.add("Veuillez renseigner les champs d'demandeDto");

            return errors;
        }

        if (!StringUtils.hasLength(demandeDto.getCodeDemande()) ) {
            errors.add("Veuillez renseigner le getCodeDemmande() d'demandeDto ");
        }

        if (!StringUtils.hasLength(demandeDto.getDateMission()) ) {
            errors.add("Veuillez renseigner le DateMission d'demandeDto ");
        }
        if (!StringUtils.hasLength(demandeDto.getDateRetourMission())) {
            errors.add("Veuillez renseigner le DateRetourMission() d'demandeDto ");
        }
        if (!StringUtils.hasLength(demandeDto.getLieuMission())) {
            errors.add("Veuillez renseigner le LieuMission d'demandeDto ");
        }




        return errors;
    }
}
