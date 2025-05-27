package io.github.lyes_sefiane;

/* Écrire un programme en Java permettant
 *  - d'afficher le nombre de diviseurs de 720
 *  - d'afficher le nombre de diviseurs de 1000
 * - de découvrir un nombre entre 721 et 999
 *   qui a plus de diviseurs que 720
 *   puis on affiche ses diviseurs
 *
 *  Ce programme a été tapé et expliqué en classe.
 *
 *  IFT 1170
 */

public class Diviseurs {


    // Cette méthode compte et retourne le nombre de diviseurs
    // d'un nombre donné
    static int nbDiv(int nombre)
    {
        int n = 0;
        for(int candidat = 1 ; candidat <= nombre; candidat++)
            if(nombre % candidat == 0)
                n++;
        return n;
    }

    // On affiche les diviseurs d'un nombre (voir l'exécution)
    static void afficherDiviseurs(int nombre)
    {
        System.out.printf("Le nombre %d a %d diviseurs. Ce sont :\n", nombre, nbDiv(nombre));
        int rang = 0 ;
        for(int candi = 1; candi <= nombre; candi++)
            if (nombre % candi == 0)
                System.out.printf("%3d) %10d\n", ++rang, candi) ;
        System.out.printf("\n\n");
    }

    public static void main(String[] args) {

        final int NOMBRE1 = 720,
                NOMBRE2 = 1000;

        int k = nbDiv(NOMBRE1); // nombre de diviseurs de 720

        System.out.printf("Le nombre de diviseurs de %d est %d\n", NOMBRE1, k);
        System.out.printf("Le nombre de diviseurs de %d est %d\n", NOMBRE2, Diviseurs.nbDiv(NOMBRE2));

        // découvrir un nombre entre 721 et 999 qui a plus de diviseurs que 720
        for(int nombre = NOMBRE1 + 1 ; nombre < NOMBRE2; nombre++)
            if (nbDiv(nombre) > k)
            {
                System.out.printf("Le nombre %d a plus de diviseurs que %d\n", nombre, NOMBRE1);
                Diviseurs.afficherDiviseurs(nombre);
            }
    }


}
/* Compilation et Exécution:
--------------------Configuration: <Default>--------------------
Le nombre de diviseurs de 720 est 30
Le nombre de diviseurs de 1000 est 16
Le nombre 840 a plus de diviseurs que 720
Le nombre 840 a 32 diviseurs. Ce sont :
  1)          1
  2)          2
  3)          3
  4)          4
  5)          5
  6)          6
  7)          7
  8)          8
  9)         10
 10)         12
 11)         14
 12)         15
 13)         20
 14)         21
 15)         24
 16)         28
 17)         30
 18)         35
 19)         40
 20)         42
 21)         56
 22)         60
 23)         70
 24)         84
 25)        105
 26)        120
 27)        140
 28)        168
 29)        210
 30)        280
 31)        420
 32)        840



Process completed.


*/