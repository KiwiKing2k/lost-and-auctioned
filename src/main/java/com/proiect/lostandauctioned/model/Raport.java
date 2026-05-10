package com.proiect.lostandauctioned.model;

public class Raport {
    private String descriere;
    private String locatie;
    private String poza;

    public Raport(String descriere, String locatie, String poza) {
        this.descriere = descriere;
        this.locatie = locatie;
        this.poza = poza;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public String getLocatie() {
        return locatie;
    }

    public void setLocatie(String locatie) {
        this.locatie = locatie;
    }

    public String getPoza() {
        return poza;
    }

    public void setPoza(String poza) {
        this.poza = poza;
    }
}
