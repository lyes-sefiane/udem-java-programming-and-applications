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
class Ex1StrA16 {

    private static final Logger logger = LogManager.getLogger(Ex1StrA16.class);

    private static final String BONNE_RENTREE_ET_BON_SUCCESS = "Bonne rentree et bon succes!";
    private static final String BONNE_RENTREE_ET_BON_SUCCESS_AU_IFT_1170_HIVER_2017 = "Bonne rentree et bon succes au IFT 1170 Hiver 2017!";

    static void demo1() {
        logger.info("Démo1 : quelques méthodes de String :");

        logger.info("Sa longueur : {} caracteres", BONNE_RENTREE_ET_BON_SUCCESS.length());
        logger.info("Le caractère à l'indice 0 : {}", BONNE_RENTREE_ET_BON_SUCCESS.charAt(0));
        logger.info("Le caractère à l'indice 2 : {}", BONNE_RENTREE_ET_BON_SUCCESS.charAt(2));

        logger.info("L'indice du caractère B   : {}", BONNE_RENTREE_ET_BON_SUCCESS.indexOf('B'));
        logger.info("L'indice du caractère n   : {}", BONNE_RENTREE_ET_BON_SUCCESS.indexOf('n'));
        logger.info("L'indice du caractère z   : {}", BONNE_RENTREE_ET_BON_SUCCESS.indexOf('z'));
        logger.info("L'indice de Bon           : {}", BONNE_RENTREE_ET_BON_SUCCESS.indexOf("Bon"));
        logger.info("L'indice de rentree       : {}", BONNE_RENTREE_ET_BON_SUCCESS.indexOf("rentree"));
        logger.info("L'indice de Baba Ali      : {}", BONNE_RENTREE_ET_BON_SUCCESS.indexOf("Baba Ali"));
        logger.info("L'indice de la première lettre o   : {}", BONNE_RENTREE_ET_BON_SUCCESS.indexOf('o'));
        logger.info("L'indice de la deuxième lettre o   : {}", BONNE_RENTREE_ET_BON_SUCCESS.indexOf('o', 6));
        logger.info("L'indice de dernière lettre s      : {}", BONNE_RENTREE_ET_BON_SUCCESS.lastIndexOf('s'));

        logger.info("Sous-chaîne                        : {}", BONNE_RENTREE_ET_BON_SUCCESS.substring(0, 5));
        logger.info("Sous-chaîne                        : {}", BONNE_RENTREE_ET_BON_SUCCESS.substring(6, 13));
        logger.info("Sous-chaîne                        : {}", BONNE_RENTREE_ET_BON_SUCCESS.substring(14));

        int entier = Integer.parseInt("1234");
        logger.info("Après cette conversion, l'entier vaut : {}", entier);

        entier = Integer.parseInt("  1234      ".trim());
        logger.info("Après cette conversion, l'entier vaut : {}", entier);
    }

    static int nbFois(char carVoulu, String chaine) {
        int n = 0, nbCars = chaine.length();
        for (int i = 0; i < nbCars; i++)
            if (chaine.charAt(i) == carVoulu)
                n++;
        return n;
    }

    static int nbVoy(String chMaj) {
        int n = 0;
        for (int i = 0, nbCars = chMaj.length(); i < nbCars; i++)
            switch (chMaj.charAt(i)) {
                case 'A':
                case 'E':
                case 'I':
                case 'O':
                case 'U':
                case 'Y':
                    n++;
            }
        return n;
    }

    static int nbVoy2(String ch) {
        int n = 0;
        String voyelles = "AaEeIiOoUuYy";
        for (int i = 0, nbCars = ch.length(); i < nbCars; i++) {
            if (voyelles.indexOf(ch.charAt(i)) >= 0) n++;
        }
        return n;
    }


    static void demo2() {
        logger.info("Démo2 : quelques manipulations avec String :");

        logger.info("Le nombre de lettres  o dans cette chaîne : {}", nbFois('o', BONNE_RENTREE_ET_BON_SUCCESS_AU_IFT_1170_HIVER_2017));
        logger.info("Le nombre de lettres  n dans cette chaîne : {}", nbFois('n', BONNE_RENTREE_ET_BON_SUCCESS_AU_IFT_1170_HIVER_2017));
        logger.info("Le nombre de chiffres 1 dans cette chaîne : {}", nbFois('1', BONNE_RENTREE_ET_BON_SUCCESS_AU_IFT_1170_HIVER_2017));
        logger.info("Le nombre de lettres  v dans cette chaîne : {}", nbFois('v', BONNE_RENTREE_ET_BON_SUCCESS_AU_IFT_1170_HIVER_2017));

        logger.info("Le nombre de voyelles dans cette chaîne : {}", nbVoy(BONNE_RENTREE_ET_BON_SUCCESS_AU_IFT_1170_HIVER_2017.toUpperCase()));
        logger.info("Le nombre de voyelles dans cette chaîne : {}", nbVoy2(BONNE_RENTREE_ET_BON_SUCCESS_AU_IFT_1170_HIVER_2017));
    }


    static void demo3() {
        logger.info("Démo3 : quelques manipulations avec un numéro de telephone :");

        String telUdeM = "5143436111";

        String codeRegional = telUdeM.substring(0, 3);
        String echange = telUdeM.substring(3, 6);
        String numero = telUdeM.substring(6);

        logger.info("Pour le numéro de téléphone : {}", telUdeM);
        logger.info("  - le code régional    : {}", codeRegional);
        logger.info("  - l'échange           : {}", echange);
        logger.info("  - le numéro           : {}", numero);

        logger.info("Les chiffres pairs présentés dans {} : ", telUdeM);
        for (char c = '0'; c <= '8'; c += 2) {
            if (telUdeM.indexOf(c) >= 0) {
                logger.info("{} ", c);
            }
        }


        logger.info("Les chiffres pairs rencontrés successivement dans {} : ", telUdeM);
        String pairs = "02468";

        for (int i = 0, nbCars = telUdeM.length(); i < nbCars; i++) {
            if (pairs.indexOf(telUdeM.charAt(i)) >= 0) {
                logger.info("{} ", telUdeM.charAt(i));
            }
        }

    }

    public static void main(String[] args) {
        Ex1StrA16.demo1();
        Ex1StrA16.demo2();
        demo3();
    }
}
/* Exécution
--------------------Configuration: <Default>--------------------
Démo1 : quelques méthodes de String :

Sa longueur : 28 caracteres
Le caractère à l'indice 0 : B
Le caractère à l'indice 2 : n

L'indice du caractère B   : 0
L'indice du caractère n   : 2
L'indice du caractère z   : -1

L'indice de Bon           : 0
L'indice de rentree       : 6
L'indice de Baba Ali      : -1

L'indice de la première lettre o   : 1
L'indice de la deuxième lettre o   : 18
L'indice de dernière lettre s      : 26

Sous-chaîne                        : Bonne
Sous-chaîne                        : rentree
Sous-chaîne                        : et bon succes!

Après cette conversion, l'entier vaut : 1234

Après cette conversion, l'entier vaut : 1234


Démo2 : quelques manipulations avec String :

Le nombre de lettres  o dans cette chaîne : 3
Le nombre de lettres  n dans cette chaîne : 5
Le nombre de chiffres 1 dans cette chaîne : 3
Le nombre de lettres  v dans cette chaîne : 0

Le nombre de voyelles dans cette chaîne : 16
Le nombre de voyelles dans cette chaîne : 16

Démo3 : quelques manipulations avec un numéro de telephone :


Pour le numéro de téléphone : 5143436111
  - le code régional    : 514
  - l'échange           : 343
  - le numéro           : 6111

Les chiffres pairs présentés dans 5143436111 : 4 6


Les chiffres pairs rencontrés successivement dans 5143436111 : 4 4 6


Process completed.

*/
