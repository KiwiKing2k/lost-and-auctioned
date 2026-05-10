package com.proiect.lostandauctioned.controller;

import com.proiect.lostandauctioned.model.Obiect;
import com.proiect.lostandauctioned.service.ObiectService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/obiecte")
public class ObiectController {

    private final ObiectService obiectService;

    public ObiectController(ObiectService obiectService) {
        this.obiectService = obiectService;
    }

    @GetMapping
    public List<Obiect> getAllObiecte() {
        return obiectService.getObiecte();
    }

    @GetMapping("/search/{keyword}")
    public List<Obiect> searchObiecte(@PathVariable String keyword) {
        return obiectService.searchObiecte(keyword);
    }

    @GetMapping("/{denumire}")
    public Obiect getObiectByDenumire(@PathVariable String denumire) {
        return obiectService.getObiectByDenumire(denumire).orElse(null);
    }

    @PostMapping
    public Obiect createObiect(@RequestBody Obiect obiect) {
        return obiectService.createObiect(obiect);
    }

    @PostMapping("/revendicare/{denumire}")
    public Obiect revendicareObiect(@PathVariable String denumire) {
        return obiectService.revendicareObiect(denumire).orElse(null);
    }
}
