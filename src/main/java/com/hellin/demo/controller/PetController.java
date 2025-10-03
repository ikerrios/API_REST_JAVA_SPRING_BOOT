package com.hellin.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hellin.demo.repository.PetRepository;

import com.hellin.demo.entity.Pet;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/pets")
/**
 * En este controlador se exponen todos los endpoints referentes a Pets {{@link Pet}}
 * @version 1.0
 * @author Iker
 */
public class PetController {

    private PetRepository petRepository;

    /*
     * Constructor del controlador
     * @param petRepository Repositorio para consultar en BD
     */
    public PetController(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    /*
    *  Este método devuelve el listado de Pets
    * @return List od @linl{Pet} Información de cada mascota.
     */
    @GetMapping("/list")
    public List<Pet> Hello(){
       List<Pet> listpets = petRepository.findAll();
        return listpets;
    }

    @PostMapping("/adopt/{id}")
    public Pet adopt(@PathVariable long id) {
       Pet pet= petRepository.findById(id).get();
       pet.setAdopt(true);
       return petRepository.save(pet);
    }    
}
