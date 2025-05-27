package io.github.lyes_sefiane;

/**
 * Matricule UdeM : 20090833
 * @author Lyes SEFIANE
 * IFT 1170
 * Java et applications
 * lyes.sefiane@umontreal.ca
 * lyes.sefiane@gmail.com
 */

public class Numero_B {

    /**
     * Permet de formater un numéro de téléphone QC
     */
    public static String extraire(String telephone) {
        String format = "";
        format = "("+telephone.substring(0,3) +")"+" "
                +telephone.substring(3,6)+"-"
                +telephone.substring(6);
        return format;
    }

    /**
     * Determiner l'indice de la personne
     * qui consomme le plus de cafe
     */
    public static int compter(String telephone, char caractere) {
        int occurence = 0;

        for (int i = 0; i < telephone.length(); i++){
            if(telephone.charAt(i) == caractere)
                occurence ++;
        }
        return occurence;
    }

    /**
     * Permet de calculer le nombre de chiffres impairs
     * dans une chaine de caractère
     */
    public static void compterImpairs(String telephone, String nom) {
        String resultat = "";
        int occurence = 0;

        for (int i = 0; i < telephone.length(); i++){
            if(telephone.charAt(i) % 2 != 0){
                resultat = resultat + " " + telephone.charAt(i);
                occurence = occurence + 1;
            }
        }

        System.out.printf(" - Il y a %d fois les chiffres impairs"
                        + " dans le numéro de téléphone %s,%n"
                        + "   Ce sont : %s %n ",
                occurence, nom, resultat);
    }

    /**
     * Permet de calculer le nombre de chiffres pairs
     * dans une chaine de caractère
     */
    public static void compterPairs(String telephone, String nom) {
        String resultat = "";
        int occurence = 0;
        for (int i = 0; i < telephone.length(); i++){
            if(telephone.charAt(i) % 2 == 0){
                resultat = resultat + " " + telephone.charAt(i);
                occurence = occurence + 1;
            }
        }
        System.out.printf("- Il y a %d fois les chiffres pairs "
                        + " dans le numéro de téléphone de %s,%n"
                        + "   Ce sont : %s %n",
                occurence, nom, resultat);
    }

    /**
     * Determine les caractère commun au sein
     * de deux chaines de caractères
     */
    public static String determineCommun(String telephone1, String telephone2) {
        String commun = "";
        for (int i = 0; i < telephone1.length(); i++ ){
            for (int j = 0; j < telephone2.length(); j++){
                if (((telephone1.charAt(i) == telephone2.charAt(j))
                        & (commun.indexOf(telephone1.charAt(i)) < 0)))
                    commun = commun + " " + telephone1.charAt(i);
            }
        }
        return commun;
    }

    /**
     * Determine la valeur minimale au sein
     * d'une chaine de caractère
     */
    public static int deterMin(String telephone) {
        int resultat = Integer.MAX_VALUE;
        for(int i = 0; i < telephone.length(); i++){
            // convertir char en int
            int var = Character.getNumericValue(telephone.charAt(i));
            if (var < resultat) {
                resultat = var;
            }
        }
        return resultat;
    }

    public static void main(String[] args) {
        System.out.println("\t\t----------------------------");
        System.out.println("\t\t- Exercice numéro B du TP1 -");
        System.out.println("\t\t----------------------------");

        String telUDM = "5143436111"; String telJean = "4501897654";

        System.out.printf(" - Téléphone d'UdM   : %s \n" , extraire (telUDM));
        System.out.printf(" - Téléphone de Jean : %s \n" , extraire (telJean));

        System.out.printf(" - Il y a %d fois le chiffre 3 dans "
                        +"le numéro de téléphone d'UdM.%n",
                compter(telUDM,'3'));

        System.out.printf(" - Il y a %d fois le chiffre 1 dans "
                        +"le numéro de téléphone d'UdM.%n",
                compter(telUDM,'1'));

        System.out.printf(" - Il y a %d fois le chiffre 2 dans "
                        +"le numéro de téléphone de Jean.%n",
                compter(telJean,'2'));

        compterImpairs(telUDM, "d'UDEM");

        compterPairs(telJean, "Jean");

        System.out.printf(" - Les chiffres commun entre"
                        +" ces 2 numéros de téléphone  sont : %s%n",
                determineCommun (telUDM, telJean));

        System.out.printf(" - Le chiffre %d est le plus petit chiffre "
                        +"dans le numéro de téléphone d'UdM %n",
                deterMin(telUDM));

        System.out.printf(" - Le chiffre %d est le plus petit chiffre "
                        +"dans le numéro de téléphone de Jean %n",
                deterMin(telJean));
    }
}
/*
		----------------------------
		- Exercice numéro B du TP1 -
		----------------------------
 - Téléphone d'UdM   : (514) 343-6111
 - Téléphone de Jean : (450) 189-7654
 - Il y a 2 fois le chiffre 3 dans le numéro de téléphone d'UdM.
 - Il y a 4 fois le chiffre 1 dans le numéro de téléphone d'UdM.
 - Il y a 0 fois le chiffre 2 dans le numéro de téléphone de Jean.
 - Il y a 7 fois les chiffres impairs dans le numéro de téléphone d'UDEM,
   Ce sont :  5 1 3 3 1 1 1
 - Il y a 5 fois les chiffres pairs  dans le numéro de téléphone de Jean,
   Ce sont :  4 0 8 6 4
 - Les chiffres commun entre ces 2 numéros de téléphone  sont :  5 1 4 6
 - Le chiffre 1 est le plus petit chiffre dans le numéro de téléphone d'UdM
 - Le chiffre 0 est le plus petit chiffre dans le numéro de téléphone de Jean */
