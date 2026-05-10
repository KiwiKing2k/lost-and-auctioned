package com.proiect.lostandauctioned.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Licitatie {
    private String denumireObiect;
    private boolean finalizat;
    private List<Oferta> oferte;

    public Licitatie(String denumireObiect) {
        this.denumireObiect = denumireObiect;
        this.finalizat = false;
        this.oferte = new ArrayList<>();
    }

    public void adaugaOferta(Oferta oferta) {
        this.oferte.add(oferta);
    }

    public Optional<Oferta> getCeaMaiMareOferta() {
        return this.oferte.stream().max(Comparator.comparing(Oferta::getSuma));
    }

    // Getters and Setters
    public String getDenumireObiect() {
        return denumireObiect;
    }

    public void setDenumireObiect(String denumireObiect) {
        this.denumireObiect = denumireObiect;
    }

    public boolean isFinalizat() {
        return finalizat;
    }

    public void setFinalizat(boolean finalizat) {
        this.finalizat = finalizat;
    }

    public List<Oferta> getOferte() {
        return oferte;
    }

    public void setOferte(List<Oferta> oferte) {
        this.oferte = oferte;
    }
}
