package com.example.laboratuvar_raporlama.repositories;

import com.example.laboratuvar_raporlama.domain.Report;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Blob;

public interface ReportRepository extends JpaRepository<Report, Long> {
    Report findAllByPatientNameStartingWith(String patientName);

    Report findAllByPatientSurnameStartingWith(String patientSurname);
    Report findAllByTrIdentityNumberStartingWith(Long trIdentityNumber);
    Report getPictureByFileNumberStartingWith(Long fileNumber);
}
