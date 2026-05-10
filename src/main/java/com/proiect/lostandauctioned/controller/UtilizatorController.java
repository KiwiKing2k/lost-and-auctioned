package com.proiect.lostandauctioned.controller;

import com.proiect.lostandauctioned.model.Utilizator;
import com.proiect.lostandauctioned.service.UtilizatorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/utilizatori")
public class UtilizatorController {

    private final UtilizatorService utilizatorService;

    public UtilizatorController(UtilizatorService utilizatorService) {
        this.utilizatorService = utilizatorService;
    }

    @GetMapping
    public List<Utilizator> getAllUtilizatori() {
        return utilizatorService.getUtilizatori();
    }

    @GetMapping("/{email}")
    public Utilizator getUtilizatorByEmail(@PathVariable String email) {
        return utilizatorService.getUtilizatorByEmail(email).orElse(null);
    }

    @PostMapping
    public Utilizator createUtilizator(@RequestBody Utilizator utilizator) {
        return utilizatorService.createUtilizator(utilizator);
    }
}
