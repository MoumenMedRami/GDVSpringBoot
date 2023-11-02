package com.example.GDV.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "utilisateur")
public class Utilisateur extends AbstractEntity {

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;




    @Column(name = "email")
    private String email;

    @Column(name = "moteDePasse")
    private String moteDePasse;


    @Column(name = "dateNaissance")
    private Date dateNaissance;

    @Column(name="isActive")
    private Boolean isActive;

    @Column(name="isMale")
    private Boolean isMale;

    @Column(name="poste")
    private String poste;

    @Column(name="photo")
    private String photo;


    @OneToMany(mappedBy = "utilisateur",fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Roles> roles;

    @OneToMany(mappedBy = "utilisateur",fetch= FetchType.LAZY)
    private List<Demande> demandes ;





}