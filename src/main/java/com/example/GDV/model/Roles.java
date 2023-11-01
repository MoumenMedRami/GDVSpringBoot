package com.example.GDV.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="Roles")
@Getter
@Setter
public class Roles extends AbstractEntity {


    @Column(name = "rolename")
    private String roleName;

    @ManyToOne
    private Utilisateur utilisateur;



}