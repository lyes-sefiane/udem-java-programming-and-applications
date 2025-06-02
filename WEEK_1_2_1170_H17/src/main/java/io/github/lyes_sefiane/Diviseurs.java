package io.github.lyes_sefiane;

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
public class Diviseurs {

    private static final Logger logger = LogManager.getLogger(Diviseurs.class);

    static int nbDiv(int nombre) {
        int n = 0;
        for (int candidat = 1; candidat <= nombre; candidat++)
            if (nombre % candidat == 0)
                n++;
        return n;
    }

    static void afficherDiviseurs(int nombre) {
        logger.info("Le nombre {} a {} diviseurs. Ce sont :", nombre, nbDiv(nombre));
        int rang = 0;
        for (int candi = 1; candi <= nombre; candi++)
            if (nombre % candi == 0) {
                logger.info("{}) {}", ++rang, candi);
            }
    }

    public static void main(String[] args) {

        final int nombre1 = 720;
        final int nombre2 = 1000;

        int k = nbDiv(nombre1);

        logger.info("Le nombre de diviseurs de {} est {}", nombre1, k);
        logger.info("Le nombre de diviseurs de {} est {}", nombre2, Diviseurs.nbDiv(nombre2));

        // découvrir un nombre entre 721 et 999 qui a plus de diviseurs que 720
        for (int nombre = nombre1 + 1; nombre < nombre2; nombre++)
            if (nbDiv(nombre) > k) {
                logger.info("Le nombre {} a plus de diviseurs que {}", nombre, nombre1);
                Diviseurs.afficherDiviseurs(nombre);
            }
    }
}

/* Compilation et Exécution:
--------------------Configuration: <Default>--------------------
Le nombre de diviseurs de 720 est 30
Le nombre de diviseurs de 1000 est 16
Le nombre 840 a plus de diviseurs que 720
Le nombre 840 a 32 diviseurs. Ce sont :
  1)          1
  2)          2
  3)          3
  4)          4
  5)          5
  6)          6
  7)          7
  8)          8
  9)         10
 10)         12
 11)         14
 12)         15
 13)         20
 14)         21
 15)         24
 16)         28
 17)         30
 18)         35
 19)         40
 20)         42
 21)         56
 22)         60
 23)         70
 24)         84
 25)        105
 26)        120
 27)        140
 28)        168
 29)        210
 30)        280
 31)        420
 32)        840



Process completed.


*/