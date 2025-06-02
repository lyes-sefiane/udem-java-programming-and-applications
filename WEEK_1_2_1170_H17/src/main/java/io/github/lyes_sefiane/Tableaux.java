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
public class Tableaux {

    private static final Logger logger = LogManager.getLogger(Tableaux.class);

    static int nombre(char statutVoulu, char[] statut, int nbPers) {
        int n = 0;
        for (int i = 0; i < nbPers; i++)
            if (statut[i] == statutVoulu)
                n++;
        return n;
    }


    static void afficher(char[] statut, double[] taille, double[] poids, int nbPers, String mess) {
        logger.info("Contenu des 3 tableaux {} :", mess);
        logger.info("  indice taille   poids  statut");
        for (int i = 0; i < nbPers; i++) {
            logger.info("{} {} {}", i, taille[i], poids[i]);
            switch (statut[i]) {
                case 'M':
                    logger.info("  marie");
                    break;
                case 'C':
                    logger.info("  celibataire");
                    break;
                case 'D':
                    logger.info("  divorce");
                    break;
                case 'S':
                    logger.info("  separe");
                    break;
                case 'V':
                    logger.info("  veuf");
                    break;
                case 'A':
                    logger.info("  autre");
            }
        }
    }


    static int nbFois(double[] tab, int nbElem, double borne) {
        int n = 0;
        for (int i = 0; i < nbElem; i++)
            if (tab[i] > borne)
                n++;
        return n;
    }


    static double moyenne(double[] tableau, int nbElem) {
        double somme = 0.0;
        for (int i = 0; i < nbElem; i++)
            somme += tableau[i];

        return somme / nbElem;
    }


    static double maxi(double[] tableau, int nbElem) {
        double plusGrand = Double.MIN_VALUE;
        for (int i = 0; i < nbElem; i++)
            if (tableau[i] > plusGrand)
                plusGrand = tableau[i];
        return plusGrand;
    }


    static void afficher2(char statutVoulu, char[] statut, double[] taille, double[] poids, int nbPers) {
        int k = 0;
        logger.info("Contenu des 3 tableaux pour le statut voulu : {}", statutVoulu);
        logger.info("   rang  statut  taille   poids  ");
        for (int i = 0; i < nbPers; i++) {
            if (statut[i] == statutVoulu) {
                k++;
                logger.info("{}) {} {} {}", k, statut[i], taille[i], poids[i]);
            }
        }
    }


    static void trier(char[] statut, double[] taille, double[] poids, int nbPers) {

        for (int i = 0; i < nbPers - 1; i++) {
            int indMin = i;
            for (int j = i + 1; j < nbPers; j++)
                if (taille[j] < taille[indMin])
                    indMin = j;
            if (indMin != i) {
                char tempo = statut[i];
                statut[i] = statut[indMin];
                statut[indMin] = tempo;

                double tempo2 = taille[i];
                taille[i] = taille[indMin];
                taille[indMin] = tempo2;

                tempo2 = poids[i];
                poids[i] = poids[indMin];

                poids[indMin] = tempo2;
            }
        }


    }


    public static void main(String[] args) {
        char[] statut = {'M', 'C', 'D', 'M', 'S', 'M', 'A'};
        double[] taille = {1.72, 1.65, 1.59, 1.80, 1.82, 1.68, 1.75},
                poids = {68.3, 52.1, 72.9, 70.4, 81.5, 65.4, 70.3};
        int nbPers = taille.length;

        afficher(statut, taille, poids, nbPers, "avant le tri");

        logger.info("Le nombre de personnes mariees : {}", nombre('M', statut, nbPers));
        logger.info("Le nombre de personness separees : {}}", nombre('S', statut, nbPers));
        logger.info("Le nombre de personnes veuves : {}}", nombre('V', statut, nbPers));
        logger.info("La taille moyenne : {} metre", moyenne(taille, nbPers));
        logger.info("Le poids moyen : {} kg\n", moyenne(poids, nbPers));
        logger.info("La taille la plus grande : {} metre", maxi(taille, nbPers));
        logger.info("Le poids le plus lourd   : {} kg", maxi(poids, nbPers));
        logger.info("Le nombre de personnes dont la taille depasse 1.76 metre : {}", nbFois(taille, nbPers, 1.76));
        logger.info("Le nombre de personnes dont le poids depasse 70.0 kg : {}", nbFois(poids, nbPers, 70.0));

        afficher2('M', statut, taille, poids, nbPers);

        trier(statut, taille, poids, nbPers);

        afficher(statut, taille, poids, nbPers, "après le tri selon les tailles");
    }
}
/* Exécution:
--------------------Configuration: <Default>--------------------
Contenu des 3 tableaux avant le tri :
  indice taille   poids  statut
    0    1,72      68,3  marie
    1    1,65      52,1  celibataire
    2    1,59      72,9  divorce
    3    1,80      70,4  marie
    4    1,82      81,5  separe
    5    1,68      65,4  marie
    6    1,75      70,3  autre

Le nombre de personnes mariees : 3
Le nombre de personness separees : 1
Le nombre de personnes veuves : 0
La taille moyenne : 1,72 metre
Le poids moyen : 68,7 kg
La taille la plus grande : 1,82 metre
Le poids le plus lourd   : 81,5 kg
Le nombre de personnes dont la taille depasse 1.76 metre : 2
Le nombre de personnes dont le poids depasse 70.0 kg : 4

Contenu des 3 tableaux pour le statut voulu : M
   rang  statut  taille   poids
    1)     M     1,72      68,3
    2)     M     1,80      70,4
    3)     M     1,68      65,4


Contenu des 3 tableaux après le tri selon les tailles :
  indice taille   poids  statut
    0    1,59      72,9  divorce
    1    1,65      52,1  celibataire
    2    1,68      65,4  marie
    3    1,72      68,3  marie
    4    1,75      70,3  autre
    5    1,80      70,4  marie
    6    1,82      81,5  separe


Process completed.
*/

