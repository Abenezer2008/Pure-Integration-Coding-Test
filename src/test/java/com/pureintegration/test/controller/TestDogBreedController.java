package com.pureintegration.test.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pureintegration.test.dto.DogBreedDTO;
import com.pureintegration.test.service.DogBreedServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@WebMvcTest(DogBreedController.class)
public class TestDogBreedController {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private DogBreedController dogBreedController;
    @MockBean
    private DogBreedServiceImpl dogBreedService;

    private ObjectMapper objectMapper;

    private DogBreedDTO expectedDTO;

    @BeforeEach
    public void setup(){
        objectMapper = new ObjectMapper();
        Map<String , List<String>> mockBreed = new TreeMap<>();

        mockBreed.put("breed1",List.of("Dog1","Dog2"));
        mockBreed.put("breed2",List.of("Dog3","Dog4"));

        expectedDTO = new DogBreedDTO(mockBreed,"success");
    }

    @Test
    public void mvcShouldPass() throws Exception {
        Mockito.when(dogBreedService.getAll()).thenReturn(expectedDTO);

        mockMvc.perform(get("/api/breeds/list/all")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(expectedDTO))).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void responseStatusShouldPass(){
        Mockito.when(dogBreedService.getAll()).thenReturn(expectedDTO);

        ResponseEntity responseEntity = dogBreedController.getBreeds();

        assertNotNull(responseEntity);
        assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void responseBodyShouldPass(){
        Mockito.when(dogBreedService.getAll()).thenReturn(expectedDTO);

        ResponseEntity responseEntity = dogBreedController.getBreeds();

        assertNotNull(responseEntity);
        HashMap response = (HashMap) responseEntity.getBody();
        assertEquals(response,expectedDTO.getDogBreedResponse());
    }
}
