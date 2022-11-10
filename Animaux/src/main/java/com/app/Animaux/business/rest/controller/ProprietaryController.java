package com.app.Animaux.business.rest.controller;

import com.app.Animaux.business.dto.ProprietaryDto;
import com.app.Animaux.business.entity.Proprietary;
import com.app.Animaux.business.service.ProprietaryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/proprietary")
public class ProprietaryController {

    @Autowired
    private ModelMapper modelMapper;

    private ProprietaryService proprietaryService;

    private ProprietaryController(ProprietaryService proprietaryService){
        this.proprietaryService = proprietaryService;
    }

    @GetMapping
    public List<ProprietaryDto> getAllProprietary(){
        return proprietaryService.getAllProprietary().stream().map(proprietary -> modelMapper.map(proprietary, ProprietaryDto.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProprietaryDto> getProprietaryById(@PathVariable(name = "id") Long id){
        Proprietary proprietary = proprietaryService.getProprietaryById(id);

        ProprietaryDto proprietaryResponse = modelMapper.map(proprietary, ProprietaryDto.class);

        return ResponseEntity.ok().body(proprietaryResponse);
    }

    @PostMapping
    public ResponseEntity<ProprietaryDto> createProprietary(@RequestBody ProprietaryDto proprietaryDto){

        Proprietary proprietaryRequest = modelMapper.map(proprietaryDto, Proprietary.class);

        Proprietary proprietary = proprietaryService.createProprietary(proprietaryRequest);

        ProprietaryDto proprietaryResponse = modelMapper.map(proprietary, ProprietaryDto.class);

        return new ResponseEntity<ProprietaryDto>(proprietaryResponse, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProprietaryDto> updateProprietary(@PathVariable long id, @RequestBody ProprietaryDto proprietaryDto){

        Proprietary proprietaryRequest = modelMapper.map(proprietaryDto, Proprietary.class);

        Proprietary proprietary = proprietaryService.updateProprietary(id, proprietaryRequest);

        ProprietaryDto proprietaryResponse = modelMapper.map(proprietary, ProprietaryDto.class);

        return ResponseEntity.ok().body(proprietaryResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProprietary(@PathVariable(name = "id") Long id){
        proprietaryService.deleteProprietary(id);
        return new ResponseEntity<String>("Proprietary deleted successfully", HttpStatus.OK);
    }

}
