package io.github.lyes_sefiane;

import io.github.lyes_sefiane.model.Temperature;
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
public class Trier2 {

    private static final Logger logger = LogManager.getLogger(Trier2.class);

    static int mini(Temperature[] temp, int nbElem) {
        int k = 0;
        for (int i = 1; i < nbElem; i++)
            if (temp[i].plusPetit(temp[k]))
                k = i;
        return k;
    }


    static void afficher(Temperature[] temp, int nbJrs, String mess) {
        logger.info("Informations {} :", mess);

        for (int i = 0; i < nbJrs; i++) {
            logger.info("{}) ", i);
            temp[i].afficher();
        }
    }


    static void trier(Temperature[] temp, int nbJrs) {
        for (int i = 0; i < nbJrs - 1; i++) {
            int indMin = i;
            for (int j = i + 1; j < nbJrs; j++)
                if (temp[j].estInferieur(temp[indMin]))
                    indMin = j;
            if (indMin != i) {
                Temperature tempo = temp[i];
                temp[i] = temp[indMin];
                temp[indMin] = tempo;
            }
        }
    }


    public static void main(String[] args) {
        Temperature[] temp = {new Temperature("Lundi", -16), new Temperature("Mardi", -14), new Temperature("Mercredi", -9),
                new Temperature("Jeudi", -18), new Temperature("Vendredi", -15), new Temperature("Samedi", -10),
                new Temperature("Dimanche", -17)};

        int nbJrs = temp.length;

        afficher(temp, nbJrs, "au debut");

        int indMin = mini(temp, nbJrs);
        logger.info("Journee avec temperature minimale : ");
        temp[indMin].afficher();

        trier(temp, nbJrs);
        afficher(temp, nbJrs, "apres le tri selon les journees :");
    }
}
/* Exécution:
--------------------Configuration: <Default>--------------------
Informations au debut :
  0)        Lundi  avec      -16 degres Celcius
  1)        Mardi  avec      -14 degres Celcius
  2)     Mercredi  avec       -9 degres Celcius
  3)        Jeudi  avec      -18 degres Celcius
  4)     Vendredi  avec      -15 degres Celcius
  5)       Samedi  avec      -10 degres Celcius
  6)     Dimanche  avec      -17 degres Celcius

Journee avec temperature minimale :        Jeudi  avec      -18 degres Celcius
Informations apres le tri selon les journees : :
  0)     Dimanche  avec      -17 degres Celcius
  1)        Jeudi  avec      -18 degres Celcius
  2)        Lundi  avec      -16 degres Celcius
  3)        Mardi  avec      -14 degres Celcius
  4)     Mercredi  avec       -9 degres Celcius
  5)       Samedi  avec      -10 degres Celcius
  6)     Vendredi  avec      -15 degres Celcius


Process completed.



*/
