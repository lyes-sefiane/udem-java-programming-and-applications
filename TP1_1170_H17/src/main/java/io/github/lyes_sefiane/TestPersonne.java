package io.github.lyes_sefiane;

/**
 * Matricule UdeM : 20090833
 * @author Lyes SEFIANE
 * IFT 1170
 * Java et applications
 * lyes.sefiane@umontreal.ca
 * lyes.sefiane@gmail.com
 */

public class TestPersonne {
    /**
     * Affichage des informations des personnes
     */
    public static void afficher (Personne[] personne, int nbPersonne,
                                 String message){
        System.out.print(message);
        System.out.printf("\t\t%3s %18s\n", "Indice","Tableau pers");
        System.out.printf("\t\t------------------------------------------\n");
        for (int i = 0 ; i < nbPersonne ; i++){
            System.out.printf("\t\t%3d) %35s\n", i, personne[i]);
        }
    }

    /**
     * Determiner l'indice de la personne
     * qui consomme le plus de cafe
     */
    public static int determiner(Personne[] personne, int nbPersonne) {
        int indiceMax = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nbPersonne; i++){
            if(personne[i].getNbCafe() > max ){
                max = personne[i].getNbCafe();
                indiceMax = i;
            }
        }
        return indiceMax;
    }

    /**
     * Reduction du nombre de tasses de cafes
     * et mise à jour de l'information
     */
    public static void reduireCafe(Personne[] personne,
                                   int nbPersonne, int reduire) {
        int difference;
        for(int i = 0; i < nbPersonne; i++){
            difference = personne[i].getNbCafe() - reduire;
            if (difference > 0 )
                personne[i].setNbCafe(difference);

            else{
                difference = 0;
                personne[i].setNbCafe(difference);
            }
        }
    }

    /**
     * Compter le nombre de personnes
     * qui sont nees à un mois donné
     */
    public static int compter(Personne[] personne,
                              int nbPersonne, String moisNaiss) {
        int compter = 0;
        for(int i = 0; i < nbPersonne; i++){
            if (personne[i].getNomMois().toUpperCase().equalsIgnoreCase(
                    moisNaiss))
                compter ++;
        }
        return compter;
    }

    public static void main(String[] args) {
        String message;
        Personne pers1 = new Personne ("25-12-1990", 3);
        Personne pers2 = new Personne("18-01-1997");

        System.out.println("\t\t----------------------------");
        System.out.println("\t\t- Exercice numéro C du TP1 -");
        System.out.println("\t\t----------------------------");

        pers2.afficher("2) La deuxieme personne");

        pers1.setNbCafe((pers1.getNbCafe()) - 1);
        pers1.afficher("\n3) Informations de pers1 "+
                "après réduction de sa consomation:\n "+
                "->La premiere personne");

        Personne[] personne = { new Personne ("16-11-1992", 2),
                new Personne ("02-05-1990"),
                new Personne ("23-05-1990", 4),
                new Personne ("19-02-1985", 1),
                new Personne ("30-06-1991", 3)
        };

        int nbPersonne = personne.length;
        System.out.printf("\n");
        message = "4.1)- Les informations des personnes\n";
        afficher(personne,nbPersonne, message);
        System.out.printf("\n");

        int i = determiner(personne, nbPersonne);
        System.out.printf("4.2)- Les informations de la personne "
                +"qui consomme le plus de cafe\n"
                +"\t\t%3d) %35s\n", i, personne[i]);
        System.out.printf("\n");

        int nbCafeReduire = 1;
        reduireCafe(personne,nbPersonne, nbCafeReduire);
        message = "4.3)- Les informations des personnes apres reduction\n";
        afficher(personne,nbPersonne, message);
        System.out.printf("\n");

        String moisNaiss = "mai";
        int resultat = compter(personne, nbPersonne,moisNaiss.toUpperCase());
        System.out.printf("4.4)- Le nombre de personnes qui sont nees "
                + "au mois de %s est : %d", moisNaiss, resultat);
    }
}
/*
		----------------------------
		- Exercice numéro C du TP1 -
		----------------------------
2) La deuxieme personne est nee le 18 janvier 1997 et consomme 0 tasse(s) de cafe

3) Informations de pers1 après réduction de sa consomation:
 ->La premiere personne est nee le 25 decembre 1990 et consomme 2 tasse(s) de cafe

4.1)- Les informations des personnes
		Indice       Tableau pers
		------------------------------------------
		  0)         '16-11-1992'     2 tasse(s)
		  1)         '02-05-1990'     0 tasse(s)
		  2)         '23-05-1990'     4 tasse(s)
		  3)         '19-02-1985'     1 tasse(s)
		  4)         '30-06-1991'     3 tasse(s)

4.2)- Les informations de la personne qui consomme le plus de cafe
		  2)         '23-05-1990'     4 tasse(s)

4.3)- Les informations des personnes apres reduction
		Indice       Tableau pers
		------------------------------------------
		  0)         '16-11-1992'     1 tasse(s)
		  1)         '02-05-1990'     0 tasse(s)
		  2)         '23-05-1990'     3 tasse(s)
		  3)         '19-02-1985'     0 tasse(s)
		  4)         '30-06-1991'     2 tasse(s)

4.4)- Le nombre de personnes qui sont nees au mois de mai est : 2 */
