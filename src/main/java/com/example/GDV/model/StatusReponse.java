package com.example.GDV.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="StatusDemande")
@Getter
@Setter
public class StatusReponse extends AbstractEntity{

    @Column(name = "statusName")
    private String statusName;


    @Column(name="codeStatus")
    private String codeStatus;


    @OneToMany(mappedBy = "statusReponse",fetch= FetchType.LAZY)
    private List<Reponse> reponses;

}
