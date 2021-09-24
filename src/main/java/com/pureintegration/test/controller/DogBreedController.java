package com.pureintegration.test.controller;

import com.pureintegration.test.service.DobBreedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/breeds")
public class DogBreedController {
    private DobBreedService dobBreedService;

    @Autowired
    public DogBreedController(DobBreedService dobBreedService){
        this.dobBreedService = dobBreedService;
    }

    @GetMapping("/list/all")
    public ResponseEntity<?> getBreeds(){
        return new ResponseEntity<>(dobBreedService.getAll().getDogBreedResponse(), HttpStatus.OK);
    }
}
