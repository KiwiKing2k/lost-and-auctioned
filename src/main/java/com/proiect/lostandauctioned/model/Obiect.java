package com.proiect.lostandauctioned.model;

public class Obiect {
    private String denumire;
    private String descriere;
    private String poza;
    private Status status;
    private String locatie;

    public Obiect(String denumire, String descriere, String poza, Status status, String locatie) {
        this.denumire = denumire;
        this.descriere = descriere;
        this.poza = poza;
        this.status = status;
        this.locatie = locatie;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public String getPoza() {
        return poza;
    }

    public void setPoza(String poza) {
        this.poza = poza;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getLocatie() {
        return locatie;
    }

    public void setLocatie(String locatie) {
        this.locatie = locatie;
    }
}
