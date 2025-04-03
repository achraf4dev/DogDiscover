package elpuig.DogDiscover.service;

import elpuig.DogDiscover.model.Dog;
import java.util.List;

public interface DogService {
    List<Dog> getAllDogs();
    Dog getDogById(int id);
    List<Dog> getDogsByBreedGroup(String breedGroup);
    String getDogImageUrl(String referenceImageId);
} 