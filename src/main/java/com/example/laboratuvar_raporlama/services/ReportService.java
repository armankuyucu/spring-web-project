package com.example.laboratuvar_raporlama.services;

import com.example.laboratuvar_raporlama.domain.Report;
import com.example.laboratuvar_raporlama.repositories.ReportRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.Date;

@Service
public class ReportService {
    private ReportRepository reportRepository;


    public ReportService(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    public void saveReportToDB(MultipartFile file, Report report) throws IOException {
//        report.setFileNumber(fileNumber);
//        report.setPatientName(patientName);
//        report.setPatientSurname(patientSurname);
//        report.setTrIdentityNumber(trIdentityNumber);
//        report.setTitle(title);
//        report.setDetails(details);
//        report.setDate(date);
        report.setPicture(Base64.getEncoder().encodeToString(file.getBytes()));
        reportRepository.save(report);
        System.out.println("GİRDİ!!!!");
    }
}
