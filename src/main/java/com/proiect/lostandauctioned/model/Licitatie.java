package com.proiect.lostandauctioned.model;

import java.util.List;

public class Licitatie {
    private String denumire;
    private Obiect obiect;
    private boolean finalizat;
    private List<Oferta> licitatii;

    public Licitatie(String denumire, Obiect obiect, boolean finalizat, List<Oferta> licitatii) {
        this.denumire = denumire;
        this.obiect = obiect;
        this.finalizat = finalizat;
        this.licitatii = licitatii;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public Obiect getObiect() {
        return obiect;
    }

    public void setObiect(Obiect obiect) {
        this.obiect = obiect;
    }

    public boolean isFinalizat() {
        return finalizat;
    }

    public void setFinalizat(boolean finalizat) {
        this.finalizat = finalizat;
    }

    public List<Oferta> getLicitatii() {
        return licitatii;
    }

    public void setLicitatii(List<Oferta> licitatii) {
        this.licitatii = licitatii;
    }
}
