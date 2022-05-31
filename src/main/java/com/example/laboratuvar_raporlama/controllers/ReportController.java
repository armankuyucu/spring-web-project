package com.example.laboratuvar_raporlama.controllers;

import com.example.laboratuvar_raporlama.domain.Laborant;
import com.example.laboratuvar_raporlama.domain.Report;
import com.example.laboratuvar_raporlama.repositories.LaborantRepository;
import com.example.laboratuvar_raporlama.repositories.ReportRepository;
import com.example.laboratuvar_raporlama.services.ReportService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.Optional;

@Controller
public class ReportController {
    private final ReportRepository reportRepository;
    private final LaborantRepository laborantRepository;
    private final ReportService reportService;

    public ReportController(ReportRepository reportRepository, LaborantRepository laborantRepository, ReportService reportService) {
        this.reportRepository = reportRepository;
        this.laborantRepository = laborantRepository;
        this.reportService = reportService;
    }

    @GetMapping("add-report")
    public String addReportGetController(Model model) {
        model.addAttribute("reports", reportRepository.findAll());
        model.addAttribute("report", new Report());
        return "add-report";
    }

    @PostMapping("add-report")
    public String addReportPostController(Report report, @RequestParam("file") MultipartFile file) throws IOException {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        Laborant laborant = laborantRepository.findById(username);
//        report.assignLaborant(laborant);
        reportService.saveReportToDB(file, report);
        return "redirect:/";
    }

    @GetMapping("/picture/")
    public String getPicture(@RequestParam("picture_id") Long picture_id, Model model) {
        Optional<Report> report = reportRepository.findById(picture_id);
        if (report.isPresent())
            model.addAttribute("report", report.get());
        else
            System.out.println("EMPTY!!!!!!!!!!!");
        return "/picture";
    }

    @GetMapping("/delete/")
    public String deleteReport(@RequestParam("id") Long id, Model model) {
        // Get currently logged in user
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        Laborant laborant = laborantRepository.findById(username);

        if (laborant.getIs_admin().equals("1")) {
            reportRepository.deleteById(id);
            model.addAttribute("result", "1");
            return "redirect:/";
        } else {
            model.addAttribute("result", "0");
            return "not_authorized";
        }
    }

    @GetMapping("/update")
    public String updateReportGet(@RequestParam("id") Long fileNumber, Model model){
        model.addAttribute("report", reportRepository.getById(fileNumber));
        return "/update";
    }

    @PostMapping("/update")
    public String updateReportPost(Report report, @RequestParam("indicator") String indicator,
                                   @RequestParam("id") Long primaryKey){
        if(indicator.equals("fileNumber")){
            report.setPrimaryKey(reportRepository.getById(primaryKey).getPrimaryKey());
            report.setFileNumber(report.getFileNumber());
            report.setPatientName(reportRepository.getById(primaryKey).getPatientName());
            report.setPatientSurname(reportRepository.getById(primaryKey).getPatientSurname());
            report.setTrIdentityNumber(reportRepository.getById(primaryKey).getTrIdentityNumber());
            report.setTitle(reportRepository.getById(primaryKey).getTitle());
            report.setDetails(reportRepository.getById(primaryKey).getDetails());
            report.setDate(reportRepository.getById(primaryKey).getDate());
            report.setPicture(reportRepository.getById(primaryKey).getPicture());
//            report.setLaborant(reportRepository.getById(primaryKey).getLaborant());
            reportRepository.save(report);
        }
        else if(indicator.equals("patientName")){
            report.setPrimaryKey(reportRepository.getById(primaryKey).getPrimaryKey());
            report.setFileNumber(reportRepository.getById(primaryKey).getFileNumber());
            report.setPatientName(report.getPatientName());
            report.setPatientSurname(reportRepository.getById(primaryKey).getPatientSurname());
            report.setTrIdentityNumber(reportRepository.getById(primaryKey).getTrIdentityNumber());
            report.setTitle(reportRepository.getById(primaryKey).getTitle());
            report.setDetails(reportRepository.getById(primaryKey).getDetails());
            report.setDate(reportRepository.getById(primaryKey).getDate());
            report.setPicture(reportRepository.getById(primaryKey).getPicture());
//            report.setLaborant(reportRepository.getById(primaryKey).getLaborant());
            reportRepository.save(report);
        }
        else if(indicator.equals("patientSurname")){
            report.setPrimaryKey(reportRepository.getById(primaryKey).getPrimaryKey());
            report.setFileNumber(reportRepository.getById(primaryKey).getFileNumber());
            report.setPatientName(reportRepository.getById(primaryKey).getPatientName());
            report.setPatientSurname(report.getPatientSurname());
            report.setTrIdentityNumber(reportRepository.getById(primaryKey).getTrIdentityNumber());
            report.setTitle(reportRepository.getById(primaryKey).getTitle());
            report.setDetails(reportRepository.getById(primaryKey).getDetails());
            report.setDate(reportRepository.getById(primaryKey).getDate());
            report.setPicture(reportRepository.getById(primaryKey).getPicture());
//            report.setLaborant(reportRepository.getById(primaryKey).getLaborant());
            reportRepository.save(report);
        }
        else if(indicator.equals("trIdentityNumber")){
            report.setPrimaryKey(reportRepository.getById(primaryKey).getPrimaryKey());
            report.setFileNumber(reportRepository.getById(primaryKey).getFileNumber());
            report.setPatientName(reportRepository.getById(primaryKey).getPatientName());
            report.setPatientSurname(reportRepository.getById(primaryKey).getPatientSurname());
            report.setTrIdentityNumber(report.getTrIdentityNumber());
            report.setTitle(reportRepository.getById(primaryKey).getTitle());
            report.setDetails(reportRepository.getById(primaryKey).getDetails());
            report.setDate(reportRepository.getById(primaryKey).getDate());
            report.setPicture(reportRepository.getById(primaryKey).getPicture());
//            report.setLaborant(reportRepository.getById(primaryKey).getLaborant());
            reportRepository.save(report);
        }
        else if(indicator.equals("title")){
            report.setPrimaryKey(reportRepository.getById(primaryKey).getPrimaryKey());
            report.setFileNumber(reportRepository.getById(primaryKey).getFileNumber());
            report.setPatientName(reportRepository.getById(primaryKey).getPatientName());
            report.setPatientSurname(reportRepository.getById(primaryKey).getPatientSurname());
            report.setTrIdentityNumber(reportRepository.getById(primaryKey).getTrIdentityNumber());
            report.setTitle(report.getTitle());
            report.setDetails(reportRepository.getById(primaryKey).getDetails());
            report.setDate(reportRepository.getById(primaryKey).getDate());
            report.setPicture(reportRepository.getById(primaryKey).getPicture());
//            report.setLaborant(reportRepository.getById(primaryKey).getLaborant());
            reportRepository.save(report);
        }
        else if(indicator.equals("details")){
            report.setPrimaryKey(reportRepository.getById(primaryKey).getPrimaryKey());
            report.setFileNumber(reportRepository.getById(primaryKey).getFileNumber());
            report.setPatientName(reportRepository.getById(primaryKey).getPatientName());
            report.setPatientSurname(reportRepository.getById(primaryKey).getPatientSurname());
            report.setTrIdentityNumber(reportRepository.getById(primaryKey).getTrIdentityNumber());
            report.setTitle(reportRepository.getById(primaryKey).getTitle());
            report.setDetails(report.getDetails());
            report.setDate(reportRepository.getById(primaryKey).getDate());
            report.setPicture(reportRepository.getById(primaryKey).getPicture());
//            report.setLaborant(reportRepository.getById(primaryKey).getLaborant());
            reportRepository.save(report);
        }
        else if(indicator.equals("date")){
            report.setPrimaryKey(reportRepository.getById(primaryKey).getPrimaryKey());
            report.setFileNumber(reportRepository.getById(primaryKey).getFileNumber());
            report.setPatientName(reportRepository.getById(primaryKey).getPatientName());
            report.setPatientSurname(reportRepository.getById(primaryKey).getPatientSurname());
            report.setTrIdentityNumber(reportRepository.getById(primaryKey).getTrIdentityNumber());
            report.setTitle(reportRepository.getById(primaryKey).getTitle());
            report.setDetails(reportRepository.getById(primaryKey).getDetails());
            report.setDate(report.getDate());
            report.setPicture(reportRepository.getById(primaryKey).getPicture());
//            report.setLaborant(reportRepository.getById(primaryKey).getLaborant());
            reportRepository.save(report);
        }
        return "redirect:/";
    }
    @PostMapping("/update-picture")
    public String updateReportPicture(Report report,@RequestParam("file") MultipartFile file,
                                      @RequestParam("id") Long primaryKey) throws IOException {
        report.setPrimaryKey(reportRepository.getById(primaryKey).getPrimaryKey());
        report.setFileNumber(reportRepository.getById(primaryKey).getFileNumber());
        report.setPatientName(reportRepository.getById(primaryKey).getPatientName());
        report.setPatientSurname(reportRepository.getById(primaryKey).getPatientSurname());
        report.setTrIdentityNumber(reportRepository.getById(primaryKey).getTrIdentityNumber());
        report.setTitle(reportRepository.getById(primaryKey).getTitle());
        report.setDetails(reportRepository.getById(primaryKey).getDetails());
        report.setDate(reportRepository.getById(primaryKey).getDate());
//            report.setLaborant(reportRepository.getById(primaryKey).getLaborant());
        report.setPicture(Base64.getEncoder().encodeToString(file.getBytes()));
        reportRepository.save(report);
        return "redirect:/";
    }


}
