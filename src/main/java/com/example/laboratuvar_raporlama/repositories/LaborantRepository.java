package com.example.laboratuvar_raporlama.repositories;

import com.example.laboratuvar_raporlama.domain.Laborant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LaborantRepository extends JpaRepository<Laborant, Long> {
    Laborant findById(String id);
    Laborant findAllByNameStartingWith(String name);
    Laborant findAllBySurnameStartingWith(String surname);

//    Laborant findByNameStartingWith(String inputValue);
//
//    Laborant findBySurnameStartingWith(String inputValue);
}
