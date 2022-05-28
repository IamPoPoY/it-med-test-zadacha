package com.example.taskitmed.repository;

import com.example.taskitmed.entity.Appoitment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: JADANOV_DILMUROD
 * @date:28.05.2022
 */
public interface AppoitmentRepository extends JpaRepository<Appoitment, Long> {
}
