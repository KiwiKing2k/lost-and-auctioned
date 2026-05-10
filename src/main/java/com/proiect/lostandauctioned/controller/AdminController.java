package com.proiect.lostandauctioned.controller;

import com.proiect.lostandauctioned.model.Licitatie;
import com.proiect.lostandauctioned.model.Obiect;
import com.proiect.lostandauctioned.service.LicitatieService;
import com.proiect.lostandauctioned.service.ObiectService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final ObiectService obiectService;
    private final LicitatieService licitatieService;

    public AdminController(ObiectService obiectService, LicitatieService licitatieService) {
        this.obiectService = obiectService;
        this.licitatieService = licitatieService;
    }

    // ... (existing endpoints for approve, reject, confirm)

    @GetMapping("/reported")
    public List<Obiect> getReportedItems() {
        return obiectService.getReportedItems();
    }

    @PostMapping("/approve/{denumire}")
    public Obiect approveObiect(@PathVariable String denumire) {
        return obiectService.approveObiect(denumire).orElse(null);
    }

    @PostMapping("/reject/{denumire}")
    public void rejectObiect(@PathVariable String denumire) {
        obiectService.rejectObiect(denumire);
    }

    @GetMapping("/claimed")
    public List<Obiect> getClaimedItems() {
        return obiectService.getClaimedItems();
    }

    @PostMapping("/confirm-return/{denumire}")
    public void confirmReturn(@PathVariable String denumire) {
        obiectService.confirmReturn(denumire);
    }

    // --- Updated Auction Endpoints ---

    @GetMapping("/auctionable")
    public List<Obiect> getAuctionableItems() {
        return obiectService.getAuctionableItems();
    }

    @PostMapping("/to-auction/{denumire}")
    public Licitatie sendToAuction(@PathVariable String denumire) {
        return licitatieService.createLicitatie(denumire);
    }

    @GetMapping("/in-auction")
    public List<Licitatie> getItemsInAuction() {
        return licitatieService.getLicitatiiActive();
    }

    @PostMapping("/finish-auction/{denumire}")
    public void finishAuction(@PathVariable String denumire) {
        licitatieService.finishLicitatie(denumire);
    }
}
