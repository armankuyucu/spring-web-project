package com.example.laboratuvar_raporlama.controllers;

import com.example.laboratuvar_raporlama.domains.Report;
import com.example.laboratuvar_raporlama.repositories.ReportRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RaporController {
    private final ReportRepository reportRepository;
    public RaporController(ReportRepository reportRepository){
        this.reportRepository = reportRepository;
    }
    @GetMapping("add-report")
    public String raporEklemeGetController(Model model){
        model.addAttribute("reports", reportRepository.findAll());
        model.addAttribute("report",new Report());
        return "add-report";
    }

    @PostMapping("add-report")
    public String raporEklemePostController(Report report){
        reportRepository.save(report);
        System.out.println("fileNumber: " + report.getFileNumber() +
                            " patientName: " + report.getPatientName() +
                            " patientSurname: " + report.getPatientSurname() +
                            " trIdentityNumber: " + report.getTrIdentityNumber() +
                            " title: " + report.getTitle() +
                            " details: " + report.getDetails() +
                            " title: " + report.getTitle() +
                            " date: " + report.getDate() +
                            " picture: " + report.getPicture());
        return "add-report";
    }
}
