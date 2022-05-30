package com.example.laboratuvar_raporlama.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "laborant")
public class Laborant {
    @Id @GeneratedValue
    private Long primaryKey;
    // Hastane Kimlik Numarası
    private String id;
    private String password;
    private String name;

    private String is_admin = "0";
    private String surname;
//    @OneToMany(targetEntity = Report.class, cascade = CascadeType.ALL)
//    @JoinColumn(name = "laborant_report_fk", referencedColumnName = "primaryKey")
    @OneToMany(mappedBy = "laborant")
    @JsonIgnore
    private Set<Report> reports = new HashSet<>();

    public Laborant(String id, String password, String name, String is_admin, String surname, Set<Report> reports) {
        this.id = id;
        this.is_admin = is_admin;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.reports = reports;
    }

    public Laborant() {

    }

    public String getId() {
        return id;
    }

    public void setId(String username) {
        this.id = username;
    }

    public String getIs_admin() {
        return is_admin;
    }

    public void setIs_admin(String is_admin) {
        this.is_admin = is_admin;
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

    public Set<Report> getReports() {
        return reports;
    }

    public void setReports(Set<Report> reportList) {
        this.reports = reportList;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
