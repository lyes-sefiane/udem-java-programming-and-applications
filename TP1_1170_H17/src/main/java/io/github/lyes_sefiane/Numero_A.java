package io.github.lyes_sefiane;


/**
 * Matricule UdeM : 20090833
 * @author Lyes SEFIANE
 * IFT 1170
 * Session : Hiver 2017
 * Java et applications
 * lyes.sefiane@umontreal.ca
 * lyes.sefiane@gmail.com
 */

public class Numero_A {
    /**
     * Permet de compter et retourner
     * le nombre d'occurence d'un element
     * dans un tableau.
     */
    public static int compter(char car, char[] poste, int[] nbCafe, int nbEmp) {
        int n =0;
        for (int i = 0; i < nbEmp; i++){
            if (poste[i] == car)
                n++;
        }
        return n;
    }

    /**
     * Permet de calculer la plus grande valeur d'un tableau
     */
    public static int consoMax(char[] poste, int[] nbCafe, int nbEmp) {
        int maxCafe = Integer.MIN_VALUE;
        for (int i = 0 ; i < nbEmp ; i++) {

            if ( nbCafe[i] > maxCafe )
                maxCafe = nbCafe[i];
        }
        return maxCafe;
    }

    /**
     * Permet de calculer la plus petite valeur
     * d'un tableau, parmi un groupe précis .
     * Exemple : La consommation minimale de cafe des programmeurs
     */
    public static int consoMin(char car, char[] poste, int[] nbCafe, int nbEmp) {
        int minCafe = Integer.MAX_VALUE;

        for( int i = 0; i < nbEmp; i++){
            if ( poste[i] == car ){
                if (nbCafe[i] < minCafe)
                    minCafe = nbCafe[i];
            }
        }
        return minCafe;
    }

    /**
     * Permet de calculer une moyenne d'un groupe.
     * Exemple : La consommation moyenne des Analystes
     */
    public static void consoMoy(char car, char[] poste, int[] nbCafe,
                                int nbEmp, int nbConsomateur) {
        double moyenne = 0; double sommeCafeCar = 0;

        if (nbConsomateur == 0){
            System.out.printf(" Le poste de travail '%c' existe pas ", car);
        }
        else {
            for (int i = 0; i < nbEmp; i++){
                if(poste[i] == car)
                    sommeCafeCar = sommeCafeCar + nbCafe[i];
            }

            /* -0.5 pour la division */
            moyenne = sommeCafeCar / nbConsomateur;
            System.out.printf(" %.1f\n", moyenne);
        }

    }

    public static void main(String[] args) {
        char [] poste = {'P', 'P', 'O', 'A', 'P', 'A', 'A', 'P'};
        int [] nbCafe = {2, 1, 4, 0, 5, 2, 3, 1};
        int nbEmp = poste.length;
        int  nbProgrammeurs, nbAnalystes, nbOperateurs;

        System.out.println("\t\t----------------------------");
        System.out.println("\t\t- Exercice numéro A du TP1 -");
        System.out.println("\t\t----------------------------");

        nbProgrammeurs = compter ('P',poste, nbCafe, nbEmp);
        System.out.printf(" - Il y a %s Programmeur(s) \n", nbProgrammeurs );

        nbAnalystes = compter('A',poste, nbCafe, nbEmp);
        System.out.printf(" - Il y a %s Analyste(s) \n", nbAnalystes);

        nbOperateurs = compter('O',poste, nbCafe, nbEmp);
        System.out.printf(" - Il y a %s Operateur(s) \n", nbOperateurs);

        System.out.printf(" - La consommation maximale de cafe "
                        + "de tous ces employes est : %s\n ",
                consoMax(poste,nbCafe, nbEmp) );

        System.out.printf("- La consommation minimale de cafe "
                        + "des programmeurs est : %s \n",
                consoMin('P',poste,nbCafe, nbEmp) );

        System.out.printf(" - La consommation moyenne des Analystes est   :");
        consoMoy('A',poste,nbCafe, nbEmp, nbAnalystes);

        System.out.printf(" - La consommation moyenne des Opérateurs est  :");
        consoMoy('O',poste,nbCafe, nbEmp, nbOperateurs);

        System.out.printf(" - La consommation moyenne des Secretaires est :");
        // On calcul le nombre de secretaire
        // - 0.5 (je ne comprends pas son argumentation)
        // Bien que cela fonctionne
        int nbSecretaire = compter('S',poste, nbCafe, nbEmp);
        consoMoy('S',poste,nbCafe, nbEmp, nbSecretaire);
    }
}

/*
		----------------------------
		- Exercice numéro A du TP1 -
		----------------------------
 - Il y a 4 Programmeur(s)
 - Il y a 3 Analyste(s)
 - Il y a 1 Operateur(s)
 - La consommation maximale de cafe de tous ces employes est : 5
 - La consommation minimale de cafe des programmeurs est : 1
 - La consommation moyenne des Analystes est   : 1,7
 - La consommation moyenne des Opérateurs est  : 4,0
 - La consommation moyenne des Secretaires est : Le poste de travail 'S' existe pas
*/
