package com.proiect.lostandauctioned;

import com.proiect.lostandauctioned.model.Licitatie;
import com.proiect.lostandauctioned.model.Oferta;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class TEST_VLAD {

    static Stream<Arguments> provideOffersAndExpectedHighest() {
        return Stream.of(
            // Case 1: Simple list with a clear winner
            Arguments.of(
                Arrays.asList(new Oferta("User1", 100), new Oferta("User2", 150), new Oferta("User3", 120)),
                150.0
            ),
            // Case 2: List with a single offer
            Arguments.of(
                List.of(new Oferta("User1", 50)),
                50.0
            ),
            // Case 3: List with duplicate highest offers (should return the first one found)
            Arguments.of(
                Arrays.asList(new Oferta("User1", 200), new Oferta("User2", 180), new Oferta("User3", 200)),
                200.0
            ),
            // Case 4: List with negative or zero values
            Arguments.of(
                Arrays.asList(new Oferta("User1", -10), new Oferta("User2", 0), new Oferta("User3", 5)),
                5.0
            ),
            // Case 5: Empty list
            Arguments.of(
                Arrays.asList(),
                null
            )
        );
    }

    @ParameterizedTest
    @MethodSource("provideOffersAndExpectedHighest")
    void testGetCeaMaiMareOferta(List<Oferta> oferte, Double expectedHighestSum) {
        Licitatie licitatie = new Licitatie("Ceas De Mana");
        licitatie.setOferte(oferte);

        var ceaMaiMareOfertaOpt = licitatie.getCeaMaiMareOferta();

        if (expectedHighestSum == null) {
            assertTrue(ceaMaiMareOfertaOpt.isEmpty(), "Expected no highest offer for an empty list");
        } else {
            assertTrue(ceaMaiMareOfertaOpt.isPresent(), "Expected a highest offer to be present");
            assertEquals(expectedHighestSum, ceaMaiMareOfertaOpt.get().getSuma(), "The highest offer sum is incorrect");
        }
    }
}
