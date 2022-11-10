package com.app.Medicaments.service;

import com.app.Medicaments.entity.Medications;
import com.app.Medicaments.exception.ResourceNotFoundException;
import com.app.Medicaments.repository.MedicationRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MedicationService {

    private final MedicationRepository medicationRepository;

    public MedicationService(MedicationRepository medicationRepository){
        this.medicationRepository = medicationRepository;
    }

    public List<Medications> getAllMedication() {
        return medicationRepository.findAll();
    }

    public Medications createMedication(Medications medication) {
        return medicationRepository.save(medication);
    }

    public Medications updateMedication(long id, Medications medicationsRequest) {
        Medications medications = medicationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Medication", "id", id));

        medications.setNom(medicationsRequest.getNom());
        medications.setUPET(medicationsRequest.getUPET());
        medications.setMarque(medicationsRequest.getMarque());
        medications.setQteStock(medicationsRequest.getQteStock());

        return medicationRepository.save(medications);
    }

    public void deleteMedication(long id) {
        Medications medications = medicationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Medications", "id", id));

        medicationRepository.delete(medications);
    }

    public Medications getMedicationsById(long id) {
        Optional<Medications> result = medicationRepository.findById(id);
        if(result.isPresent()) {
            return result.get();
        }else {
            throw new ResourceNotFoundException("Medications", "id", id);
        }
    }

}
