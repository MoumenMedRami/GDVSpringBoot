package com.example.GDV.model;


import jakarta.persistence.*;
import lombok.*;

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


    @ManyToOne
    StatusReponse statusReponse;


    @ManyToOne
    private Chauffeur chauffeur;


}
