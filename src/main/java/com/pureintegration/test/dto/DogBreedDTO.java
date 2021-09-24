package com.pureintegration.test.dto;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DogBreedDTO that = (DogBreedDTO) o;
        return Objects.equals(dogBreedResponse, that.dogBreedResponse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dogBreedResponse);
    }
}
