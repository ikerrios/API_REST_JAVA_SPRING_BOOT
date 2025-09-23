package com.hellin.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hellin.demo.repository.PetRepository;

import com.hellin.demo.entity.Pet;
@RestController
public class PetController {

    private PetRepository petRepository;
    public PetController(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @GetMapping("/pets")
    public List<Pet> Hello(){
       List<Pet> listpets = petRepository.findAll();
        return listpets;
    }
}
