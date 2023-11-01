package com.example.GDV.validator;

import com.example.GDV.dto.ChauffeurDto;
import com.example.GDV.dto.ReponseDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ReponseValidator {

    public static List<String> validate(ReponseDto reponseDto) {

        List<String> errors = new ArrayList<>();

        if (reponseDto == null) {
            errors.add("Veuillez renseigner les champs d'chauffeurDto");

            return errors;
        }

        if (!StringUtils.hasLength(reponseDto.getCodeReponse())) {
            errors.add("Veuillez renseigner le code Reponse reponseDto ");
        }


        return errors;
    }
}
