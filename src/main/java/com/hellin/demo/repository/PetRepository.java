package com.hellin.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hellin.demo.entity.Pet;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long>{
    
}

