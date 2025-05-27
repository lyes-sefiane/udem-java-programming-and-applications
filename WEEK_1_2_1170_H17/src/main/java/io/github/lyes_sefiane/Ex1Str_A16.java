package io.github.lyes_sefiane;

/*  Fichier Ex1Str_A16.java : Premier exemple sur String de l'automne 2016
 *
 *  À comprendre, étudier, refaire si nécessaire
 *
 *  Exemple utile pour le numéro A du TP1
 *
 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 * + Auteurs : André Lafortune et Lise Bergeron, IFT 1170 Aut 16 +
 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 * + But du programme : Ce programme permet de ...               +
 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 * + Dernière mise à jour : jeudi le 1er septembre 2016          +
 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 */

public class Ex1Str_A16
{

    static void demo1()
    {
        System.out.printf("Démo1 : quelques méthodes de String :\n\n");


        String souhait = "Bonne rentree et bon succes!";
        System.out.printf("Sa longueur : %d caracteres\n", souhait.length());
        System.out.printf("Le caractère à l'indice 0 : %c\n",  souhait.charAt(0));
        System.out.printf("Le caractère à l'indice 2 : %c\n\n",  souhait.charAt(2));

        System.out.printf("L'indice du caractère B   : %d\n",  souhait.indexOf('B'));
        System.out.printf("L'indice du caractère n   : %d\n",  souhait.indexOf('n'));
        System.out.printf("L'indice du caractère z   : %d\n\n",  souhait.indexOf('z')); // -1 => introuvable

        System.out.printf("L'indice de Bon           : %d\n",  souhait.indexOf("Bon"));
        System.out.printf("L'indice de rentree       : %d\n",  souhait.indexOf("rentree"));
        System.out.printf("L'indice de Baba Ali      : %d\n\n",  souhait.indexOf("Baba Ali")); // -1 => introuvable

        System.out.printf("L'indice de la première lettre o   : %d\n",  souhait.indexOf('o'));
        System.out.printf("L'indice de la deuxième lettre o   : %d\n",  souhait.indexOf('o', 6)); // à partir de l'indice 6
        System.out.printf("L'indice de dernière lettre s      : %d\n\n",  souhait.lastIndexOf('s'));

        System.out.printf("Sous-chaîne                        : %s\n",  souhait.substring(0,5) ); // 0 inclu, 5 exclu
        System.out.printf("Sous-chaîne                        : %s\n",  souhait.substring(6,13) ); // 6 inclu, 13 exclu
        System.out.printf("Sous-chaîne                        : %s\n\n",  souhait.substring(14) ); // à partir de l'indice 14

        int entier = Integer.parseInt("1234");
        System.out.printf("Après cette conversion, l'entier vaut : %d\n\n", entier);

        entier = Integer.parseInt("  1234      ".trim());
        System.out.printf("Après cette conversion, l'entier vaut : %d\n\n", entier);

    }

    static int nbFois(char carVoulu, String chaine)
    {

        int n = 0, nbCars = chaine.length();
        for(int i = 0; i < nbCars; i++)
            if (chaine.charAt(i) == carVoulu)
                n++;
        return n;
    }

    static int nbVoy(String chMaj)
    {

        int n = 0;

        for(int i = 0, nbCars = chMaj.length(); i < nbCars; i++)
            switch( chMaj.charAt(i))
            {
                case 'A' : case 'E' : case 'I' : case 'O' : case 'U' : case 'Y' : n++;
            }
        return n;
    }

    static int nbVoy2(String ch)
    {

        int n = 0;
        String voyelles = "AaEeIiOoUuYy";

        for(int i = 0, nbCars = ch.length(); i < nbCars; i++)
            if (voyelles.indexOf(ch.charAt(i)) >= 0) n++;

        return n;
    }


    static void demo2()
    {
        System.out.printf("\nDémo2 : quelques manipulations avec String :\n\n");

        String souhait = "Bonne rentree et bon succes au IFT 1170 Automne 2016!";

        System.out.printf("Le nombre de lettres  o dans cette chaîne : %d\n", nbFois('o', souhait));
        System.out.printf("Le nombre de lettres  n dans cette chaîne : %d\n", nbFois('n', souhait));
        System.out.printf("Le nombre de chiffres 1 dans cette chaîne : %d\n", nbFois('1', souhait));
        System.out.printf("Le nombre de lettres  v dans cette chaîne : %d\n\n", nbFois('v', souhait));

        System.out.printf("Le nombre de voyelles dans cette chaîne : %d\n", nbVoy(souhait.toUpperCase()));
        System.out.printf("Le nombre de voyelles dans cette chaîne : %d\n", nbVoy2(souhait));
    }


    static void demo3()
    {
        System.out.printf("\nDémo3 : quelques manipulations avec un numéro de telephone :\n\n");

        String telUdeM = "5143436111";

        String codeRegional = telUdeM.substring(0, 3),
                echange      = telUdeM.substring(3, 6),
                numero       = telUdeM.substring(6);

        System.out.printf("\nPour le numéro de téléphone : %s\n", telUdeM);
        System.out.printf("  - le code régional    : %s\n", codeRegional);
        System.out.printf("  - l'échange           : %s\n", echange);
        System.out.printf("  - le numéro           : %s\n", numero);

        System.out.printf("\nLes chiffres pairs présentés dans %s : ", telUdeM);
        for(char c = '0' ; c <= '8' ; c += 2)
            if (telUdeM.indexOf(c) >= 0)
                System.out.printf("%c ", c);
        System.out.printf("\n\n");

        System.out.printf("\nLes chiffres pairs rencontrés successivement dans %s : ", telUdeM);
        String pairs = "02468";

        for(int i = 0, nbCars = telUdeM.length(); i < nbCars; i++)
            if (pairs.indexOf(telUdeM.charAt(i)) >= 0)
                System.out.printf("%c ", telUdeM.charAt(i));
        System.out.printf("\n\n");



    }

    public static void main(String[] args) {

        Ex1Str_A16.demo1();
        Ex1Str_A16.demo2();
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
