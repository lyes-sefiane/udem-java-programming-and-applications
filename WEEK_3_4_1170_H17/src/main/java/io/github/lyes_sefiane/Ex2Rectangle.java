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
public class Ex2Rectangle {

    private static final Logger logger = LogManager.getLogger(Ex2Rectangle.class);

    static void demo1() {

        logger.info("Démonstration numéro 1 : ");

        Rectangle rect1 = new Rectangle(7.8, 3.5);
        rect1.afficher("premier rectangle");

        Rectangle rect2 = new Rectangle();
        rect2.afficher("rect2");

        Rectangle rect3 = new Rectangle(4.1);
        rect3.afficher("troisieme rectangle");

        rect1.setLargeur(2 * rect1.getLargeur());
        rect1.afficher("rect1 apres avoir double sa largeur");

        rect1.plusLong(rect3).afficher("rectangle ayant le périmètre le plus long entre rect1 et rect3");
    }

    static void afficher(Rectangle[] rect, int nbRect, String mess) {
        logger.info("Infos des rectangles {} : ", mess);
        logger.info("largeur longueur périmètre surface diagonale");

        for (int i = 0; i < nbRect; i++) {
            logger.info("{} ", rect[i]);
        }
    }

    static int indMaxLongueur(Rectangle[] rect, int nbRect) {
        int indPG = 0;
        for (int i = 1; i < nbRect; i++)
            if (rect[i].getLongueur() > rect[indPG].getLongueur())
                indPG = i;
        return indPG;
    }

    static void trier(Rectangle[] rect, int nbRect) {
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

    static void demo2() {

        logger.info("Démonstration numéro 2 : ");

        Rectangle[] rect = {new Rectangle(6.3, 4.7), new Rectangle(5.1, 4.6), new Rectangle(7.3, 2.8),
                new Rectangle(4.2), new Rectangle(), new Rectangle(4.7, 3.1)};
        int nbRect = rect.length;

        afficher(rect, nbRect, "avant le tri");

        int k = indMaxLongueur(rect, nbRect);
        logger.info("Rectangle ayant la plus grande longueur : {}", rect[k]);

        trier(rect, nbRect);
        afficher(rect, nbRect, "après le tri selon les surfaces");
    }

    public static void main(String[] args) {
        demo1();
        demo2();
    }
}

/*
 * 2025-05-28 15:21:13 INFO  Ex2Rectangle:23 - Démonstration numéro 1 :
 * 2025-05-28 15:21:13 INFO  Rectangle:68 - Informations de premier rectangle :
 * 2025-05-28 15:21:13 INFO  Rectangle:69 -   - longueur  : 7.8
 * 2025-05-28 15:21:13 INFO  Rectangle:70 -   - largeur   : 3.5
 * 2025-05-28 15:21:13 INFO  Rectangle:71 -   - perimetre : 22.6
 * 2025-05-28 15:21:13 INFO  Rectangle:72 -   - surface   : 27.3
 * 2025-05-28 15:21:13 INFO  Rectangle:73 -   - diagonale : 8.5492689745966
 * 2025-05-28 15:21:13 INFO  Rectangle:68 - Informations de rect2 :
 * 2025-05-28 15:21:13 INFO  Rectangle:69 -   - longueur  : 5.8
 * 2025-05-28 15:21:13 INFO  Rectangle:70 -   - largeur   : 3.5
 * 2025-05-28 15:21:13 INFO  Rectangle:71 -   - perimetre : 18.6
 * 2025-05-28 15:21:13 INFO  Rectangle:72 -   - surface   : 20.3
 * 2025-05-28 15:21:13 INFO  Rectangle:73 -   - diagonale : 6.774215821775979
 * 2025-05-28 15:21:13 INFO  Rectangle:68 - Informations de troisieme rectangle :
 * 2025-05-28 15:21:13 INFO  Rectangle:69 -   - longueur  : 4.1
 * 2025-05-28 15:21:13 INFO  Rectangle:70 -   - largeur   : 4.1
 * 2025-05-28 15:21:13 INFO  Rectangle:71 -   - perimetre : 16.4
 * 2025-05-28 15:21:13 INFO  Rectangle:72 -   - surface   : 16.81
 * 2025-05-28 15:21:13 INFO  Rectangle:73 -   - diagonale : 5.79827560572969
 * 2025-05-28 15:21:13 INFO  Rectangle:68 - Informations de rect1 apres avoir double sa largeur :
 * 2025-05-28 15:21:13 INFO  Rectangle:69 -   - longueur  : 7.8
 * 2025-05-28 15:21:13 INFO  Rectangle:70 -   - largeur   : 7.0
 * 2025-05-28 15:21:13 INFO  Rectangle:71 -   - perimetre : 29.6
 * 2025-05-28 15:21:13 INFO  Rectangle:72 -   - surface   : 54.6
 * 2025-05-28 15:21:13 INFO  Rectangle:73 -   - diagonale : 10.480458005259122
 * 2025-05-28 15:21:13 INFO  Rectangle:68 - Informations de rectangle ayant le périmètre le plus long entre rect1 et rect3 :
 * 2025-05-28 15:21:13 INFO  Rectangle:69 -   - longueur  : 7.8
 * 2025-05-28 15:21:13 INFO  Rectangle:70 -   - largeur   : 7.0
 * 2025-05-28 15:21:13 INFO  Rectangle:71 -   - perimetre : 29.6
 * 2025-05-28 15:21:13 INFO  Rectangle:72 -   - surface   : 54.6
 * 2025-05-28 15:21:13 INFO  Rectangle:73 -   - diagonale : 10.480458005259122
 * 2025-05-28 15:21:13 INFO  Ex2Rectangle:73 - Démonstration numéro 2 :
 * 2025-05-28 15:21:13 INFO  Ex2Rectangle:41 - Infos des rectangles avant le tri :
 * 2025-05-28 15:21:13 INFO  Ex2Rectangle:42 - largeur longueur périmètre surface diagonale
 * 2025-05-28 15:21:13 INFO  Ex2Rectangle:45 - <  4.7 |    6.3 |  22.00 |   29.6 |    7.9>
 * 2025-05-28 15:21:13 INFO  Ex2Rectangle:45 - <  4.6 |    5.1 |  19.40 |   23.5 |    6.9>
 * 2025-05-28 15:21:13 INFO  Ex2Rectangle:45 - <  2.8 |    7.3 |  20.20 |   20.4 |    7.8>
 * 2025-05-28 15:21:13 INFO  Ex2Rectangle:45 - <  4.2 |    4.2 |  16.80 |   17.6 |    5.9>
 * 2025-05-28 15:21:13 INFO  Ex2Rectangle:45 - <  3.5 |    5.8 |  18.60 |   20.3 |    6.8>
 * 2025-05-28 15:21:13 INFO  Ex2Rectangle:45 - <  3.1 |    4.7 |  15.60 |   14.6 |    5.6>
 * 2025-05-28 15:21:13 INFO  Ex2Rectangle:82 - Rectangle ayant la plus grande longueur : <  2.8 |    7.3 |  20.20 |   20.4 |    7.8>
 * 2025-05-28 15:21:13 INFO  Ex2Rectangle:41 - Infos des rectangles après le tri selon les surfaces :
 * 2025-05-28 15:21:13 INFO  Ex2Rectangle:42 - largeur longueur périmètre surface diagonale
 * 2025-05-28 15:21:13 INFO  Ex2Rectangle:45 - <  3.1 |    4.7 |  15.60 |   14.6 |    5.6>
 * 2025-05-28 15:21:13 INFO  Ex2Rectangle:45 - <  4.2 |    4.2 |  16.80 |   17.6 |    5.9>
 * 2025-05-28 15:21:13 INFO  Ex2Rectangle:45 - <  3.5 |    5.8 |  18.60 |   20.3 |    6.8>
 * 2025-05-28 15:21:13 INFO  Ex2Rectangle:45 - <  2.8 |    7.3 |  20.20 |   20.4 |    7.8>
 * 2025-05-28 15:21:13 INFO  Ex2Rectangle:45 - <  4.6 |    5.1 |  19.40 |   23.5 |    6.9>
 * 2025-05-28 15:21:13 INFO  Ex2Rectangle:45 - <  4.7 |    6.3 |  22.00 |   29.6 |    7.9>
 * <p>
 * Process finished with exit code 0
 */