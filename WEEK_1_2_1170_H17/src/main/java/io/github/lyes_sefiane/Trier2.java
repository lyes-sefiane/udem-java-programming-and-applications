package io.github.lyes_sefiane;

/* Fichier Trier2.java
 * Comme Trier1.java mais un peu plus sur la POO
 * avec la classe Temperature, ses objets, ...
 *
 * Explications : en classe
 */

class Temperature
{
    private String journee;
    private int degreC;

    // 1 constructeur
    public Temperature(String jr, int celcius)
    {
        journee = jr ;
        degreC = celcius;
    }

    // 1 autre constructeur
    public Temperature()
    {

    }

    // pour la méthode mini
    public boolean plusPetit(Temperature autre)
    {
        return degreC < autre.degreC ;
    }

    // pour le tri selon les journées
    public boolean estInferieur(Temperature autre)
    {
        return journee.compareTo(autre.journee) < 0;
    }

    public void afficher()
    {
        System.out.printf("%12s  avec %8d degres Celcius\n", journee, degreC);
    }


}

public class Trier2 {

    static int mini(Temperature[] temp, int nbElem)
    {
        int k = 0;
        for (int i = 1; i < nbElem; i++)
            if ( temp[i].plusPetit(temp[k]) )
                k = i;
        return k;
    }



    static void afficher(Temperature[] temp, int nbJrs, String mess)
    {
        System.out.printf("Informations %s :\n", mess);

        for(int i = 0; i < nbJrs; i++)
        {
            System.out.printf("%3d) ", i);
            temp[i].afficher();

        }
        System.out.printf("\n");
    }


    static void trier(Temperature[] temp, int nbJrs)
    {
        for(int i = 0; i < nbJrs-1; i++)
        {
            int indMin = i;
            for (int j = i+1; j < nbJrs; j++)
                if ( temp[j].estInferieur(temp[indMin] ) )
                    indMin = j;
            if ( indMin != i )
            {
                Temperature tempo = temp[i];
                temp[i] = temp[indMin];
                temp[indMin] = tempo;
            }
        }
    }



    public static void main(String[] args) {
        Temperature[] temp = { new Temperature("Lundi", -16), new Temperature("Mardi", -14), new Temperature("Mercredi",-9),
                new Temperature("Jeudi",-18), new Temperature("Vendredi", -15), new Temperature("Samedi",-10),
                new Temperature("Dimanche", -17) };
        int nbJrs = temp.length;

        afficher(temp, nbJrs, "au debut");


        int indMin = mini (temp, nbJrs);
        System.out.printf("Journee avec temperature minimale : ");
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
