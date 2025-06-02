package io.github.lyes_sefiane;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
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
@DisplayName("Tableaux Test Cases")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TableauxTest {

    private static char[] statut;
    private static double[] taille;
    private static double[] poids;
    private static int nbPers;

    @BeforeAll
    static void setUp() {
        statut = new char[]{'M', 'C', 'D', 'M', 'S', 'M', 'A'};
        taille = new double[]{1.72, 1.65, 1.59, 1.80, 1.82, 1.68, 1.75};
        poids = new double[]{68.3, 52.1, 72.9, 70.4, 81.5, 65.4, 70.3};
        nbPers = taille.length;
    }

    @AfterAll
    static void tearDown() {
        //
    }

    @Test
    @DisplayName("Married Persons Count Test")
    @Order(0)
    void testNombreMariee() {
        assertEquals(3, Tableaux.nombre('M', statut, nbPers));
    }

    @Test
    @DisplayName("Divorced Persons Count Test")
    @Order(1)
    void testNombreSeparee() {
        assertEquals(1, Tableaux.nombre('S', statut, nbPers));
    }

    @Test
    @DisplayName("Widow Persons Count Test")
    @Order(2)
    void testNombreVeuve() {
        assertEquals(0, Tableaux.nombre('V', statut, nbPers));
    }

    @Test
    @DisplayName("Average Size Test")
    @Order(3)
    void testTailleMoyenne() {
        assertEquals(1.7157142857142857, Tableaux.moyenne(taille, nbPers));
    }

    @Test
    @DisplayName("Average Weight Test")
    @Order(4)
    void testPoidsMoyen() {
        assertEquals(68.7, Tableaux.moyenne(poids, nbPers));
    }

    @Test
    @DisplayName("Max Size Test")
    @Order(5)
    void testTaillePlusGrande() {
        assertEquals(1.82, Tableaux.maxi(taille, nbPers));
    }

    @Test
    @DisplayName("Max Weight Test")
    @Order(6)
    void testPoidsPlusLourd() {
        assertEquals(81.5, Tableaux.maxi(poids, nbPers));
    }

    @Test
    @DisplayName("Size > 1.76 M Test")
    @Order(7)
    void testPersonnesTailleDepasse176Metre() {
        assertEquals(2, Tableaux.nbFois(taille, nbPers, 1.76));
    }

    @Test
    @DisplayName("Weight > 70.0 Kg Test")
    @Order(8)
    void testPersonnesPoidsDepasse70Kg() {
        assertEquals(4, Tableaux.nbFois(poids, nbPers, 70.0));
    }

    @Test
    @DisplayName("Sort Arrays Test")
    @Order(9)
    void testTriTableaux() {
        char[] statutApresTri = new char[]{'D', 'C', 'M', 'M', 'A', 'M', 'S'};
        double[] tailleApresTri = new double[]{1.59, 1.65, 1.68, 1.72, 1.75, 1.80, 1.82};
        double[] poidsApresTri = new double[]{72.9, 52.1, 65.4, 68.3, 70.3, 70.4, 81.5};
        Tableaux.trier(statut, taille, poids, nbPers);
        assertArrayEquals(statutApresTri, statut);
        assertArrayEquals(tailleApresTri, taille);
        assertArrayEquals(poidsApresTri, poids);
    }
}