package com.hellin.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hellin.demo.repository.PetRepository;
import org.springframework.http.ResponseEntity;
import com.hellin.demo.entity.Pet;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

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

     @RestController
     @RequestMapping("/pets")
    public PetController(PetRepository petRepository) {

        private final PetRepository repo;

        public PetController(PetRepository repo) {
            this.repo = petRepository;
        }

        this.petRepository = petRepository;
    }

    /*
    *  Este método devuelve el listado de Pets
    * @return List<pet> Información de cada mascota.
     */
    @GetMapping("/list")
    public List<Pet> Hello(){
       List<Pet> listpets = petRepository.findAll();
        return listpets;
    }

    @PutMapping("pet/{id}/adopt")
    public ResponseEntity<Void> adopt(@PathVariable Long id) {
        return repo.findById(id)        //1) Busca la mascotata por el ID
        .map(p -> {                     //2) Si la encuentra
            p.setAdopt(true);           //3) Cambia el estado de adopt a true
            repo.save(p);               //4) Guarda los cambios en la BD
            return ResponseEntity.noContent().build();  //5) Devuelve un 204
        })
        .orElseGet(() -> ResponseEntity.notFound().build()); //6) Si no la encuentra devuelve un 404
    }
}
