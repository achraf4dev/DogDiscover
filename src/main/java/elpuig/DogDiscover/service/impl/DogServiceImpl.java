package elpuig.DogDiscover.service.impl;

import elpuig.DogDiscover.model.Dog;
import elpuig.DogDiscover.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DogServiceImpl implements DogService {

    private final RestTemplate restTemplate;
    private final String API_URL = "https://api.thedogapi.com/v1/breeds";
    private final String IMAGE_URL = "https://cdn2.thedogapi.com/images/";

    @Autowired
    public DogServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Dog> getAllDogs() {
        Dog[] dogs = restTemplate.getForObject(API_URL, Dog[].class);
        return dogs != null ? Arrays.asList(dogs) : List.of();
    }

    @Override
    public Dog getDogById(int id) {
        return restTemplate.getForObject(API_URL + "/" + id, Dog.class);
    }

    @Override
    public List<Dog> getDogsByBreedGroup(String breedGroup) {
        Dog[] dogs = restTemplate.getForObject(API_URL, Dog[].class);
        if (dogs == null) {
            return List.of();
        }
        return Arrays.stream(dogs)
                .filter(dog -> dog.getBreed_group() != null && dog.getBreed_group().equalsIgnoreCase(breedGroup))
                .collect(Collectors.toList());
    }

    @Override
    public String getDogImageUrl(String referenceImageId) {
        return IMAGE_URL + referenceImageId + ".jpg";
    }
} 