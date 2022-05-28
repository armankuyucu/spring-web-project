package com.example.laboratuvar_raporlama.domains;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "laborant")
public class Laborant {
    @Id @GeneratedValue
    private Long primaryKey;

    // Hastane Kimlik Numarası
    private String id;
    private String password;
    private String name;

    private String surname;
    @OneToMany(targetEntity = Report.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "laborant_report_fk", referencedColumnName = "primaryKey")
    private List<Report> reportList;

    public Laborant(String id, String password, String name, String surname, List<Report> reportList) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.reportList = reportList;
    }

    public Laborant() {

    }

    public String getId() {
        return id;
    }

    public void setId(String username) {
        this.id = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<Report> getReportList() {
        return reportList;
    }

    public void setReportList(List<Report> reportList) {
        this.reportList = reportList;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
