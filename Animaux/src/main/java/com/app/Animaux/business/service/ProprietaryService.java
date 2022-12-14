package com.app.Animaux.business.service;

import com.app.Animaux.business.entity.Proprietary;
import com.app.Animaux.business.exception.ResourceNotFoundException;
import com.app.Animaux.business.repository.ProprietaryRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProprietaryService {

    private final ProprietaryRepository proprietaryRepository;

    public ProprietaryService(ProprietaryRepository proprietaryRepository){
        this.proprietaryRepository = proprietaryRepository;
    }

    public List<Proprietary> getAllProprietary() {
        return proprietaryRepository.findAll();
    }

    public Proprietary createProprietary(Proprietary proprietary) {
        return proprietaryRepository.save(proprietary);
    }

    public Proprietary updateProprietary(long id, Proprietary proprietaryRequest) {
        Proprietary proprietary = proprietaryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Proprietary", "id", id));

        if (proprietaryRequest.getLastNom() != null) proprietary.setLastNom(proprietaryRequest.getLastNom());
        if (proprietaryRequest.getCIN() != null) proprietary.setCIN(proprietaryRequest.getCIN());
        if (proprietaryRequest.getFirstNom() != null) proprietary.setFirstNom(proprietaryRequest.getFirstNom());
        if (proprietaryRequest.getProprietary() != null) proprietary.setProprietary(proprietaryRequest.getProprietary());

        return proprietaryRepository.save(proprietary);
    }

    public void deleteProprietary(long id) {
        Proprietary proprietary = proprietaryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Proprietary", "id", id));

        proprietaryRepository.delete(proprietary);
    }

    public Proprietary getProprietaryById(long id) {
        Optional<Proprietary> result = proprietaryRepository.findById(id);
        if(result.isPresent()) {
            return result.get();
        }else {
            throw new ResourceNotFoundException("Proprietary", "id", id);
        }
    }

}
