package com.pureintegration.test.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class DogBreedRepository {
    @Value("classpath:/data/apidata.json")
    private Resource resource;
    private Map<String, List<String >> dogBreedMap;
    private ObjectMapper objectMapper;

    @PostConstruct
    public void loadData() throws IOException {
        InputStream inputStream = resource.getInputStream();
        objectMapper = new ObjectMapper();
        dogBreedMap = objectMapper.readValue(inputStream, HashMap.class);
    }

    public Map<String, List<String>> getDogBreedMap() {
        return dogBreedMap;
    }
}
