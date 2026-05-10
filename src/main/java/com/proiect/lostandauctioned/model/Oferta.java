package com.proiect.lostandauctioned.model;

public class Oferta {
    private String numeOfertant;
    private double suma;

    public Oferta(String numeOfertant, double suma) {
        this.numeOfertant = numeOfertant;
        this.suma = suma;
    }

    public String getNumeOfertant() {
        return numeOfertant;
    }

    public void setNumeOfertant(String numeOfertant) {
        this.numeOfertant = numeOfertant;
    }

    public double getSuma() {
        return suma;
    }

    public void setSuma(double suma) {
        this.suma = suma;
    }
}
