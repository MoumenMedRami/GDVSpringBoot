package com.example.GDV.validator;

import com.example.GDV.dto.ChauffeurDto;
import com.example.GDV.dto.StatusDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class StatusDemandeValidator {

    public static List<String> validate(StatusDto statusDto) {

        List<String> errors = new ArrayList<>();

        if (statusDto == null) {
            errors.add("Veuillez renseigner les champs d'chauffeurDto");

            return errors;
        }

        if (!StringUtils.hasLength(statusDto.getStatusName()) ) {
            errors.add("Veuillez renseigner le Nom d'chauffeurDto ");
        }

        if (!StringUtils.hasLength(statusDto.getCodeStatus().toString())) {
            errors.add("Veuillez renseigner le prenom d'chauffeurDto ");
        }




        return errors;
    }
}
