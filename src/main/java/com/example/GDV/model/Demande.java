package com.example.GDV.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "Demande")
@Getter
@Setter
public class Demande extends AbstractEntity{

    @Column(name = "nomDemande")
    private String nomDemande;

    @Column(name = "codeDemande")
    private String codeDemande;


    @Column(name="dateCreationDemande")
    private LocalDateTime dateCreationDemande =LocalDateTime.now() ;

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



    @ManyToOne
    private  Utilisateur utilisateur;

    @OneToMany(mappedBy = "demande",fetch= FetchType.LAZY)
    private List<Reponse> reponses ;

}
