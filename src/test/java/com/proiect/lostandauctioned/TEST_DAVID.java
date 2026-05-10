package com.proiect.lostandauctioned;

import com.proiect.lostandauctioned.model.Oferta;
import com.proiect.lostandauctioned.service.LicitatieService;
import com.proiect.lostandauctioned.service.ObiectService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TEST_DAVID {

    private ObiectService obiectService;
    private LicitatieService licitatieService;

    @BeforeEach
    void setUp() {
        obiectService = new ObiectService();
        licitatieService = new LicitatieService(obiectService);
    }

    @Test
    void testInteractionWithNonExistentEntities() {
        // Case 1: Try to approve an item that doesn't exist
        assertDoesNotThrow(() -> obiectService.approveObiect("ObiectInexistent"));
        assertTrue(obiectService.getObiectByDenumire("ObiectInexistent").isEmpty());

        // Case 2: Try to claim an item that doesn't exist
        assertDoesNotThrow(() -> obiectService.revendicareObiect("ObiectInexistent"));
        assertTrue(obiectService.getClaimedItems().isEmpty());

        // Case 3: Try to add an offer to an auction that doesn't exist
        Oferta oferta = new Oferta("OfertantFantoma", 100);
        // We expect this to throw an exception as defined in LicitatieController
        assertThrows(RuntimeException.class, () -> {
            licitatieService.adaugaOferta("LicitatieInexistenta", oferta)
                .orElseThrow(() -> new RuntimeException("Licitatia nu a fost gasita!"));
        });

        // Case 4: Try to finish an auction that doesn't exist
        assertDoesNotThrow(() -> licitatieService.finishLicitatie("LicitatieInexistenta"));
    }

    @Test
    void testRejectAndConfirmReturnOnNonExistentItems() {
        // Case 5: Try to reject a reported item that doesn't exist
        assertDoesNotThrow(() -> obiectService.rejectObiect("ObiectRaportatInexistent"));

        // Case 6: Try to confirm the return of a claimed item that doesn't exist
        assertDoesNotThrow(() -> obiectService.confirmReturn("ObiectRevendicatInexistent"));
    }
}
