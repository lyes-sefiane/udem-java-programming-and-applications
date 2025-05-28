package io.github.lyes_sefiane;

import io.github.lyes_sefiane.model.Rectangle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
public class Ex1Rectangle {

    private static final Logger logger = LogManager.getLogger(Ex1Rectangle.class);

    public static void demo1() {

        logger.info("Démonstration numéro 1 : ");

        Rectangle rect1 = new Rectangle(7.8, 3.5);
        rect1.afficher("premier rectangle");

        Rectangle rect2 = new Rectangle();
        rect2.afficher("rect2");

        Rectangle rect3 = new Rectangle(4.1);
        rect3.afficher("troisieme rectangle");

        rect1.setLargeur(2 * rect1.getLargeur());
        rect1.afficher("rect1 apres avoir double sa largeur");
    }

    public static void afficher(Rectangle[] rect, int nbRect, String mess) {
        logger.info("Infos des rectangles {} : ", mess);
        logger.info("largeur longueur périmètre surface diagonale");

        for (int i = 0; i < nbRect; i++)
            logger.info("<{} | {} | {} | {} | {}>",
                    rect[i].getLargeur(), rect[i].getLongueur(), rect[i].perimetre(),
                    rect[i].surface(), rect[i].diagonale());

    }

    public static int indMaxLongueur(Rectangle[] rect, int nbRect) {
        int indPG = 0;
        for (int i = 1; i < nbRect; i++)
            if (rect[i].getLongueur() > rect[indPG].getLongueur())
                indPG = i;
        return indPG;
    }

    public static void trier(Rectangle[] rect, int nbRect) {
        for (int i = 0; i < nbRect - 1; i++) {
            int indMin = i;
            for (int j = i + 1; j < nbRect; j++)
                if (rect[j].surface() < rect[indMin].surface())
                    indMin = j;
            if (indMin != i) {
                Rectangle tempo = rect[i];
                rect[i] = rect[indMin];
                rect[indMin] = tempo;
            }
        }
    }

    public static void demo2() {

        logger.info("Démonstration numéro 2 :");

        Rectangle[] rect = {new Rectangle(6.3, 4.7), new Rectangle(5.1, 4.6), new Rectangle(7.3, 2.8),
                new Rectangle(4.2), new Rectangle(), new Rectangle(4.7, 3.1)};
        int nbRect = rect.length;

        afficher(rect, nbRect, "avant le tri");

        int k = indMaxLongueur(rect, nbRect);
        rect[k].afficher("rectangle ayant la plus grande longueur");

        trier(rect, nbRect);
        afficher(rect, nbRect, "après le tri selon les surfaces");
    }

    public static void main(String[] args) {
        demo1();
        demo2();
    }
}

/*
 * 2025-05-28 15:05:55 INFO  Ex1Rectangle:23 - Démonstration numéro 1 :
 * 2025-05-28 15:05:55 INFO  Rectangle:65 - Informations de premier rectangle :
 * 2025-05-28 15:05:55 INFO  Rectangle:66 -   - longueur  : 7.8
 * 2025-05-28 15:05:55 INFO  Rectangle:67 -   - largeur   : 3.5
 * 2025-05-28 15:05:55 INFO  Rectangle:68 -   - perimetre : 22.6
 * 2025-05-28 15:05:55 INFO  Rectangle:69 -   - surface   : 27.3
 * 2025-05-28 15:05:55 INFO  Rectangle:70 -   - diagonale : 8.5492689745966
 * 2025-05-28 15:05:55 INFO  Rectangle:65 - Informations de rect2 :
 * 2025-05-28 15:05:55 INFO  Rectangle:66 -   - longueur  : 5.8
 * 2025-05-28 15:05:55 INFO  Rectangle:67 -   - largeur   : 3.5
 * 2025-05-28 15:05:55 INFO  Rectangle:68 -   - perimetre : 18.6
 * 2025-05-28 15:05:55 INFO  Rectangle:69 -   - surface   : 20.3
 * 2025-05-28 15:05:55 INFO  Rectangle:70 -   - diagonale : 6.774215821775979
 * 2025-05-28 15:05:55 INFO  Rectangle:65 - Informations de troisieme rectangle :
 * 2025-05-28 15:05:55 INFO  Rectangle:66 -   - longueur  : 4.1
 * 2025-05-28 15:05:55 INFO  Rectangle:67 -   - largeur   : 4.1
 * 2025-05-28 15:05:56 INFO  Rectangle:68 -   - perimetre : 16.4
 * 2025-05-28 15:05:56 INFO  Rectangle:69 -   - surface   : 16.81
 * 2025-05-28 15:05:56 INFO  Rectangle:70 -   - diagonale : 5.79827560572969
 * 2025-05-28 15:05:56 INFO  Rectangle:65 - Informations de rect1 apres avoir double sa largeur :
 * 2025-05-28 15:05:56 INFO  Rectangle:66 -   - longueur  : 7.8
 * 2025-05-28 15:05:56 INFO  Rectangle:67 -   - largeur   : 7.0
 * 2025-05-28 15:05:56 INFO  Rectangle:68 -   - perimetre : 29.6
 * 2025-05-28 15:05:56 INFO  Rectangle:69 -   - surface   : 54.6
 * 2025-05-28 15:05:56 INFO  Rectangle:70 -   - diagonale : 10.480458005259122
 * 2025-05-28 15:05:56 INFO  Ex1Rectangle:73 - Démonstration numéro 2 :
 * 2025-05-28 15:05:56 INFO  Ex1Rectangle:39 - Infos des rectangles avant le tri :
 * 2025-05-28 15:05:56 INFO  Ex1Rectangle:40 - largeur longueur périmètre surface diagonale
 * 2025-05-28 15:05:56 INFO  Ex1Rectangle:43 - <4.7 | 6.3 | 22.0 | 29.61 | 7.860025445251434>
 * 2025-05-28 15:05:56 INFO  Ex1Rectangle:43 - <4.6 | 5.1 | 19.4 | 23.459999999999997 | 6.86804193347711>
 * 2025-05-28 15:05:56 INFO  Ex1Rectangle:43 - <2.8 | 7.3 | 20.2 | 20.439999999999998 | 7.818567643756751>
 * 2025-05-28 15:05:56 INFO  Ex1Rectangle:43 - <4.2 | 4.2 | 16.8 | 17.64 | 5.939696961966999>
 * 2025-05-28 15:05:56 INFO  Ex1Rectangle:43 - <3.5 | 5.8 | 18.6 | 20.3 | 6.774215821775979>
 * 2025-05-28 15:05:56 INFO  Ex1Rectangle:43 - <3.1 | 4.7 | 15.600000000000001 | 14.57 | 5.630275304103699>
 * 2025-05-28 15:05:56 INFO  Rectangle:65 - Informations de rectangle ayant la plus grande longueur :
 * 2025-05-28 15:05:56 INFO  Rectangle:66 -   - longueur  : 7.3
 * 2025-05-28 15:05:56 INFO  Rectangle:67 -   - largeur   : 2.8
 * 2025-05-28 15:05:56 INFO  Rectangle:68 -   - perimetre : 20.2
 * 2025-05-28 15:05:56 INFO  Rectangle:69 -   - surface   : 20.439999999999998
 * 2025-05-28 15:05:56 INFO  Rectangle:70 -   - diagonale : 7.818567643756751
 * 2025-05-28 15:05:56 INFO  Ex1Rectangle:39 - Infos des rectangles après le tri selon les surfaces :
 * 2025-05-28 15:05:56 INFO  Ex1Rectangle:40 - largeur longueur périmètre surface diagonale
 * 2025-05-28 15:05:56 INFO  Ex1Rectangle:43 - <3.1 | 4.7 | 15.600000000000001 | 14.57 | 5.630275304103699>
 * 2025-05-28 15:05:56 INFO  Ex1Rectangle:43 - <4.2 | 4.2 | 16.8 | 17.64 | 5.939696961966999>
 * 2025-05-28 15:05:56 INFO  Ex1Rectangle:43 - <3.5 | 5.8 | 18.6 | 20.3 | 6.774215821775979>
 * 2025-05-28 15:05:56 INFO  Ex1Rectangle:43 - <2.8 | 7.3 | 20.2 | 20.439999999999998 | 7.818567643756751>
 * 2025-05-28 15:05:56 INFO  Ex1Rectangle:43 - <4.6 | 5.1 | 19.4 | 23.459999999999997 | 6.86804193347711>
 * 2025-05-28 15:05:56 INFO  Ex1Rectangle:43 - <4.7 | 6.3 | 22.0 | 29.61 | 7.860025445251434>
 * <p>
 * Process finished with exit code 0
 */
