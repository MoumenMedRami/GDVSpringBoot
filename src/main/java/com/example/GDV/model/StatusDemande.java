package com.example.GDV.model;


import jakarta.persistence.*;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="StatusDemande")
@Getter
@Setter
public class StatusDemande extends AbstractEntity{

    @Column(name = "statusName")
    private String statusName;


    @Column(name="codeStatus")
    private Boolean codeStatus;


    @ManyToOne
    Reponse reponse ;

}
