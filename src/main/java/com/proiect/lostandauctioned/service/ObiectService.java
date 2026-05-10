package com.proiect.lostandauctioned.service;

import com.proiect.lostandauctioned.model.Obiect;
import com.proiect.lostandauctioned.model.Status;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ObiectService {

    private final List<Obiect> obiecte = new ArrayList<>();

    // --- User-facing methods ---

    public Obiect createObiect(Obiect obiect) {
        obiect.setStatus(Status.RAPORTAT);
        obiecte.add(obiect);
        return obiect;
    }

    public List<Obiect> searchObiecte(String keyword) {
        return obiecte.stream()
                .filter(obiect -> obiect.getStatus() == Status.IN_CAUTARE && 
                                 (obiect.getDenumire().contains(keyword) || obiect.getDescriere().contains(keyword)))
                .collect(Collectors.toList());
    }

    public Optional<Obiect> revendicareObiect(String denumire) {
        Optional<Obiect> obiectOptional = getObiectByDenumire(denumire);
        obiectOptional.ifPresent(obiect -> {
            if (obiect.getStatus() == Status.IN_CAUTARE) {
                obiect.setStatus(Status.RETURNAT);
            }
        });
        return obiectOptional;
    }

    // --- Admin-only methods ---

    public List<Obiect> getReportedItems() {
        return obiecte.stream().filter(obiect -> obiect.getStatus() == Status.RAPORTAT).collect(Collectors.toList());
    }

    public Optional<Obiect> approveObiect(String denumire) {
        Optional<Obiect> obiectOptional = getObiectByDenumire(denumire);
        obiectOptional.ifPresent(obiect -> obiect.setStatus(Status.IN_CAUTARE));
        return obiectOptional;
    }

    public void rejectObiect(String denumire) {
        obiecte.removeIf(obiect -> obiect.getDenumire().equals(denumire) && obiect.getStatus() == Status.RAPORTAT);
    }

    public List<Obiect> getClaimedItems() {
        return obiecte.stream().filter(obiect -> obiect.getStatus() == Status.RETURNAT).collect(Collectors.toList());
    }

    public void confirmReturn(String denumire) {
        obiecte.removeIf(obiect -> obiect.getDenumire().equals(denumire) && obiect.getStatus() == Status.RETURNAT);
    }

    // --- Auction methods (Admin) ---

    public List<Obiect> getAuctionableItems() {
        // For simplicity, any item that is searchable can be sent to auction by an admin
        return obiecte.stream().filter(obiect -> obiect.getStatus() == Status.IN_CAUTARE).collect(Collectors.toList());
    }

    public Optional<Obiect> sendToAuction(String denumire) {
        Optional<Obiect> obiectOptional = getObiectByDenumire(denumire);
        obiectOptional.ifPresent(obiect -> obiect.setStatus(Status.IN_LICITATIE));
        return obiectOptional;
    }

    public List<Obiect> getItemsInAuction() {
        return obiecte.stream().filter(obiect -> obiect.getStatus() == Status.IN_LICITATIE).collect(Collectors.toList());
    }

    public void finishAuction(String denumire) {
        // Finishing an auction removes the item from the system in this simple version
        obiecte.removeIf(obiect -> obiect.getDenumire().equals(denumire) && obiect.getStatus() == Status.IN_LICITATIE);
    }
    
    public Optional<Obiect> getObiectByDenumire(String denumire) {
        return obiecte.stream().filter(obiect -> obiect.getDenumire().equals(denumire)).findFirst();
    }
    
    public List<Obiect> getObiecte() {
        return new ArrayList<>(obiecte);
    }
}
