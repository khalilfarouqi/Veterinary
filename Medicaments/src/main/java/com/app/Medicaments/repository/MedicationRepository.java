package com.app.Medicaments.repository;

import com.app.Medicaments.entity.Medications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicationRepository extends JpaRepository <Medications, Long> {

}
