package com.example.laboratuvar_raporlama.controllers;

import com.example.laboratuvar_raporlama.domain.Laborant;
import com.example.laboratuvar_raporlama.domain.Report;
import com.example.laboratuvar_raporlama.dto.SearchDto;
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
    public String IndexGetMethod(Model model) {
        List<Report> reports = reportRepository.findAll();
        model.addAttribute("reports", reports);
        model.addAttribute("report", new Report());
        model.addAttribute("searchDto", new SearchDto());
        return "index";
    }

    @PostMapping("")
    public String IndexPostMethod(Model model, Report report, SearchDto searchDto) {
        System.out.println("selectValue: " + searchDto.getSelectValue() + " ad: " + report.getPatientName() +
                " soyad: " + report.getPatientSurname() + " id: " + report.getTrIdentityNumber());
        model.addAttribute("reports", reportRepository.findAll());
        switch (searchDto.getSelectValue()) {
            case "Hasta Adı":
                //indicates whether the search is report related or laborant related
                model.addAttribute("indicator", "0");
                model.addAttribute("laborants", laborantRepository.findAll());
                model.addAttribute("reports", reportRepository.findAllByPatientNameStartingWithIgnoreCase(searchDto.getInputValue()));
                break;
            case "Hasta Soyadı":
                model.addAttribute("indicator", "0");
                model.addAttribute("laborants", laborantRepository.findAll());
                model.addAttribute("reports", reportRepository.findAllByPatientSurnameStartingWith(searchDto.getInputValue()));
                break;
            case "Hasta Kimlik Numarası":
                model.addAttribute("indicator", "0");
                model.addAttribute("laborants", laborantRepository.findAll());
                model.addAttribute("reports", reportRepository.findAllByTrIdentityNumberStartingWith(Long.parseLong(searchDto.getInputValue())));
                break;
            case "Laborant Adı":
                model.addAttribute("indicator", "1");
                model.addAttribute("laborant", laborantRepository.findAllByNameStartingWith(searchDto.getInputValue()));
//                model.addAttribute("laborant",laborantRepository.findAllByNameStartingWith(searchDto.getInputValue()));

//                model.addAttribute("reports",laborantRepository.findAllByNameStartingWith(searchDto.getInputValue()));
                break;
            case "Laborant Soyadı":
                model.addAttribute("indicator", "1");
                model.addAttribute("laborant", laborantRepository.findAllBySurnameStartingWith(searchDto.getInputValue()));
//                model.addAttribute("reports",laborantRepository.findAllBySurnameStartingWith(searchDto.getInputValue()));
                break;
            default:
//                model.addAttribute("laborants",laborantRepository.findAll());
                model.addAttribute("reports", reportRepository.findAll());
        }
        return "results";
    }

    @GetMapping("sign-up")
    public String SignUpGetMethod(Model model) {
        model.addAttribute("laborant", new Laborant());
        for (Laborant laborant : laborantRepository.findAll()) {
            if(laborant.getIs_admin() == "1"){
                model.addAttribute("is_admin","1");
                return "sign-up";
            }
        }
        model.addAttribute("is_admin","0");
        return "sign-up";
    }

    @PostMapping("sign-up")
    public String SignUpPostMethod(Laborant laborant) {
        laborant.setPassword(new BCryptPasswordEncoder().encode(laborant.getPassword()));
        laborantRepository.save(laborant);
        System.out.println("Id: " + laborant.getId() + "Is_admin: " + laborant.getIs_admin() +  "Ad: " + laborant.getName() + " Soyad: " + laborant.getSurname() + " Şifre: " + laborant.getPassword());
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }
}
