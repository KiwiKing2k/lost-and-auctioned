package com.proiect.lostandauctioned.service;

import com.proiect.lostandauctioned.model.Utilizator;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UtilizatorService {

    private final List<Utilizator> utilizatori = new ArrayList<>();

    public List<Utilizator> getUtilizatori() {
        return new ArrayList<>(utilizatori);
    }

    public Optional<Utilizator> getUtilizatorByEmail(String email) {
        return utilizatori.stream().filter(utilizator -> utilizator.getEmail().equals(email)).findFirst();
    }

    public Utilizator createUtilizator(Utilizator utilizator) {
        utilizatori.add(utilizator);
        return utilizator;
    }
}
