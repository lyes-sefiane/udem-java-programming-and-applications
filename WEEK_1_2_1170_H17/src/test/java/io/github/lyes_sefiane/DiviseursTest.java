package io.github.lyes_sefiane;

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
@DisplayName("Divisors Test Cases")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DiviseursTest {

    private static final int NUMBER_1 = 720;
    private static final int NUMBER_2 = 1000;

    @BeforeAll
    static void setUp() {
        //
    }

    @AfterAll
    static void tearDown() {
        //
    }

    @Test
    @DisplayName("Divisor of 720 Calculation")
    @Order(0)
    void testNbDiv720() {
        assertEquals(30, Diviseurs.nbDiv(NUMBER_1));
    }

    @Test
    @DisplayName("Divisor of 1000 Calculation")
    @Order(1)
    void testNbDiv1000() {
        assertEquals(16, Diviseurs.nbDiv(NUMBER_2));
    }
}