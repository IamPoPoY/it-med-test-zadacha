package com.example.taskitmed.repository;

import com.example.taskitmed.entity.Appoitment;
import com.example.taskitmed.entity.Identifier;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IdentifierRepository extends JpaRepository<Identifier, Integer> {
}
