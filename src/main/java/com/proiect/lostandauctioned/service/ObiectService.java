package com.proiect.lostandauctioned.service;

import com.proiect.lostandauctioned.model.Obiect;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
}
