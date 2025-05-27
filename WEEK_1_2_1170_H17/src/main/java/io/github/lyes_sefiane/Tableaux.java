package io.github.lyes_sefiane;


public class Tableaux {


/* +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
   + Auteur(s) : Nicole Leblanc IFT 1810                                   +
   +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
   + But de la fonction : Cette fonction compte et retourne le nombre      +
   +                      de personnes ayant un statut voulu               +
   +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
   + Dernière mise à jour : jj mm aaaa                                     +
   +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 */

    static int nombre ( char statutVoulu, char[] statut, int nbPers)
    {
        int n = 0 ;
        for(int i = 0; i < nbPers; i++)
            if (statut[i] == statutVoulu)
                n++;
        return n;
    }

/* +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
   + Auteur(s) : Jean Tremblay  IFT 1810 B Groupe 1                        +
   +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
   + But de la fonction : Cette fonction affiche le contenu des 3 tableaux +
   +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
   + Dernière mise à jour :                                                +
   +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 */

    static void afficher(char[] statut, double[] taille, double[] poids, int nbPers, String mess)
    {

        System.out.printf("Contenu des 3 tableaux %s :\n", mess);
        System.out.printf("  indice taille   poids  statut\n");
        for (int i = 0; i < nbPers; i++)
        {
            System.out.printf("%5d%8.2f %9.1f", i, taille[i], poids[i]);
            switch (statut[i])
            {
                case 'M' : System.out.printf("  marie\n"); break;
                case 'C' : System.out.printf("  celibataire\n"); break;
                case 'D' : System.out.printf("  divorce\n"); break;
                case 'S' : System.out.printf("  separe\n"); break;
                case 'V' : System.out.printf("  veuf\n"); break;
                case 'A' : System.out.printf("  autre\n");
            }
        }
        System.out.printf("\n");


    }

    /* +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
       + Auteur(s) : Jean Tremblay  IFT 1810 B Groupe 1                        +
       +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
       + But de la fonction : Cette fonction compte et retourne le nombre      +
       +                      d'elements d'un tableau qui depassent            +
       +                      une borne donnee                                 +
       +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
       + Dernière mise à jour :                                                +
       +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
     */
    static int nbFois(double[] tab, int nbElem, double borne)
    {  int n = 0;

        for(int i = 0; i < nbElem ; i++)
            if ( tab[i] > borne )
                n++;
        return n;
    }


/* +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
   + Auteur(s) : Nicole Leblanc IFT 1810 B Groupe 1                        +
   +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
   + But de la fonction : Cette fonction calcule et retourne la moyenne    +
   +                      d'un tableau des reels                           +
   +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
   + Dernière mise à jour :                                                +
   +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 */

    static double moyenne(double[] tableau, int nbElem)
    {
        double somme = 0.0;
        for (int i = 0; i < nbElem ; i++)
            somme += tableau[i];

        return somme / nbElem ;
    }



/* +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
   + Auteur(s) : Jean Tremblay  IFT 1810 B Groupe 1                        +
   +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
   + But de la fonction : Cette fonction determine et retourne la valeur   +
   +                      maximale d'un tableau des reels                  +
   +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
   + Dernière mise à jour :                                                +
   +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 */

    static double maxi(double[] tableau, int nbElem)
    {
        double plusGrand = Double.MIN_VALUE; /* le reel le plus petit */


        for (int i = 0; i < nbElem ; i++)
            if (tableau[i] > plusGrand)
                plusGrand = tableau[i];
        return plusGrand;

    }

/* +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
   + Auteur(s) : Jean Tremblay  IFT 1810 B Groupe 1                        +
   +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
   + But de la fonction : Cette fonction affiche le contenu des 3 tableaux +
   +                      pour un statut voulu (voir l'exécution)          +
   +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
   + Dernière mise à jour :                                                +
   +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 */

    static void afficher2(char statutVoulu, char[] statut, double[] taille,
                          double[] poids, int nbPers)
    {
        int  k = 0 ;
        System.out.printf("\nContenu des 3 tableaux pour le statut voulu : %c\n", statutVoulu);
        System.out.printf("   rang  statut  taille   poids  \n");
        for ( int i = 0; i < nbPers; i++)
        {
            if (statut[i] == statutVoulu)
            { k++;
                System.out.printf("%5d) %5c %8.2f %9.1f\n", k, statut[i], taille[i], poids[i]);
            }
        }
        System.out.printf("\n\n");
    }



    static void trier(char[] statut, double[] taille, double[] poids, int nbPers)
    {

        for(int i = 0; i < nbPers-1; i++)
        {
            int indMin = i;
            for(int j = i+1; j < nbPers; j++)
                if (taille[j] < taille[indMin])
                    indMin = j;
            if (indMin != i)
            {
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
        char[] statut = { 'M', 'C', 'D', 'M', 'S', 'M', 'A' };
        double[] taille= { 1.72, 1.65, 1.59, 1.80, 1.82, 1.68, 1.75},
                poids = { 68.3, 52.1, 72.9, 70.4, 81.5, 65.4, 70.3 } ;
        int nbPers = taille.length;


        afficher(statut, taille, poids, nbPers, "avant le tri");

        System.out.printf("Le nombre de personnes mariees : %d\n", nombre('M', statut, nbPers));
        System.out.printf("Le nombre de personness separees : %d\n", nombre('S', statut, nbPers));

        System.out.printf("Le nombre de personnes veuves : %d\n", nombre('V', statut, nbPers));

        System.out.printf("La taille moyenne : %.2f metre\n", moyenne(taille, nbPers));
        System.out.printf("Le poids moyen : %.1f kg\n", moyenne(poids, nbPers));

        System.out.printf("La taille la plus grande : %.2f metre\n", maxi(taille, nbPers));
        System.out.printf("Le poids le plus lourd   : %.1f kg\n", maxi(poids, nbPers));

        System.out.printf("Le nombre de personnes dont la taille depasse 1.76 metre : %d\n",
                nbFois(taille, nbPers, 1.76));
        System.out.printf("Le nombre de personnes dont le poids depasse 70.0 kg : %d\n",
                nbFois(poids, nbPers, 70.0));

        afficher2('M', statut, taille, poids, nbPers);


        trier(statut, taille, poids, nbPers); // trier selon les tailles
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

