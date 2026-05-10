package com.proiect.lostandauctioned.controller;

import com.proiect.lostandauctioned.model.Licitatie;
import com.proiect.lostandauctioned.model.Oferta;
import com.proiect.lostandauctioned.service.LicitatieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auctions")
public class LicitatieController {

    private final LicitatieService licitatieService;

    public LicitatieController(LicitatieService licitatieService) {
        this.licitatieService = licitatieService;
    }

    @GetMapping
    public List<Licitatie> getLicitatiiActive() {
        return licitatieService.getLicitatiiActive();
    }

    @PostMapping("/{denumireObiect}/oferta")
    public Licitatie adaugaOferta(@PathVariable String denumireObiect, @RequestBody Oferta oferta) {
        return licitatieService.adaugaOferta(denumireObiect, oferta)
            .orElseThrow(() -> new RuntimeException("Licitatia nu a fost gasita!"));
    }
}
