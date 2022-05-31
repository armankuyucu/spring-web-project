package com.example.laboratuvar_raporlama.repositories;

import com.example.laboratuvar_raporlama.domain.Laborant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LaborantRepository extends JpaRepository<Laborant, Long> {
    Laborant findById(String id);
    List<Laborant> findAllByNameStartingWith(String name);
    List<Laborant> findAllBySurnameStartingWith(String surname);
}
