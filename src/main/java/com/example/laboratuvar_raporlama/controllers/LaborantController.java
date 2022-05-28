package com.example.laboratuvar_raporlama.controllers;

import com.example.laboratuvar_raporlama.domains.Laborant;
import com.example.laboratuvar_raporlama.domains.Report;
import com.example.laboratuvar_raporlama.repositories.LaborantRepository;
import com.example.laboratuvar_raporlama.repositories.ReportRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class LaborantController {
    private final LaborantRepository laborantRepository;
    private final ReportRepository reportRepository;

    public LaborantController(LaborantRepository laborantRepository, ReportRepository reportRepository) {
        this.laborantRepository = laborantRepository;
        this.reportRepository = reportRepository;
    }

    @GetMapping("")
    public String Index(Model model) {
        List<Report> reports = reportRepository.findAll();
        model.addAttribute("reports", reports);
        model.addAttribute("report", new Report());
        return "index";
    }

    @GetMapping("sign-up")
    public String SignUpGetController(Model model) {
        model.addAttribute("laborant", new Laborant());
        return "sign-up";
    }

    @PostMapping("sign-up")
    public String SignUpPostController(Laborant laborant) {
        laborant.setPassword(new BCryptPasswordEncoder().encode(laborant.getPassword()));
        laborantRepository.save(laborant);
        System.out.println("Id: " +  laborant.getId() + " Ad: " +laborant.getName() + " Soyad: " + laborant.getSurname() + " Şifre: " + laborant.getPassword());
        return "redirect:/login";
    }

}
