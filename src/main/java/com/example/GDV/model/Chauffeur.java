package com.example.GDV.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "Chauffeur")
@Getter
@Setter
public class Chauffeur extends  AbstractEntity{

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name="telephone")
    private String telephone;

    @OneToMany(mappedBy = "chauffeur",fetch= FetchType.LAZY)
    private List<Reponse> reponses ;



}
