package com.example.GDV.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="Reponse")
@Getter
@Setter
public class Reponse extends  AbstractEntity {

    @Column(name = "codeReponse")
    private String codeReponse;


    @ManyToOne
    private Demande demande ;


    @OneToMany(mappedBy = "reponse",fetch= FetchType.LAZY)
    private List<StatusDemande> statusDemandes;

    @OneToMany(mappedBy = "reponse",fetch= FetchType.LAZY)
    private List<Chauffeur> chauffeurs ;

}
