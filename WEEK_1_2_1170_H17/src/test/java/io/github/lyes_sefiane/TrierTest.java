package io.github.lyes_sefiane;

import io.github.lyes_sefiane.model.Temperature;
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
@DisplayName("Trier Test Cases")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TrierTest {
    private static String[] jour;
    private static int[] degreC;
    private static Temperature[] temperatures;

    @BeforeAll
    static void setUp() {
        jour = new String[]{"Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi", "Dimanche"};
        degreC = new int[]{-16, -14, -9, -18, -15, -10, -17};
        temperatures = new Temperature[]{
                new Temperature("Lundi", -16),
                new Temperature("Mardi", -14),
                new Temperature("Mercredi", -9),
                new Temperature("Jeudi", -18),
                new Temperature("Vendredi", -15),
                new Temperature("Samedi", -10),
                new Temperature("Dimanche", -17)};
    }

    @AfterAll
    static void tearDown() {
        //
    }

    @Test
    @DisplayName("Index of Min Degree Value Test")
    @Order(0)
    void testMiniDegree() {
        int indMinDegree = Trier1.mini(degreC, jour.length);
        assertEquals(3, indMinDegree);
    }

    @Test
    @DisplayName("Sort Days Array Test")
    @Order(1)
    void testTrierJours() {
        String[] jourApresTri = new String[]{"Dimanche", "Jeudi", "Lundi", "Mardi", "Mercredi", "Samedi", "Vendredi"};
        int[] degreCApresTri = new int[]{-17, -18, -16, -14, -9, -10, -15};
        Trier1.trier(jour, degreC, jour.length);
        assertArrayEquals(jour, jourApresTri);
        assertArrayEquals(degreC, degreCApresTri);
    }

    @Test
    @DisplayName("Index of Min Degree Value After Sort Test")
    @Order(2)
    void testMiniDegreeAfterSort() {
        int indMinDegree = Trier1.mini(degreC, jour.length);
        assertEquals(1, indMinDegree);
    }

    @Test
    @DisplayName("Index of Mini Temperature Value Test")
    @Order(3)
    void testMiniTemperature() {
        int indMinTemperature = Trier2.mini(temperatures, temperatures.length);
        assertEquals(3, indMinTemperature);
    }

    @Test
    @DisplayName("Sort Temperature Array Test")
    @Order(4)
    void testTrierTemperature() {
        
        Temperature[] temperatureApresTri = {
                new Temperature("Dimanche", -17),
                new Temperature("Jeudi", -18),
                new Temperature("Lundi", -16),
                new Temperature("Mardi", -14),
                new Temperature("Mercredi", -9),
                new Temperature("Samedi", -10),
                new Temperature("Vendredi", -15)};

        Trier2.trier(temperatures, temperatures.length);

        assertArrayEquals(temperatures, temperatureApresTri);
    }
}