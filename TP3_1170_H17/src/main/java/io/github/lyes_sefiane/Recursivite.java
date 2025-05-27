package io.github.lyes_sefiane;


/**
 * Matricule UdeM : 20090833
 * @author Lyes SEFIANE
 * IFT 1170
 * Java et ses applications
 * lyes.sefiane@umontreal.ca
 * lyes.sefiane@gmail.com
 */

public class Recursivite {

    /**
     * Methode recursive
     */
    public static int multiplicationRecursive (int n) {

        if(n < 10)
            return n;
        else
            return ((n % 10) * multiplicationRecursive(n / 10));
    }

    /**
     * Méthode Itérative
     */
    public static void multiplicationIterative(int chiffre) {
        int resultat = 1;
        int n = chiffre;

        while (n > 0){
            resultat = resultat * (n % 10);
            n = n / 10;
        }
        System.out.printf("Produit des chiffres %d (Méthode itérative) est :  %d\n",
                chiffre, resultat);
    }

    public static void main(String[] args) {
        System.out.println("\t\t----------------------------");
        System.out.println("\t\t- Exercice numéro C du TP3 -");
        System.out.println("\t\t----------------------------\n");

        System.out.printf("Produit des chiffres %d (Méthode recursive) est :  %d\n\n",
                2345, multiplicationRecursive (2345));

        multiplicationIterative (2345);

    }
}
/*
		----------------------------
		- Exercice numéro C du TP3 -
		----------------------------

Produit des chiffres 2345 (Méthode recursive) est :  120

Produit des chiffres 2345 (Méthode itérative) est :  120 */

