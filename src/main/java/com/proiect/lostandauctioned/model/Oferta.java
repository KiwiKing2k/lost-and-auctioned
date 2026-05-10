package com.proiect.lostandauctioned.model;

public class Oferta {
    private String denumire;
    private boolean esteMaxim;
    private Utilizator licitant;

    public Oferta(String denumire, boolean esteMaxim, Utilizator licitant) {
        this.denumire = denumire;
        this.esteMaxim = esteMaxim;
        this.licitant = licitant;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public boolean isEsteMaxim() {
        return esteMaxim;
    }

    public void setEsteMaxim(boolean esteMaxim) {
        this.esteMaxim = esteMaxim;
    }

    public Utilizator getLicitant() {
        return licitant;
    }

    public void setLicitant(Utilizator licitant) {
        this.licitant = licitant;
    }
}
