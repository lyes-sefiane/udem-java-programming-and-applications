package io.github.lyes_sefiane;

import java.io.*;
import java.util.Collections;
import java.util.LinkedList;

/**
 * Matricule UdeM : 20090833
 * @author Lyes SEFIANE
 * IFT 1170
 * Java et ses applications
 * lyes.sefiane@umontreal.ca
 * lyes.sefiane@gmail.com
 */


public class TestNationLinkedList {

    /**
     * Lecture du ficher de données
     * Et crée les pays
     */
    public static LinkedList<Nation> lireCreePays (String fichierAlire) throws
            IOException {

        LinkedList<Nation> nation = new LinkedList<Nation>();
        char codePays;
        String nomPays, capitalePays;
        int superficiePays, populationPays, nbLigne = 0;
        boolean existeFichier = false;
        //FileReader fr = null;

        InputStream fr = TestNationLinkedList.class.getClassLoader().getResourceAsStream(fichierAlire);
        if(!existeFichier){
            System.out.printf("+ Debut de lecture du fichier %s ..\n\n", fichierAlire);
            BufferedReader entree = new BufferedReader(new InputStreamReader(fr));
            boolean finFichier = false;

            while (!finFichier ){
                String uneLigne = entree.readLine();
                if(uneLigne == null)
                    finFichier = true;
                else {
                    codePays = uneLigne.charAt(0);
                    nomPays = uneLigne.substring(1,36).trim();
                    capitalePays = uneLigne.substring(36, 62).trim();
                    superficiePays = Integer.parseInt(uneLigne.substring(62, 70).trim());
                    populationPays = Integer.parseInt(uneLigne.substring(75).trim());
                    nation.add(new Nation (codePays, nomPays, capitalePays,
                            superficiePays, populationPays));
                    nbLigne++;
                }
            }
            System.out.printf("+ Nombre de pays lu est : %d \n\n", nbLigne);
            entree.close();
            System.out.printf("+ Fin de lecture du fichier %s \n\n", fichierAlire);
        }
        return nation;
    }

    /**
     * Affichage des informations des Pays
     * En redefinissant la methode toString()
     */
    public static void affichePays(LinkedList<Nation> nation, int nbPaysAfficher) {

        System.out.printf("+ Information des %d pays \n", nbPaysAfficher);

        System.out.printf("%6s %28s  %22s %14s %20s\n", "Code", "NomPays",
                "Capitale", "Superficie", "Population");

        for(int i = 0 ; i < nbPaysAfficher; i++)
            System.out.printf("%s\n", nation.get(i));

        System.out.printf("\n");
    }

    /**
     * Modification du code continent d'un Pays
     */
    public static void modifierCodeContient(LinkedList<Nation>nation, String nomPays,
                                            char newCode){

        boolean existe = false;
        Nation aChercher = new Nation ('0',nomPays,"",0,0); // Création d'un objet pays

        existe = nation.contains(aChercher);

        if(!existe){
            System.out.printf("Pays %s existe pas... \n\n", nomPays);
        }
        else{
            int i = nation.indexOf(aChercher);
            nation.get(i).setCodeContinent(newCode);
            System.out.printf("+ Code Continent du pays '%s' modifié \n", nomPays);
            System.out.printf("%s", nation.get(i));
        }

        System.out.printf("\n\n");
    }

    /**
     * Modification de la capitale d'un pays
     */
    public static void modifierCapitale(LinkedList<Nation> nation, String nomPays,
                                        String newCapitale) {

        boolean existe = false;

        Nation aChercher = new Nation ('0',nomPays,"",0,0);// Création d'un objet pays
        existe = nation.contains(aChercher);

        if(!existe){
            System.out.printf("Pays %s existe pas... \n\n", nomPays);
        }
        else{
            int i = nation.indexOf(aChercher);
            nation.get(i).setCapitalePays(newCapitale);
            System.out.printf("+ Capitale du pays '%s' modifié \n", nomPays);
            System.out.printf("%s", nation.get(i));
        }
        System.out.printf("\n\n");
    }

    /**
     * Modification de la population d'un pays
     * Avec un multiplicateur.
     * Ex :  10 x Population de ce même pays
     */
    public static void modifierPopulation(LinkedList<Nation> nation, String nomPays,
                                          int multiplicateur) {
        boolean existe = false;
        Nation aChercher = new Nation('0',nomPays,"",0,0); // Création d'un objet pays

        existe = nation.contains(aChercher);

        if(!existe){
            System.out.printf("Pays %s existe pas... \n\n", nomPays);
        }
        else{
            int i = nation.indexOf(aChercher);
            nation.get(i).setPopulationPays(	nation.get(i).getPopulationPays() *
                    multiplicateur);

            System.out.printf("+ Population du pays '%s' modifié \n", nomPays);
            System.out.printf("%s", nation.get(i));
        }
        System.out.printf("\n\n");
    }

    /**
     * Recherche dichotomique
     */
    public static void binarySearch(LinkedList<Nation>nation, String nomPays) {

        Nation aChercher = new Nation('0',nomPays,"",0,0);
        int index = Collections.binarySearch(nation,aChercher);

        if(index < 0 ){
            System.out.printf("Pays %s existe pas... \n\n", nomPays);
        }
        else{
            System.out.printf("+ Pays '%s' trouvé à l'indice %d\n", nomPays, index);
            System.out.printf("%s", nation.get(index));
        }
        System.out.printf("\n\n");
    }

    /**
     * Supression d'un pays
     */
    private static void removePays(LinkedList<Nation> nation, String nomPays) {

        Nation aChercher = new Nation('0',nomPays,"",0,0);
        int index = Collections.binarySearch(nation, aChercher);

        if(index < 0 ){
            System.out.printf("Pays %s existe pas... \n\n", nomPays);
        }
        else{
            nation.remove(index);
            System.out.printf("+ Pays '%s' supprimé à l'indice %d\n", nomPays, index);
        }
        System.out.printf("\n\n");
    }

    public static void main(String[] args) throws IOException {

        System.out.println("\t\t----------------------------");
        System.out.println("\t\t- Exercice numéro B du TP3 -");
        System.out.println("\t\t----------------------------\n");

        LinkedList<Nation> nation = lireCreePays("Nations.txt");

        affichePays(nation, 12);

        // Code Continent : ‘5’ pour Europe
        modifierCodeContient(nation, "Russie", '5');

        modifierCapitale(nation, "Chine", "Pekin");

        modifierPopulation(nation, "Allemagne", 10);

        affichePays(nation, 15);

        // Baser sur compareTo
        // et l'implementation de l'interface Comparable
        Collections.sort(nation);

        affichePays(nation, 10);

        binarySearch(nation, "Canada");

        binarySearch(nation, "France");

        binarySearch(nation, "Japon");

        binarySearch(nation, "Mexique");

        removePays(nation, "DES OURAGANS");
    }
}

/*
		----------------------------
		- Exercice numéro B du TP3 -
		----------------------------

+ Debut de lecture du fichier Nations.txt ..

+ Nombre de pays lu est : 197

+ Fin de lecture du fichier Nations.txt

+ Information des 12 pays
  Code                      NomPays                Capitale     Superficie           Population
   2                     ETATS-UNIS             WASHINGTON     9629047 km²           291289535
   3                          CHINE               SHANGHAI     9596960 km²          1273111290
   2                         RUSSIE                 MOSCOU    17075400 km²           143954573
   4                      AUSTRALIE               CANBERRA     7686850 km²            19834248
   3                          JAPON                  TOKYO      377835 km²            12761000
   5                      ALLEMAGNE                 BERLIN      357027 km²             8253700
   5                         FRANCE              MARSEILLE      543964 km²            61387038
   5                         ITALIE                   ROME      301230 km²            57715620
   3                   COREE DU SUD                  SEOUL       99274 km²            48324000
   5                    ROYAUME-UNI                LONDRES      244101 km²            58789194
   2                           CUBA              LA HAVANE      100860 km²            11184023
   5                        UKRAINE                   KIEV      603700 km²            48396470

+ Code Continent du pays 'Russie' modifié
   5                         RUSSIE                 MOSCOU    17075400 km²           143954573

+ Capitale du pays 'Chine' modifié
   3                          CHINE                  Pekin     9596960 km²          1273111290

+ Population du pays 'Allemagne' modifié
   5                      ALLEMAGNE                 BERLIN      357027 km²            82537000

+ Information des 15 pays
  Code                      NomPays                Capitale     Superficie           Population
   2                     ETATS-UNIS             WASHINGTON     9629047 km²           291289535
   3                          CHINE                  Pekin     9596960 km²          1273111290
   5                         RUSSIE                 MOSCOU    17075400 km²           143954573
   4                      AUSTRALIE               CANBERRA     7686850 km²            19834248
   3                          JAPON                  TOKYO      377835 km²            12761000
   5                      ALLEMAGNE                 BERLIN      357027 km²            82537000
   5                         FRANCE              MARSEILLE      543964 km²            61387038
   5                         ITALIE                   ROME      301230 km²            57715620
   3                   COREE DU SUD                  SEOUL       99274 km²            48324000
   5                    ROYAUME-UNI                LONDRES      244101 km²            58789194
   2                           CUBA              LA HAVANE      100860 km²            11184023
   5                        UKRAINE                   KIEV      603700 km²            48396470
   5                        HONGRIE               BUDAPEST       93030 km²            10106017
   5                       ROUMANIE               BUCAREST      238390 km²            22272000
   5                          GRECE                ATHENES      131940 km²            10623835

+ Information des 10 pays
  Code                      NomPays                Capitale     Superficie           Population
   3                    AFGHANISTAN                 KABOUL      652225 km²            29547078
   1                 AFRIQUE DU SUD               PRETORIA     1219912 km²            42718530
   5                        ALBANIE                 TIRANA       28748 km²             3510484
   1                        ALGERIE                  ALGER     2381740 km²            31763053
   5                      ALLEMAGNE                 BERLIN      357027 km²            82537000
   5                        ANDORRE       ANDORRA LA VELLA         468 km²               67627
   1                         ANGOLA                 LUANDA     1246700 km²            10766471
   2             ANTIGUA-ET-BARBUDA            SAINT-JOHNS         442 km²               67448
   2         ANTILLES NEERLANDAISES             WILLEMSTAD         800 km²              210000
   3                ARABIE SAOUDITE                  RIYAD     1960582 km²            23513330

+ Pays 'Canada' trouvé à l'indice 36
   2                         CANADA                 OTTAWA     9984670 km²            31499560

+ Pays 'France' trouvé à l'indice 64
   5                         FRANCE              MARSEILLE      543964 km²            61387038

+ Pays 'Japon' trouvé à l'indice 93
   3                          JAPON                  TOKYO      377835 km²            12761000

+ Pays 'Mexique' trouvé à l'indice 118
   2                        MEXIQUE                 MEXICO     1972550 km²           103400165

Pays DES OURAGANS existe pas... */

