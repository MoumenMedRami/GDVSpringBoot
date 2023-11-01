package com.example.GDV.model;

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
@Table(name = "Demande")
public class Demande extends AbstractEntity{

    @Column(name = "nomDemande")
    private String nomDemande;

    @Column(name = "codeDemande")
    private String codeDemmande;


    @Column(name="dateCreationDemande")
    private Date dateCreationDemande ;

    @Column(name = "numeroMission")
    private String numeroMission;

    @Column(name = "motifMission")
    private String motif;

    @Column(name ="dateMission")
    private String dateMission;

    @Column(name ="dateRetourMission")
    private String dateRetourMission;

    @Column(name ="lieuMission")
    private String lieuMission;

    @Column(name="isMale")
    private Boolean isMale;

    @ManyToOne
    private  Utilisateur utilisateur;

    @OneToMany(mappedBy = "demande",fetch= FetchType.LAZY)
    private List<Reponse> reponses ;

}