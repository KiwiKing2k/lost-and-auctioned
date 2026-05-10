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

    public List<Obiect> getObiecte() {
        return new ArrayList<>(obiecte);
    }

    public Optional<Obiect> getObiectByDenumire(String denumire) {
        return obiecte.stream().filter(obiect -> obiect.getDenumire().equals(denumire)).findFirst();
    }

    public Obiect createObiect(Obiect obiect) {
        obiecte.add(obiect);
        return obiect;
    }

    public List<Obiect> searchObiecte(String keyword) {
        return obiecte.stream()
                .filter(obiect -> obiect.getDenumire().contains(keyword) || obiect.getDescriere().contains(keyword))
                .collect(Collectors.toList());
    }

    public Optional<Obiect> revendicareObiect(String denumire) {
        Optional<Obiect> obiectOptional = getObiectByDenumire(denumire);
        obiectOptional.ifPresent(obiect -> obiect.setStatus(Status.IN_CAUTARE));
        return obiectOptional;
    }
}
