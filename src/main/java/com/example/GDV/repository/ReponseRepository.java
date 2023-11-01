package com.example.GDV.repository;

import com.example.GDV.model.Chauffeur;
import com.example.GDV.model.Reponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReponseRepository extends JpaRepository<Reponse, Long> {


    Optional<Reponse> findReponseByCodeReponse(String codeReponse);

}
