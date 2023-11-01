package com.example.GDV.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "Demande")
public class Chauffeur extends  AbstractEntity{

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "nomArabe")
    private String nomArabe;

    @Column(name = "prenomArabe")
    private String prenomArabe;

    @Column(name="telephone")
    private String telephone;

    @ManyToOne
    private Reponse reponse;




}
