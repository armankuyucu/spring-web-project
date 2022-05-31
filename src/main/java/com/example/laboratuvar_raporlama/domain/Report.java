package com.example.laboratuvar_raporlama.domain;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "report")
public class Report {
    @Id @GeneratedValue
    private Long primaryKey;
    private Long fileNumber;
    private String patientName;
    private String patientSurname;
    private Long trIdentityNumber;
    private String title;
    private String details;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date date;
    @Lob
    @Column(columnDefinition="clob")
    private String picture;
    @ManyToOne(cascade = CascadeType.DETACH)
//    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "laborant_id", referencedColumnName = "primaryKey")
    private Laborant laborant;
    public Report(){

    }
    public Report(Long fileNumber, String patientName, String patientSurname, Long trIdentityNumber, String title, String details, Date date, String picture) {
        this.fileNumber = fileNumber;
        this.patientName = patientName;
        this.patientSurname = patientSurname;
        this.trIdentityNumber = trIdentityNumber;
        this.title = title;
        this.details = details;
        this.date = date;
        this.picture = picture;
    }

    public Long getFileNumber() {
        return fileNumber;
    }

    public void setFileNumber(Long fileNumber) {
        this.fileNumber = fileNumber;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientSurname() {
        return patientSurname;
    }

    public void setPatientSurname(String patientSurname) {
        this.patientSurname = patientSurname;
    }

    public Long getTrIdentityNumber() {
        return trIdentityNumber;
    }

    public void setTrIdentityNumber(Long trIdentityNumber) {
        this.trIdentityNumber = trIdentityNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Laborant getLaborant() {
        return laborant;
    }

    public void setLaborant(Laborant laborant) {
        this.laborant = laborant;
    }

    public void assignLaborant(Laborant laborant) {
        this.laborant = laborant;
    }

    public Long getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(Long primaryKey) {
        this.primaryKey = primaryKey;
    }
}
