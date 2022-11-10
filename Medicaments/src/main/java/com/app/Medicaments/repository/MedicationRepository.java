package com.app.Medicaments.repository;

import com.app.Medicaments.entity.Medications;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicationRepository extends JpaRepository <Medications, Long> {

}
