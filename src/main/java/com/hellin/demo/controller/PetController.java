package com.hellin.demo.controller;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import com.hellin.demo.entity.Pet;
import com.hellin.demo.repository.PetRepository;
import org.springframework.web.bind.annotation.PostMapping;




@RestController
@RequestMapping("/pet")
/**
 * En este controlador se espone los enpoint referentes a Pets 
 * @version 1.0
 * @author Iker Ríos
 */
public class PetController {


    private PetRepository petRepository;

    public PetController(PetRepository petRepository) {
        this.petRepository = petRepository;
    }  

    /**
     * Este method devuelve el listado de mascotas
     * @return List<Pet> informacion de cada mascota
     */

    @GetMapping ("/list")
    public List<Pet> hello() {
        return petRepository.findAll();
        
    }

    @PostMapping("/adopt/{id}")
    // RedirectView --> redirigir al navegador a otra URL desde un controlador.
    public Pet adopt(@PathVariable long id) {
        Pet pet = petRepository.findById(id).get();

        pet.setAdopt(true);
        return petRepository.save(pet);
        
        
    }

}