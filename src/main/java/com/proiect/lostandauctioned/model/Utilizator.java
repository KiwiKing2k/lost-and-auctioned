package com.proiect.lostandauctioned.model;

import java.time.LocalDate;

public class Utilizator {
    private String nume;
    private String prenume;
    private LocalDate dataNasterii;
    private String email;
    private String unitInv;
    private String functie;

    public Utilizator(String nume, String prenume, LocalDate dataNasterii, String email, String unitInv, String functie) {
        this.nume = nume;
        this.prenume = prenume;
        this.dataNasterii = dataNasterii;
        this.email = email;
        this.unitInv = unitInv;
        this.functie = functie;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public LocalDate getDataNasterii() {
        return dataNasterii;
    }

    public void setDataNasterii(LocalDate dataNasterii) {
        this.dataNasterii = dataNasterii;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUnitInv() {
        return unitInv;
    }

    public void setUnitInv(String unitInv) {
        this.unitInv = unitInv;
    }

    public String getFunctie() {
        return functie;
    }

    public void setFunctie(String functie) {
        this.functie = functie;
    }
}
