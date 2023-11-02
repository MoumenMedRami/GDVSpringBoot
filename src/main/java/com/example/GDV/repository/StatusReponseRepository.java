package com.example.GDV.repository;

import com.example.GDV.model.StatusReponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StatusReponseRepository extends JpaRepository<StatusReponse, Long> {


    Optional<StatusReponse> findStatusReponseByStatusName(String statusName);

    Optional<StatusReponse>findBycodeStatus(String codeStatus);


}