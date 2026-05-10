package com.proiect.lostandauctioned.service;

import com.proiect.lostandauctioned.model.Licitatie;
import com.proiect.lostandauctioned.model.Oferta;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LicitatieService {

    private final List<Licitatie> licitatiiActive = new ArrayList<>();
    private final ObiectService obiectService;

    public LicitatieService(ObiectService obiectService) {
        this.obiectService = obiectService;
    }

    public Licitatie createLicitatie(String denumireObiect) {
        // First, move the object to the IN_LICITATIE state
        obiectService.sendToAuction(denumireObiect);
        // Then, create a new auction for it
        Licitatie licitatie = new Licitatie(denumireObiect);
        licitatiiActive.add(licitatie);
        return licitatie;
    }

    public Optional<Licitatie> getLicitatieByDenumireObiect(String denumireObiect) {
        return licitatiiActive.stream()
            .filter(l -> l.getDenumireObiect().equals(denumireObiect) && !l.isFinalizat())
            .findFirst();
    }

    public Optional<Licitatie> adaugaOferta(String denumireObiect, Oferta oferta) {
        Optional<Licitatie> licitatieOpt = getLicitatieByDenumireObiect(denumireObiect);
        licitatieOpt.ifPresent(licitatie -> licitatie.adaugaOferta(oferta));
        return licitatieOpt;
    }

    public List<Licitatie> getLicitatiiActive() {
        return licitatiiActive.stream().filter(l -> !l.isFinalizat()).collect(Collectors.toList());
    }

    public void finishLicitatie(String denumireObiect) {
        Optional<Licitatie> licitatieOpt = getLicitatieByDenumireObiect(denumireObiect);
        licitatieOpt.ifPresent(licitatie -> {
            licitatie.setFinalizat(true);
            // Also update the main object's status
            obiectService.finishAuction(denumireObiect);
        });
    }
}
