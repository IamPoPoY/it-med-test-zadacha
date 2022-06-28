package com.example.taskitmed.repository;

import com.example.taskitmed.entity.Appoitment;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AppoitmentRepository extends JpaRepository<Appoitment, Integer> {
    boolean existsByPatient(String patient);
    boolean existsByPraction(String praction);
    boolean existsByOranization(String oranization);

    boolean existsByIdentifier_Values(String identifier_values);
    boolean existsByIdentifier_SystemUrl(String identifier_systemUrl);
}
