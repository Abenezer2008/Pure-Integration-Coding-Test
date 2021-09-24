package com.pureintegration.test.service;

import com.pureintegration.test.dto.DogBreedDTO;
import com.pureintegration.test.repository.DogBreedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DogBreedServiceImpl implements DobBreedService{
    private DogBreedRepository dogBreedRepository;

    @Autowired
    public DogBreedServiceImpl(DogBreedRepository dogBreedRepository){
        this.dogBreedRepository = dogBreedRepository;
    }

    @Override
    public DogBreedDTO getAll() {
        return new DogBreedDTO(dogBreedRepository.getDogBreedMap(),"success");
    }
}
