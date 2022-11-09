package com.app.Animaux.business.service;

import com.app.Animaux.business.entity.Animal;
import com.app.Animaux.business.exception.ResourceNotFoundException;
import com.app.Animaux.business.repository.AnimalRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AnimalService {

    private final AnimalRepository animalRepository;

    public AnimalService(AnimalRepository animalRepository){
        this.animalRepository = animalRepository;
    }

    public List<Animal> getAllAnimal(){
        return animalRepository.findAll();
    }

    public Animal createAnimal(Animal animal){
        return animalRepository.save(animal);
    }

    public Animal updateAnimal(long id, Animal animalRequest){
        Animal animal = animalRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Animal", "id", id));

        animal.setDate_Birth(animalRequest.getDate_Birth());
        animal.setRace(animalRequest.getRace());
        animal.setNom(animalRequest.getNom());
        animal.setDescription_condition(animalRequest.getDescription_condition());
        animal.setProprietary(animalRequest.getProprietary());

        return animalRepository.save(animal);
    }

    public void deleteAnimal(long id){
        Animal animal = animalRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Animal", "id", id));

        animalRepository.delete(animal);
    }

    public Animal getAnimalById(long id) {
        Optional<Animal> result = animalRepository.findById(id);
        if(result.isPresent()) {
            return result.get();
        }else {
            throw new ResourceNotFoundException("Animal", "id", id);
        }
    }

}
