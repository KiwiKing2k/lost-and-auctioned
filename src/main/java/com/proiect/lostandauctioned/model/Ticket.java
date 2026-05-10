package com.proiect.lostandauctioned.model;

public class Ticket {
    private String descriere;
    private Utilizator utilizator;

    public Ticket(String descriere, Utilizator utilizator) {
        this.descriere = descriere;
        this.utilizator = utilizator;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public Utilizator getUtilizator() {
        return utilizator;
    }

    public void setUtilizator(Utilizator utilizator) {
        this.utilizator = utilizator;
    }
}
