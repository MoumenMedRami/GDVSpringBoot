package com.example.GDV.repository;

import com.example.GDV.model.Chauffeur;
import com.example.GDV.model.Reponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReponseRepository extends JpaRepository<Reponse, Long> {


    Optional<Reponse> findReponseByCodeReponse(String codeReponse);

    List<Reponse> findAllByChauffeurId(Long id);

    List<Reponse> findAllByChauffeurNom(String nom);

    List<Reponse>  findAllByDemandeId(Long id);


    List<Reponse>findAllByDemandeCodeDemande(String codeDemande);

    List<Reponse> findAllByStatusReponseCodeStatus(String codeStatus);

    List<Reponse>  findAllByStatusReponseId(Long id);
}
