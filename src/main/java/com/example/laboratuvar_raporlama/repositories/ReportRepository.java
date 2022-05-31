package com.example.laboratuvar_raporlama.repositories;

import com.example.laboratuvar_raporlama.domain.Report;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Blob;
import java.util.List;

public interface ReportRepository extends JpaRepository<Report, Long> {
    List<Report> findAllByPatientNameStartingWithIgnoreCase(String patientName);
    List<Report> findAllByPatientSurnameStartingWithIgnoreCase(String patientSurname);
    List<Report> findAllByLaborant_NameStartingWithIgnoreCase(String name);
    List<Report> findAllByLaborant_SurnameStartingWithIgnoreCase(String surname);

    Report findByTrIdentityNumber(Long trIdentityNumber);

}
