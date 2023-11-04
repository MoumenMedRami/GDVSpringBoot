package com.example.GDV.repository;

import com.example.GDV.model.Chauffeur;
import com.example.GDV.model.Demande;
import com.example.GDV.model.Utilisateur;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface DemandeRepository extends JpaRepository<Demande, Long> {


    Optional<Demande> findDemandeByNomDemande(String nomDemande);

    List<Demande> findAllByUtilisateurId(Long id);

    List<Demande>  findAllByUtilisateurNom(String nom);


    @Query(value = """
                    SELECT r FROM Demande r WHERE
                    (:codeDemande IS NULL OR :codeDemande='' OR r.codeDemande LIKE %:codeDemande% ) AND
                    (:dateMission IS NULL OR :dateMission='' OR r.dateMission = :dateMission ) AND
                    (:dateRetourMission IS NULL OR :dateRetourMission='' OR r.dateRetourMission = :dateRetourMission ) AND
                    (:lieuMission IS NULL OR :lieuMission='' OR r.lieuMission LIKE %:lieuMission% )
                    ORDER BY r.dateCreationDemande DESC
                    """)
    Page<Demande> filter(
            @Param("codeDemande") String codeDemande,
            @Param("dateMission") String dateMission,
            @Param("dateRetourMission") String dateRetourMission,
            @Param("lieuMission") String lieuMission,

            Pageable pageable);


   // @Query(value = "SELECT max(id) from demande")
        Demande  findTopByOrderByIdDesc();
}
