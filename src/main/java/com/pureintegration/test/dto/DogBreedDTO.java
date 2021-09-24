package com.pureintegration.test.dto;

import java.util.HashMap;
import java.util.Map;

public class DogBreedDTO {
    private Map<String, Object> dogBreedResponse;

    public DogBreedDTO(Object message, String status) {
        this.dogBreedResponse = new HashMap<>();
        dogBreedResponse.put("message",message);
        dogBreedResponse.put("status",status);
    }

    public Map<String, Object> getDogBreedResponse() {
        return dogBreedResponse;
    }
}
