package io.github.lyes_sefiane;

import io.github.lyes_sefiane.model.Etudiant;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @course : IFT 1170 Java Programming and Applications
 * @university : University of Montreal
 * @teacher : Van Nguyen Le
 * @email : van.nguyen.le@umontreal.ca
 * @student : Sefiane, Lyes
 * @matricule : 20090833
 * @email : lyes.sefiane@umontreal.ca
 * @email : lyes.sefiane@gmail.com
 * @date : 2017-04-19
 */
@DisplayName("POO Test Cases")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class POOH17Test {

    private static Etudiant etud1;
    private static Etudiant etud2;
    private static Etudiant etud3;

    @BeforeAll
    static void setUp() {
        etud1 = new Etudiant("Tremblay Nicole", "TREN25571990", 82.7);
        etud2 = new Etudiant("Choquette Alain", "CHOA07121997", 88.1);
        etud3 = new Etudiant("Roy Lise", "ROYL30611995");
    }

    @AfterAll
    static void tearDown() {
        //
    }

    @Test
    @DisplayName("String To Upper Case Test")
    @Order(0)
    void testGetNomPreEnMajuscule() {
        assertEquals("TREMBLAY NICOLE", etud1.getNomPreToUpperCase());
    }

    @Test
    @DisplayName("Set Value Test")
    @Order(1)
    void testSetGlobale() {
        etud3.setGlobale(etud3.getGlobale() + 5.2);
        assertEquals(80.60000000000001, etud3.getGlobale());
    }

    @Test
    @DisplayName("Array Length Test")
    @Order(2)
    void testArrayLength() {
        Etudiant[] etudiants = {etud1, etud2, etud3};
        assertEquals(3, etudiants.length);
    }
}