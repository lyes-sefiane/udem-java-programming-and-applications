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
@DisplayName("String Test Cases")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class Ex1StrA16Test {

    private static final String BONNE_RENTREE_ET_BON_SUCCESS_AU_IFT_1170_HIVER_2017 = "Bonne rentree et bon succes au IFT 1170 Hiver 2017!";

    @BeforeAll
    static void setUp() {
        //
    }

    @AfterAll
    static void tearDown() {
        //
    }


    @Test
    @DisplayName("Count Occurrence Letter")
    @Order(0)
    void testNbFois() {
        assertEquals(2, Ex1StrA16.nbFois('o', BONNE_RENTREE_ET_BON_SUCCESS_AU_IFT_1170_HIVER_2017));
    }

    @Test
    @DisplayName("Count Vowels with Switch Case")
    @Order(1)
    void testNbVoywithSwitchCase() {
        assertEquals(14, Ex1StrA16.nbVoy(BONNE_RENTREE_ET_BON_SUCCESS_AU_IFT_1170_HIVER_2017.toUpperCase()));
    }

    @Test
    @DisplayName("Count Vowels with IndexOf")
    @Order(2)
    void testNbVoywithIndexOf() {
        assertEquals(14, Ex1StrA16.nbVoy2(BONNE_RENTREE_ET_BON_SUCCESS_AU_IFT_1170_HIVER_2017));
    }
}