package com.example.GDV.validator;

import com.example.GDV.dto.StatusReponseDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class StatusDemandeValidator {

    public static List<String> validate(StatusReponseDto statusReponseDto) {

        List<String> errors = new ArrayList<>();

        if (statusReponseDto == null) {
            errors.add("Veuillez renseigner les champs d'chauffeurDto");

            return errors;
        }

        if (!StringUtils.hasLength(statusReponseDto.getStatusName()) ) {
            errors.add("Veuillez renseigner le Nom d'chauffeurDto ");
        }

        if (!StringUtils.hasLength(statusReponseDto.getCodeStatus().toString())) {
            errors.add("Veuillez renseigner le prenom d'chauffeurDto ");
        }




        return errors;
    }
}
