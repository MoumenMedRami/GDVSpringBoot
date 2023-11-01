
/*
cette entity est abstract qui vas regrouper tous le champs
qui sont on commun dans tous les enteties exemple ID et Date de creation
et date de modificiation
*/

package com.example.GDV.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.Instant;


@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)// auditing
public class AbstractEntity implements Serializable {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @CreatedDate
    @Column(name="creation_date",  nullable = false , updatable = false)
    private Instant creationDate;


    @LastModifiedDate
    @Column(name="last_modified_date")
    private Instant lastModifiedDate;


    @Column(name="autre")
    private String autre;

    @Column(name="remarque")
    private String remarque;



}
