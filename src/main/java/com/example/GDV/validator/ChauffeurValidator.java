package com.example.GDV.validator;

import com.example.GDV.dto.ChauffeurDto;
import com.example.GDV.dto.UtilisateurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ChauffeurValidator {

    public static List<String> validate(ChauffeurDto chauffeurDto) {

        List<String> errors = new ArrayList<>();

        if (chauffeurDto == null) {
            errors.add("Veuillez renseigner les champs d'chauffeurDto");

            return errors;
        }

        if (!StringUtils.hasLength(chauffeurDto.getNom()) ) {
            errors.add("Veuillez renseigner le Nom d'chauffeurDto ");
        }

        if (!StringUtils.hasLength(chauffeurDto.getPrenom()) ) {
            errors.add("Veuillez renseigner le prenom d'chauffeurDto ");
        }
        if (!StringUtils.hasLength(chauffeurDto.getTelephone())) {
            errors.add("Veuillez renseigner le Telephone d'chauffeurDto ");
        }


        return errors;
    }
}
