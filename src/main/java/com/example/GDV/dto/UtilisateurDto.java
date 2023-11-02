package com.example.GDV.dto;

import com.example.GDV.model.Demande;
import com.example.GDV.model.Roles;
import com.example.GDV.model.Utilisateur;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Builder
//builder est utilisée pour générer automatiquement un constructeur de type "builder" pour une classe.
@Data
public class UtilisateurDto {

    private Long id ;


    private String autre;

    private String remarque;

    private String nom;

    private String prenom;



    private String email;

    private String moteDePasse;

    private Boolean isActive;
    private Boolean isMale;

    private Date dateNaissance;


    private String poste;

    private String photo;


    private List<RolesDto> rolesDtos;

    private List<DemandeDto> demandesDtos ;


    public static UtilisateurDto fromEntity(Utilisateur utilisateur) {

        if (utilisateur == null) {
            return null;
        }

        return UtilisateurDto.builder()
                .id(utilisateur.getId())
                .nom(utilisateur.getNom())
                .prenom(utilisateur.getPrenom())

                .email(utilisateur.getEmail())
                .moteDePasse(utilisateur.getMoteDePasse())
                .dateNaissance(utilisateur.getDateNaissance())
                .photo(utilisateur.getPhoto())
                .isActive(utilisateur.getIsActive())
                .isMale(utilisateur.getIsMale())
                .poste(utilisateur.getPoste())


                .rolesDtos(
                        utilisateur.getRoles() != null ?
                                utilisateur.getRoles().stream()
                                        .map(RolesDto::fromEntity)
                                        .collect(Collectors.toList()) : null
                )
                .build();
    }

    public static Utilisateur toEntity(UtilisateurDto utilisateurDto) {

        if (utilisateurDto == null) {
            return null;
        }

        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(utilisateurDto.getId());
        utilisateur.setNom(utilisateurDto.getNom());
        utilisateur.setPrenom(utilisateurDto.getPrenom());

        utilisateur.setIsActive(utilisateurDto.getIsActive());
        utilisateur.setIsMale(utilisateurDto.getIsMale());
        utilisateur.setEmail(utilisateurDto.getEmail());
        utilisateur.setMoteDePasse(utilisateurDto.getMoteDePasse());
        utilisateur.setDateNaissance(utilisateurDto.getDateNaissance());
        utilisateur.setPhoto(utilisateurDto.getPhoto());



        return utilisateur;
    }
}
