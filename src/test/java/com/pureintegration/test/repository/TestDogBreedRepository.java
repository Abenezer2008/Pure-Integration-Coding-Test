package com.pureintegration.test.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class TestDogBreedRepository {
    private DogBreedRepository dogBreedRepository;

    @Autowired
    public TestDogBreedRepository(DogBreedRepository dogBreedRepository){
        this.dogBreedRepository = dogBreedRepository;
    }

    @Test
    public void shouldPass(){
        Map<String, List<String>> response = dogBreedRepository.getDogBreedMap();

        assertNotNull(response);
        assertEquals(response.get("waterdog"),List.of("spanish"));
    }
}
