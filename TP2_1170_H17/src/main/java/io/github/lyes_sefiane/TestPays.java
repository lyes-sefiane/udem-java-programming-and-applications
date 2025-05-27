package io.github.lyes_sefiane;

import java.io.*;



/**
 * Matricule UdeM : 20090833
 * @author Lyes SEFIANE
 * IFT 1170
 * Java et ses applications
 * lyes.sefiane@umontreal.ca
 * lyes.sefiane@gmail.com
 */

public class TestPays {

    /**
     * Instantiation des objets Pays
     */
    public static void creePays(Pays[] pays, int nbLigne, String ligne) {

        char codePays;
        String nomPays;
        String capitalePays;
        int superficiePays;
        int populationPays;

        codePays = ligne.charAt(0);
        nomPays = ligne.substring(1,36).trim();
        capitalePays = ligne.substring(36, 62).trim();
        superficiePays = Integer.parseInt(ligne.substring(62, 70).trim());
        populationPays = Integer.parseInt(ligne.substring(75).trim());
        pays[nbLigne] = new Pays(codePays, nomPays, capitalePays,
                superficiePays, populationPays);
    }

    /**
     * Lecture du ficher de données
     */
    public static int lirePays(String fichierAlire, Pays[] pays) throws IOException {

        int nbLigne = 0;
        boolean existeFichier = false;

        InputStream fr = TestPays.class.getClassLoader().getResourceAsStream(fichierAlire);
        if(!existeFichier) {
            System.out.printf("+ Debut de lecture du fichier %s ..\n\n", fichierAlire);
            BufferedReader entree = new BufferedReader(new InputStreamReader(fr));
            boolean finFichier = false;

            while (!finFichier ){
                String uneLigne = entree.readLine();
                if(uneLigne == null)
                    finFichier = true;
                else {
                    creePays(pays, nbLigne, uneLigne);
                    nbLigne++;
                }
            }
            System.out.printf("+ Nombre de pays lu est : %d \n\n", nbLigne);
            entree.close();
            System.out.printf("+ Fin de lecture du fichier %s \n\n", fichierAlire);
        }
        return nbLigne;
    }

    /**
     * Affichage des informations des Pays
     * En redefinissant la methode toString()
     */
    public static void affichePays(Pays[] pays, int nbPaysAfficher) {

        System.out.printf("+ Information des %d pays \n", nbPaysAfficher);

        System.out.printf("%6s %28s  %22s %14s %20s\n", "Code", "NomPays",
                "Capitale", "Superficie", "Population");

        for(int i = 0 ; i < nbPaysAfficher; i++)
            System.out.printf("%s\n", pays[i]);

        System.out.printf("\n");
    }

    /**
     * Recherche de l'indice d'un pays dans le tableau
     */
    private static int rechercheIndice(Pays[] pays, Pays aChercher, int nbPays) {

        int trouve = -1;
        int i = 0;

        while (i < nbPays){
            if (pays[i].equals(aChercher))// Recherche Basée sur redéfinition de equals
                trouve = i;
            i++;
        }
        return trouve;
    }

    /**
     * Modification du code continent d'un Pays
     */
    public static void modifierCodeContient(Pays[] pays, String nomPays,
                                            char newCode, int nbPays) {

        Pays aChercher = new Pays('0',nomPays,"",0,0); // Création d'un objet pays
        int indice = rechercheIndice (pays, aChercher, nbPays);
        if(indice == -1){
            System.out.printf("Pays %s existe pas... \n\n", nomPays);
        }
        else{
            pays[indice].setCodeContinent(newCode);
            System.out.printf("+ Code Continent du pays '%s' modifié \n", nomPays);
            System.out.printf("%s", pays[indice]);
        }
        System.out.printf("\n\n");
    }

    /**
     * Modification de la capitale d'un pays
     */
    public static void modifierCapitale(Pays[] pays, String nomPays,
                                        String newCapitale, int nbPays) {

        Pays aChercher = new Pays('0',nomPays,"",0,0);// Création d'un objet pays
        int indice = rechercheIndice (pays, aChercher, nbPays);

        if(indice == -1){
            System.out.printf("Pays %s existe pas... \n\n", nomPays);
        }
        else{
            pays[indice].setCapitalePays(newCapitale);
            System.out.printf("+ Capitale du pays '%s' modifié \n", nomPays);
            System.out.printf("%s", pays[indice]);
        }
        System.out.printf("\n\n");
    }

    /**
     * Modification de la population d'un pays
     * Avec un multiplicateur.
     * Ex :  10 x Population de ce même pays
     */
    public static void modifierPopulation(Pays[] pays, String nomPays,
                                          int multiplicateur, int nbPays) {

        Pays aChercher = new Pays('0',nomPays,"",0,0); // Création d'un objet pays
        int indice = rechercheIndice (pays, aChercher, nbPays);

        if(indice == -1){
            System.out.printf("Pays %s existe pas... \n\n", nomPays);
        }
        else{
            pays[indice].setPopulationPays(
                    pays[indice].getPopulationPays() * multiplicateur);
            System.out.printf("+ Population du pays '%s' modifié \n", nomPays);
            System.out.printf("%s", pays[indice]);

        }
        System.out.printf("\n\n");
    }

    /**
     * Supression d'un pays du tableau :
     * 1. On cherche son indice
     * 2. S'il existe on supprime
     */
    public static int supprimerPays(Pays[] pays, String nomPays, int nbPays) {
        Pays aChercher = new Pays('0',nomPays,"",0,0);// Création d'un objet pays
        int indice = rechercheIndice (pays, aChercher, nbPays);//Chercher son indice
        if(indice == -1){
            System.out.printf("Pays %s à supprimer existe pas... \n\n", nomPays);
            return nbPays;
        }

        System.out.printf("+ Suppression de '%s' ... \n\n", nomPays);
        for(int i = indice; i < nbPays -1; i++)
            pays[i] = pays[i+1];

        return (nbPays - 1);
    }

    /**
     * Augmentation de la population des pays
     * d'un continent donné. Ex :
     * Augmentation de la population des pays du continent Europe (code '5')
     */
    public static void augmentationPopulation(	Pays[] pays,
                                                  double pourcentage,
                                                  int nbPays,
                                                  char codePays) {
        System.out.printf("+ Augmentation de la population des pays "+
                "du continent %c \n\n", codePays);

        for(int i = 0; i < nbPays; i++){
            if(pays[i].getCodeContinent() == codePays)
                pays[i].setPopulationPays(
                        (int) Math.round( (pays[i].getPopulationPays() +
                                (pays[i].getPopulationPays() * pourcentage) /100)));
        }
    }

    /**
     * Affichage des pays dont le nom est identique à la capitale
     * Recherche séquentielle de tout les pays et test égalité
     * entre nomPays et capitalePays
     */
    public static void afficheIdentique(Pays[] pays, int nbPays) {
        System.out.println("+ Pays dont le nom est identique au nom de la capitale\n");
        for(int i = 0; i< nbPays; i++){
            if(pays[i].getNomPays().equalsIgnoreCase(pays[i].getCapitalePays()))
                System.out.printf("%s\n", pays[i]);
        }
        System.out.printf("\n");
    }

    /**
     * Determine le pays ayant la plus petite densité dans un continent donné
     */
    public static void densiteMin(Pays[] pays, int nbPays, char codeContinent) {
        float mini = Float.MAX_VALUE; // variable de comparaison des densités
        int indiceMini = 0; // indice du pays dont la densité est petite.
        for(int i = 0; i < nbPays; i++){
            if(pays[i].getCodeContinent() == codeContinent){
                if(pays[i].densite() < mini){
                    mini = pays[i].densite();
                    indiceMini = i;
                }
            }
        }
        System.out.printf("+ Pays '%s' a la plus petite densité (%.2f hab/Km²) "+
                        "du continent %c \n%s\n\n",
                pays[indiceMini].getNomPays(),
                mini,
                codeContinent,
                pays[indiceMini]);
    }

    /**
     * Determine le pays le plus peuplé d'un continent donné
     */
    private static void paysPeuple(Pays[] pays, int nbPays, char codeContinent) {
        int maxi = Integer.MIN_VALUE; // variable de comparaison des populations
        int indiceMaxi = 0; // indice du pays dont la densité est petite.
        for(int i = 0; i < nbPays; i++ ){
            if(pays[i].getCodeContinent() == codeContinent){
                if(pays[i].getPopulationPays() > maxi){
                    maxi = pays[i].getPopulationPays();
                    indiceMaxi = i;
                }
            }
        }
        System.out.printf("+ Pays '%s' a la plus grande population (%d hab) "+
                        "du continent %c \n%s\n\n",
                pays[indiceMaxi].getNomPays(),
                pays[indiceMaxi].getPopulationPays(),
                codeContinent,
                pays[indiceMaxi]);
    }

    /**
     * Cherche et Affiche les payes dont le nom commence par une Voyelle
     */
    public static void paysStartVoyelle(Pays[] pays, int nbPays) {
        String voyelle="AaEeIiOoUuYy";
        System.out.println("+ Pays dont le nom commence par une voyelle");
        for(int i = 0; i < nbPays; i++){
            if(voyelle.indexOf(pays[i].getNomPays().charAt(0)) >= 0)
                System.out.printf("%s\n", pays[i]);
        }
        System.out.printf("\n\n");
    }

    /**
     * Determine le nombre de lettres alphabétiques
     * Dans une chaine de caractere
     */
    public static int compterAlphabet(String chaine){
        int size = 0;
        for(int i = 0; i < chaine.length(); i++){
            if( Character.isLetter(chaine.charAt(i)))
                size++;
        }
        return size;
    }

    /**
     * Determine et Affiche les informations du pays dont
     * le nom de la capitale à le plus de lettres alphabétiques
     */
    private static void capitaleMaxAlpha(Pays[] pays, int nbPays, char codeContinent) {
        int maxLenght = Integer.MIN_VALUE;
        int indiceMaxi=0;
        for(int i =0; i < nbPays; i++){
            if(pays[i].getCodeContinent() == codeContinent){
                int size = compterAlphabet(pays[i].getCapitalePays());
                if(size > maxLenght) {
                    maxLenght = size;
                    indiceMaxi = i;
                }
            }
        }
        System.out.printf("+ Pays '%s' a la capitale\n"+
                        "contenant le plus de lettres alphabétiques (%d Lettres) "+
                        "du continent %c \n\n%s\n\n", pays[indiceMaxi].getNomPays(),
                maxLenght,
                codeContinent,
                pays[indiceMaxi]);
    }

    /**
     * Permutation entre deux pays
     */
    public static void permuter(Pays[] pays, int i, int j) {
        Pays tempo = pays[i];
        pays[i] = pays[j];
        pays[j] = tempo;
    }

    /**
     * Tri rapide du tableau des pays
     * Basé sur l'implémentation de compareTo()
     */
    public static void quickSort(Pays [] pays, int nbPays){
        System.out.println("+ Tri des pays en cours ...");
        for(int i = 0; i < (nbPays - 1); i++)
        {
            int indMin = i;
            for(int j = i+1; j < nbPays; j++)
                if(pays[j].compareTo(pays[indMin]) < 0)
                    indMin = j;
            if (indMin != i)
                permuter(pays, i, indMin);
        }
    }

    /**
     * Recherche dichotomique de l'indice d'un pays
     */
    static int indiceDicho(Pays[] pays, int nbPays, Pays aCherche) {

        int mini = 0, maxi = nbPays - 1;
        while (mini <= maxi){
            int milieu = (mini + maxi) / 2;
            if (aCherche.compareTo(pays[milieu]) <= -1)
                maxi = milieu - 1;
            else
            if (aCherche.compareTo(pays[milieu]) >= 1)
                mini = milieu + 1;
            else
                return milieu;
        }
        return -1;
    }


    /**
     * Affichage du résultat de la recherche dichotomique
     */
    public static void rechercheDichotomique(Pays[] pays, int nbPays,
                                             String nomPays) {
        Pays aChercher = new Pays('0',nomPays,"",0,0);// Création d'un objet pays
        int k = indiceDicho(pays, nbPays, aChercher); // Chercher son indice
        if (k != -1) {
            System.out.printf("+ On trouve '%s' à l'indice %d\n", nomPays, k);
            System.out.printf("%s\n", pays[k]);
        }
        else
            System.out.printf("On ne trouve pas le pays : '%s'\n\n", nomPays);

        System.out.printf("\n");
    }

    /**
     * Création d'un fichier.txt
     */
    public static void creeFichier(	String nomFichier,
                                       Pays[] pays,
                                       int nbPays,
                                       char codeContinent) throws IOException {
        boolean probleme = false;
        FileWriter fw = null;
        try
        {
            fw = new FileWriter(nomFichier);
        } catch (java.io.FileNotFoundException erreur)
        {
            System.out.println("+ Probleme de preparer l'ecriture\n");
            probleme = true;
        }
        if (!probleme)
        {
            System.out.printf("+ Creation du Fichier %s\n", nomFichier);
            PrintWriter aCreer = new PrintWriter( fw );
            System.out.printf("+ Ecriture en cours...\n");
            for(int i = 0; i < nbPays; i++){
                if(pays[i].getCodeContinent() == codeContinent)
                    aCreer.printf("%s\n", pays[i]);
            }
            aCreer.close();
            System.out.println("+ Fin d'ecriture\n\n");
        }
    }

    public static void main(String[] args) throws IOException {

        final int MAX_PAYS = 250;

        Pays[] pays = new Pays[MAX_PAYS];

        System.out.println("\t\t----------------------------");
        System.out.println("\t\t- Exercice numéro B du TP2 -");
        System.out.println("\t\t----------------------------\n");


        int nbPays = lirePays ("pays_h17.txt", pays);

        affichePays(pays, 12);

        // Code Continent : ‘5’ pour Europe
        modifierCodeContient(pays, "Russie", '5', nbPays);

        modifierCapitale(pays, "Chine", "Pekin", nbPays);

        modifierPopulation(pays, "Allemagne", 10, nbPays);

        nbPays = supprimerPays(pays,"DES OURAGANS", nbPays);

        // Code Continent : ‘1’ pour Afrique
        augmentationPopulation(pays, 3.5, nbPays, '1');

        // Code Continent : ‘3’ pour Asie
        augmentationPopulation(pays, 3.5, nbPays, '3');

        affichePays(pays, 16);

        afficheIdentique(pays, nbPays);

        // Code Continent : ‘1’ pour Afrique
        densiteMin(pays, nbPays, '1');

        // Code Continent : ‘2’ pour Amérique
        densiteMin(pays, nbPays, '2');

        // Code Continent : ‘5’ pour Europe
        paysPeuple(pays, nbPays, '5');

        // Code Continent : ‘1’ pour Afrique
        paysPeuple(pays, nbPays, '1');

        paysStartVoyelle(pays, nbPays);

        // Code Continent : ‘4’ pour Océanie
        capitaleMaxAlpha(pays, nbPays, '4');

        quickSort(pays, nbPays);

        affichePays(pays, 10);

        rechercheDichotomique(pays, nbPays, "Canada");

        rechercheDichotomique(pays, nbPays, "France");

        rechercheDichotomique(pays, nbPays, "Japon");

        rechercheDichotomique(pays, nbPays, "Mexique");

        // Code Continent : ‘4’ pour Océanie
        creeFichier("Oceanie.txt", pays, nbPays, '4');

        // Code Continent : ‘3’ pour Asie
        creeFichier("Asie.txt ", pays, nbPays, '3');
    }
}
/*
		----------------------------
		- Exercice numéro B du TP2 -
		----------------------------

+ Debut de lecture du fichier pays_h17.txt ..

+ Nombre de pays lu est : 198

+ Fin de lecture du fichier pays_h17.txt

+ Information des 12 pays
  Code                      NomPays                Capitale     Superficie           Population
   2                     ETATS-UNIS             WASHINGTON     9629047 km²           291289535
   3                          CHINE               SHANGHAI     9596960 km²          1273111290
   2                         RUSSIE                 MOSCOU    17075400 km²           143954573
   4                      AUSTRALIE               CANBERRA     7686850 km²            19834248
   3                          JAPON                  TOKYO      377835 km²            12761000
   4                   DES OURAGANS                TEMPETE           1 km²                   1
   5                      ALLEMAGNE                 BERLIN      357027 km²             8253700
   5                         FRANCE              MARSEILLE      543964 km²            61387038
   5                         ITALIE                   ROME      301230 km²            57715620
   3                   COREE DU SUD                  SEOUL       99274 km²            48324000
   5                    ROYAUME-UNI                LONDRES      244101 km²            58789194
   2                           CUBA              LA HAVANE      100860 km²            11184023

+ Code Continent du pays 'Russie' modifié
   5                         RUSSIE                 MOSCOU    17075400 km²           143954573

+ Capitale du pays 'Chine' modifié
   3                          CHINE                  Pekin     9596960 km²          1273111290

+ Population du pays 'Allemagne' modifié
   5                      ALLEMAGNE                 BERLIN      357027 km²            82537000

+ Suppression de 'DES OURAGANS' ...

+ Augmentation de la population des pays du continent 1

+ Augmentation de la population des pays du continent 3

+ Information des 16 pays
  Code                      NomPays                Capitale     Superficie           Population
   2                     ETATS-UNIS             WASHINGTON     9629047 km²           291289535
   3                          CHINE                  Pekin     9596960 km²          1317670185
   5                         RUSSIE                 MOSCOU    17075400 km²           143954573
   4                      AUSTRALIE               CANBERRA     7686850 km²            19834248
   3                          JAPON                  TOKYO      377835 km²            13207635
   5                      ALLEMAGNE                 BERLIN      357027 km²            82537000
   5                         FRANCE              MARSEILLE      543964 km²            61387038
   5                         ITALIE                   ROME      301230 km²            57715620
   3                   COREE DU SUD                  SEOUL       99274 km²            50015340
   5                    ROYAUME-UNI                LONDRES      244101 km²            58789194
   2                           CUBA              LA HAVANE      100860 km²            11184023
   5                        UKRAINE                   KIEV      603700 km²            48396470
   5                        HONGRIE               BUDAPEST       93030 km²            10106017
   5                       ROUMANIE               BUCAREST      238390 km²            22272000
   5                          GRECE                ATHENES      131940 km²            10623835
   5                        NORVEGE                   OSLO      324220 km²             4525116

+ Pays dont le nom est identique au nom de la capitale

   1                       DJIBOUTI               DJIBOUTI       22000 km²              476825
   3                         KOWEIT                 KOWEIT       17820 km²             2113430
   5                     LUXEMBOURG             LUXEMBOURG        2586 km²              442972
   5                         MONACO                 MONACO         195 km²               31842
   2                         PANAMA                 PANAMA       78200 km²             2845647
   5                    SAINT MARIN            SAINT MARIN          61 km²               27336
   1                       SAO TOME               SAO TOME        1001 km²              170810

+ Pays 'MAURITANIE' a la plus petite densité (2,02 hab/Km²) du continent 1
   1                     MAURITANIE             NOUAKCHOTT     1026000 km²             2070000

+ Pays 'SURINAME' a la plus petite densité (2,66 hab/Km²) du continent 2
   2                       SURINAME             PARAMARIBO      163270 km²              433998

+ Pays 'RUSSIE' a la plus grande population (143954573 hab) du continent 5
   5                         RUSSIE                 MOSCOU    17075400 km²           143954573

+ Pays 'NIGERIA' a la plus grande population (138567563 hab) du continent 1
   1                        NIGERIA                  ABUJA      923768 km²           138567563

+ Pays dont le nom commence par une voyelle
   2                     ETATS-UNIS             WASHINGTON     9629047 km²           291289535
   4                      AUSTRALIE               CANBERRA     7686850 km²            19834248
   5                      ALLEMAGNE                 BERLIN      357027 km²            82537000
   5                         ITALIE                   ROME      301230 km²            57715620
   5                        UKRAINE                   KIEV      603700 km²            48396470
   5                        ESPAGNE                 MADRID      504782 km²            40037995
   5                       AUTRICHE                 VIENNE       83858 km²             8150835
   1                       ETHIOPIE            ADDIS-ABEBA     1127127 km²            70041587
   3                           IRAN                TEHERAN     1648000 km²            78660000
   3                    OUZBEKISTAN               TACHKENT      447400 km²            26458161
   2                      ARGENTINE           BUENOS AIRES     2766890 km²            37812817
   1                 AFRIQUE DU SUD               PRETORIA     1219912 km²            44213679
   1                         EGYPTE               LE CAIRE      995450 km²            77333955
   3                      INDONESIE               DJAKARTA     1919440 km²           236433195
   3                    AZERBAIDJAN                   BAKU       86100 km²             8104841
   5                         ISRAEL              JERUSALEM       20770 km²             6116533
   3            EMIRATS ARABES UNIS             ABOU DHABI       82880 km²             2491721
   5                        ESTONIE                 TALINN       45226 km²             1401945
   3                           INDE              NEW DELHI     3287590 km²          1066040835
   1                       ERYTHREE                 ASMARA      121320 km²             4621949
   3                    AFGHANISTAN                 KABOUL      652225 km²            30581226
   5                        ALBANIE                 TIRANA       28748 km²             3510484
   1                        ALGERIE                  ALGER     2381740 km²            32874760
   5                        ANDORRE       ANDORRA LA VELLA         468 km²               67627
   1                         ANGOLA                 LUANDA     1246700 km²            11143297
   2             ANTIGUA-ET-BARBUDA            SAINT-JOHNS         442 km²               67448
   2         ANTILLES NEERLANDAISES             WILLEMSTAD         800 km²              210000
   3                ARABIE SAOUDITE                  RIYAD     1960582 km²            24336297
   3                        ARMENIE                 EREVAN       29800 km²             3442874
   2                          ARUBA             ORANJESTAD         193 km²               69000
   2                    EL SALVADOR           SAN SALVADOR       21041 km²             6122075
   2                       EQUATEUR                  QUITO      283560 km²            13183978
   2                   ILES CAIMANS            GEORGE TOWN         262 km²               39000
   4                   ILES SALOMON                HONIARA       28450 km²              480442
   2      ILES VIERGES BRITANNIQUES              ROAD TOWN         153 km²               19000
   3                           IRAK                 BAGDAD      437072 km²            24148604
   5                        IRLANDE                 DUBLIN       70273 km²             3917336
   5                        ISLANDE              REYKJAVIC      103125 km²              288201
   3                           OMAN                MASCATE      212460 km²             2713975
   1                        OUGANDA                KAMPALA      236040 km²            25563541
   2                        URUGUAY             MONTEVIDEO      176220 km²             3360105
   3                          YEMEN                  SANAA      527970 km²            20027127


+ Pays 'PAPOUASIE-NOUVELLE-GUINEE' a la capitale
contenant le plus de lettres alphabétiques (11 Lettres) du continent 4

   4      PAPOUASIE-NOUVELLE-GUINEE           PORT MORESBY      462840 km²             4927000

+ Tri des pays en cours ...
+ Information des 10 pays
  Code                      NomPays                Capitale     Superficie           Population
   3                    AFGHANISTAN                 KABOUL      652225 km²            30581226
   1                 AFRIQUE DU SUD               PRETORIA     1219912 km²            44213679
   5                        ALBANIE                 TIRANA       28748 km²             3510484
   1                        ALGERIE                  ALGER     2381740 km²            32874760
   5                      ALLEMAGNE                 BERLIN      357027 km²            82537000
   5                        ANDORRE       ANDORRA LA VELLA         468 km²               67627
   1                         ANGOLA                 LUANDA     1246700 km²            11143297
   2             ANTIGUA-ET-BARBUDA            SAINT-JOHNS         442 km²               67448
   2         ANTILLES NEERLANDAISES             WILLEMSTAD         800 km²              210000
   3                ARABIE SAOUDITE                  RIYAD     1960582 km²            24336297

+ On trouve 'Canada' à l'indice 36
   2                         CANADA                 OTTAWA     9984670 km²            31499560

+ On trouve 'France' à l'indice 64
   5                         FRANCE              MARSEILLE      543964 km²            61387038

+ On trouve 'Japon' à l'indice 93
   3                          JAPON                  TOKYO      377835 km²            13207635

+ On trouve 'Mexique' à l'indice 118
   2                        MEXIQUE                 MEXICO     1972550 km²           103400165

+ Creation du Fichier Oceanie-2.txt
+ Ecriture en cours...
+ Fin d'ecriture


+ Creation du Fichier Asie.txt
+ Ecriture en cours...
+ Fin d'ecriture  */
