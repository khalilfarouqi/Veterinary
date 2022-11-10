package com.app.Medicaments.controller;

import com.app.Medicaments.dto.MedicationDto;
import com.app.Medicaments.entity.Medications;
import com.app.Medicaments.service.MedicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/medications")
public class MedicationController {

    @Autowired
    private ModelMapper modelMapper;

    private MedicationService medicationService;

    public MedicationController(MedicationService medicationService){
        this.medicationService = medicationService;
    }

    @GetMapping
    public List<MedicationDto> getAllMedication(){
        return medicationService.getAllMedication().stream().map(medication -> modelMapper.map(medication, MedicationDto.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicationDto> getMedicationById(@PathVariable(name = "id") Long id){
        Medications medication = medicationService.getMedicationsById(id);

        MedicationDto medicationResponse = modelMapper.map(medication, MedicationDto.class);

        return ResponseEntity.ok().body(medicationResponse);
    }

    @PostMapping
    public ResponseEntity<MedicationDto> createMedication(@RequestBody MedicationDto medicationDto){

        Medications medicationRequest = modelMapper.map(medicationDto, Medications.class);

        Medications medication = medicationService.createMedication(medicationRequest);

        MedicationDto medicationResponse = modelMapper.map(medication, MedicationDto.class);

        return new ResponseEntity<MedicationDto>(medicationResponse, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MedicationDto> updateMedication(@PathVariable long id, @RequestBody MedicationDto medicationDto){

        Medications medicationRequest = modelMapper.map(medicationDto, Medications.class);

        Medications medication = medicationService.updateMedication(id, medicationRequest);

        MedicationDto medicationResponse = modelMapper.map(medication, MedicationDto.class);

        return ResponseEntity.ok().body(medicationResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMedication(@PathVariable(name = "id") Long id){
        medicationService.deleteMedication(id);
        return new ResponseEntity<String>("Medication deleted successfully", HttpStatus.OK);
    }


}
