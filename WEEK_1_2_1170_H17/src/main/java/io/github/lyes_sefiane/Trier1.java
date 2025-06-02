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
public class Trier1 {

    private static final Logger logger = LogManager.getLogger(Trier1.class);

    static int mini(int[] tableau, int nbElem) {
        int k = 0;
        for (int i = 1; i < nbElem; i++)
            if (tableau[i] < tableau[k])
                k = i;
        return k;
    }

    static void afficher(String[] jour, int[] degreC, int nbJrs, String mess) {
        logger.info("Informations {} : ", mess);
        logger.info("Rang        Journee      degre C");

        for (int i = 0; i < nbJrs; i++) {
            logger.info("{}) {} {}", i, jour[i], degreC[i]);
        }
    }

    /* trier selon les journées en ordre alphabétique
     * Notez que compareTo est une méthode de la classe String
     * pour comparer deux chaînes de caractères
     */
    static void trier(String[] jour, int[] degreC, int nbJrs) {
        for (int i = 0; i < nbJrs - 1; i++) {
            int indMin = i;
            for (int j = i + 1; j < nbJrs; j++)
                if (jour[j].compareTo(jour[indMin]) < 0)
                    indMin = j;
            if (indMin != i) {
                // permutation
                String tempo = jour[i];
                jour[i] = jour[indMin];
                jour[indMin] = tempo;

                // permutation
                int temp = degreC[i];
                degreC[i] = degreC[indMin];
                degreC[indMin] = temp;
            }
        }
    }

    public static void main(String[] args) {
        String[] jour = {"Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi", "Dimanche"};
        int[] degreC = {-16, -14, -9, -18, -15, -10, -17};
        int nbJrs = jour.length;

        afficher(jour, degreC, nbJrs, "au debut");

        int indMin = mini(degreC, nbJrs);
        logger.info("Journee :{} }avec temperature minimale {} degres Celcius", jour[indMin], degreC[indMin]);

        trier(jour, degreC, nbJrs);
        afficher(jour, degreC, nbJrs, "apres le tri");

    }
}
/* Exécution:
--------------------Configuration: <Default>--------------------
Informations au debut :
Rang        Journee      degre C
  0)           Lundi      -16
  1)           Mardi      -14
  2)        Mercredi       -9
  3)           Jeudi      -18
  4)        Vendredi      -15
  5)          Samedi      -10
  6)        Dimanche      -17

Journee : Jeudi avec temperature minimale -18 degres Celcius

Informations apres le tri :
Rang        Journee      degre C
  0)        Dimanche      -17
  1)           Jeudi      -18
  2)           Lundi      -16
  3)           Mardi      -14
  4)        Mercredi       -9
  5)          Samedi      -10
  6)        Vendredi      -15


Process completed.
*/
