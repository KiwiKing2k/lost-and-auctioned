package com.proiect.lostandauctioned;

import com.proiect.lostandauctioned.model.Obiect;
import com.proiect.lostandauctioned.model.Status;
import com.proiect.lostandauctioned.service.ObiectService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TEST_STEFAN {

    private ObiectService obiectService;

    @BeforeEach
    void setUp() {
        // We create a new service for each test to ensure they are isolated
        obiectService = new ObiectService();
    }

    @Test
    void testFullItemLifecycle_ReportApproveClaimConfirm() {
        // 1. A user reports a lost item
        Obiect obiectNou = new Obiect("Telefon", "iPhone 15", "Cantina", Status.RAPORTAT, "");
        obiectService.createObiect(obiectNou);

        // Verify the item is in the reported queue and not searchable
        assertEquals(1, obiectService.getReportedItems().size());
        assertEquals("Telefon", obiectService.getReportedItems().get(0).getDenumire());
        assertTrue(obiectService.searchObiecte("Telefon").isEmpty());

        // 2. Admin approves the item
        obiectService.approveObiect("Telefon");

        // Verify the item is now searchable and no longer in the reported queue
        assertFalse(obiectService.searchObiecte("Telefon").isEmpty());
        assertTrue(obiectService.getReportedItems().isEmpty());
        assertEquals(Status.IN_CAUTARE, obiectService.getObiectByDenumire("Telefon").get().getStatus());

        // 3. Another user finds and claims the item
        obiectService.revendicareObiect("Telefon");

        // Verify the item is now in the claimed queue and no longer searchable
        assertEquals(1, obiectService.getClaimedItems().size());
        assertTrue(obiectService.searchObiecte("Telefon").isEmpty());
        assertEquals(Status.RETURNAT, obiectService.getObiectByDenumire("Telefon").get().getStatus());

        // 4. Admin confirms the return
        obiectService.confirmReturn("Telefon");

        // Verify the item is completely removed from the system
        assertTrue(obiectService.getClaimedItems().isEmpty());
        assertTrue(obiectService.getObiectByDenumire("Telefon").isEmpty());
    }
}
