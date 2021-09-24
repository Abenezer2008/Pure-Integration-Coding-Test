package com.pureintegration.test.service;

import com.pureintegration.test.dto.DogBreedDTO;
import com.pureintegration.test.repository.DogBreedRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.common.input.LineSeparatorDetector;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class TestDogBreedService {
    @Mock
    private DogBreedRepository dogBreedRepository;
    @InjectMocks
    private DogBreedServiceImpl dogBreedService;

    private Map<String, List<String>> mockBreed;
    private DogBreedDTO expectedDTO;

    @BeforeEach
    public void setup(){
        mockBreed = new TreeMap<>();
        mockBreed.put("breed1",List.of("Dog1","Dog2"));
        mockBreed.put("breed2",List.of("Dog3","Dog4"));

        expectedDTO = new DogBreedDTO(mockBreed,"success");
    }

    @Test
    public void shouldPass(){
        Mockito.when(dogBreedRepository.getDogBreedMap()).thenReturn(mockBreed);

        DogBreedDTO responseDTO  = dogBreedService.getAll();

        assertNotNull(responseDTO);
        assertEquals(expectedDTO,responseDTO);
    }

}
