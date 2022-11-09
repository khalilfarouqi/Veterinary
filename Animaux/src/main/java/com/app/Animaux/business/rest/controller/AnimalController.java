package com.app.Animaux.business.rest.controller;

import com.app.Animaux.business.dto.AnimalDto;
import com.app.Animaux.business.entity.Animal;
import com.app.Animaux.business.service.AnimalService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/animals")
public class AnimalController {

    @Autowired
    private ModelMapper modelMapper;

    private AnimalService animalService;

    public AnimalController(AnimalService animalService){
        this.animalService = animalService;
    }

    @GetMapping
    public List<AnimalDto> getAllAnimal(){
        return animalService.getAllAnimal().stream().map(animal -> modelMapper.map(animal, AnimalDto.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnimalDto> getAnimalById(@PathVariable(name = "id") Long id){
        Animal animal = animalService.getAnimalById(id);

        AnimalDto animalResponse = modelMapper.map(animal, AnimalDto.class);

        return ResponseEntity.ok().body(animalResponse);
    }

    @PostMapping
    public ResponseEntity<AnimalDto> createAnimal(@RequestBody AnimalDto animalDto){

        Animal animalRequest = modelMapper.map(animalDto, Animal.class);

        Animal animal = animalService.createAnimal(animalRequest);

        AnimalDto animalResponse = modelMapper.map(animal, AnimalDto.class);

        return new ResponseEntity<AnimalDto>(animalResponse, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AnimalDto> updateAnimal(@PathVariable long id, @RequestBody AnimalDto animalDto){

        Animal animalRequest = modelMapper.map(animalDto, Animal.class);

        Animal animal = animalService.updateAnimal(id, animalRequest);

        AnimalDto animalResponse = modelMapper.map(animal, AnimalDto.class);

        return ResponseEntity.ok().body(animalResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteAnimal(@PathVariable(name = "id") Long id){
        animalService.deleteAnimal(id);
        ApiResponse apiResponse = new ApiResponse(Boolean.TRUE, "Animal deleted successfully", HttpStatus.OK);
        return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);
    }

}
