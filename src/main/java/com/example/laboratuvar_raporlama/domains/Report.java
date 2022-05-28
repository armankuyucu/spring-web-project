package com.example.laboratuvar_raporlama.domains;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import java.sql.Blob;
import java.util.Date;

@Entity
@Table(name = "report")
public class Report {
    @Id
    private Long fileNumber;
    private String patientName;
    private String patientSurname;
    private Long trIdentityNumber;
    private String title;
    private String details;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date date;
    @Lob
    private byte[] picture;

    public Report(){

    }
    public Report(Long fileNumber, String patientName, String patientSurname, Long trIdentityNumber, String title, String details, Date date, byte[] picture) {
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

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }
}
