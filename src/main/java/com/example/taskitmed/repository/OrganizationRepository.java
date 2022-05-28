package com.example.taskitmed.repository;

import com.example.taskitmed.entity.Appoitment;
import com.example.taskitmed.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: JADANOV_DILMUROD
 * @date:28.05.2022
 */
public interface OrganizationRepository extends JpaRepository<Long, Organization> {
}
