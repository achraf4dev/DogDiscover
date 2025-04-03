package elpuig.DogDiscover.controller;

import elpuig.DogDiscover.model.Dog;
import elpuig.DogDiscover.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/dogs")
public class DogController {

    private final DogService dogService;

    @Autowired
    public DogController(DogService dogService) {
        this.dogService = dogService;
    }

    @GetMapping
    public String getAllDogs(Model model) {
        List<Dog> dogs = dogService.getAllDogs();
        model.addAttribute("dogs", dogs);
        return "dogs/list";
    }

    @GetMapping("/{id}")
    public String getDogById(@PathVariable int id, Model model) {
        Dog dog = dogService.getDogById(id);
        if (dog != null && dog.getReference_image_id() != null) {
            dog.setReference_image_id(dogService.getDogImageUrl(dog.getReference_image_id()));
        }
        model.addAttribute("dog", dog);
        return "dogs/detail";
    }

    @GetMapping("/breed-group")
    public String getDogsByBreedGroup(@RequestParam String breedGroup, Model model) {
        List<Dog> dogs = dogService.getDogsByBreedGroup(breedGroup);
        model.addAttribute("dogs", dogs);
        model.addAttribute("breedGroup", breedGroup);
        return "dogs/list";
    }
} 