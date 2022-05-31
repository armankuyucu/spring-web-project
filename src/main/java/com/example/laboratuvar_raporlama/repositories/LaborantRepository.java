package com.example.laboratuvar_raporlama.repositories;

import com.example.laboratuvar_raporlama.domain.Laborant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public interface LaborantRepository extends JpaRepository<Laborant, Long> {
    Laborant findById(String id);
    Laborant findByName(String name);
    Laborant findBySurname(String surname);
}
