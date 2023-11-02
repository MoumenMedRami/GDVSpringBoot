package com.example.GDV.validator;

import com.example.GDV.dto.UtilisateurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class UtilisateurValidator {

    public  static List<String> validate(UtilisateurDto utilisateurDto){

        List<String> errors = new ArrayList<>();

        if (utilisateurDto == null) {
            errors.add("Veuillez renseigner les champs d'utilisateurDto");

            return errors;
        }

        if (!StringUtils.hasLength(utilisateurDto.getNom())  ) {
            errors.add("Veuillez renseigner le Nom d'utilisateurDto ");
        }

        if (!StringUtils.hasLength(utilisateurDto.getPrenom()) ) {
            errors.add("Veuillez renseigner le prenom d'utilisateurDto ");
        }
        if (!StringUtils.hasLength(utilisateurDto.getPoste()) ) {
            errors.add("Veuillez renseigner le poste d'utilisateurDto ");
        }
        if (!StringUtils.hasLength(utilisateurDto.getIsMale().toString()) ) {
            errors.add("Veuillez renseigner le genre d'utilisateurDto ");
        }


        return  errors;
    }
}
