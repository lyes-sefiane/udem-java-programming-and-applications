package io.github.lyes_sefiane;

import io.github.lyes_sefiane.model.Rectangle;
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
@DisplayName("Rectangle Test Cases")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class RectangleTest {

    private static Rectangle rect1;
    private static Rectangle rect2;
    private static Rectangle rect3;
    private static Rectangle[] rect;
    private static int nbRect;

    @BeforeAll
    static void setUp() {
        rect1 = new Rectangle(7.8, 3.5);
        rect2 = new Rectangle();
        rect3 = new Rectangle(4.1);
        rect = new Rectangle[]{
                new Rectangle(6.3, 4.7),
                new Rectangle(5.1, 4.6),
                new Rectangle(7.3, 2.8),
                new Rectangle(5.8, 3.5),
                new Rectangle(4.2),
                new Rectangle(4.7, 3.1)
        };
        nbRect = rect.length;
    }

    @AfterAll
    static void tearDown() {
        //
    }

    @Test
    @DisplayName("Set Largeur Test")
    @Order(0)
    void testSetLargeur() {
        rect1.setLargeur(2 * rect1.getLargeur());
        assertEquals(7.0, rect1.getLargeur());
    }


    @Test
    @DisplayName("Index Max Longeur Test")
    @Order(1)
    void testIndexMaxLongueur() {
        int k = Ex1Rectangle.indMaxLongueur(rect, nbRect);
        assertEquals(2, k);
    }

    @Test
    @DisplayName("Trier Arrays Test")
    @Order(2)
    void testTrierArrays() {
        Rectangle[] rectApresTri = new Rectangle[]{
                new Rectangle(4.7, 3.1),
                new Rectangle(4.2),
                new Rectangle(5.8, 3.5),
                new Rectangle(7.3, 2.8),
                new Rectangle(5.1, 4.6),
                new Rectangle(6.3, 4.7)
        };
        Ex1Rectangle.trier(rect, nbRect);
        assertArrayEquals(rect, rectApresTri);
    }
}