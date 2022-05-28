package com.example.laboratuvar_raporlama.repositories;

import com.example.laboratuvar_raporlama.domains.Report;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository<Report, Long> {
}
