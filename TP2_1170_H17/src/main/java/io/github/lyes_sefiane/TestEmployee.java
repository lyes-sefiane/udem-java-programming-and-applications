package io.github.lyes_sefiane;

import java.io.*;
/**
 * Matricule UdeM : 20090833
 * @author Lyes SEFIANE
 * IFT 1170
 * Java et applications
 * lyes.sefiane@umontreal.ca
 * lyes.sefiane@gmail.com
 */
public class TestEmployee {

    /**
     * Affichage des informations des employés
     */
    public static void affichEmploye(Employee[] emp, int nbEmployee) {
        System.out.println("Affichage des employés\n");
        System.out.printf("%s %12s %15s\n", "Indice", "NAS-Employe",
                "Salaire Hebdo");
        for(int i = 0 ; i < nbEmployee; i++) {
            System.out.printf("%4d %s\n", i, emp[i]);
        }
        System.out.printf("\n");
    }

    /**
     * Recherche d'un caratère dans une chaine de caratères.
     * il suffit de trouver une correspondance afin que
     * la méthode return vrai, d'où l'utilisation de while
     */
    public static boolean trouve(char caractere, String nas) {
        boolean existe = false;
        int i = 0;

        while(!existe){
            if(i < nas.length()){
                if (nas.charAt(i) == caractere)
                    existe = true;
                i++;
            }
            else
                break;
        }
        return existe;
    }

    /**
     * Recherche des employés payés moins d'un certain seuil
     * Dont le NAS contient un numéro précis
     */
    public static void gagneMoins(Employee[] emp, int nbEmployee,
                                  double seuilMax, char caractere) {
        System.out.printf("- Le(s) employé(s) gagant moins de %.2f$ par semaine "+
                "dont le NAS contient '%c'\n",  seuilMax, caractere);

        for(int i = 0; i < nbEmployee; i++ ){
            if ((emp[i].getSalHebdo() < seuilMax) &
                    (trouve(caractere , emp[i].getNas())))
                System.out.printf("%4d %s\n", i, emp[i]);
        }
        System.out.printf("\n");
    }

    /**
     * Permutation entre deux employés dans un tableau
     */
    public static void permuter(Employee[] emp, int i, int j) {
        Employee var = emp[i];
        emp[i] = emp[j];
        emp[j] = var;

    }

    /**
     * Tri par séléction des employés selon leurs NAS
     */
    public static void triEmploye(Employee[] emp, int nbEmployee) {
        for (int i = 0; i < nbEmployee; i++){
            for (int j = i + 1; j < nbEmployee; j++){
                if(emp[i].getNas().compareTo(emp[j].getNas()) > 0)
                    permuter(emp, i, j);
            }
        }
    }


    /**
     * Création et écriture des informations des employés dans un fichier
     */
    public static void creerFichier(Employee[] emp, String nomFichier,
                                    int nbEmploye) throws IOException {
        FileWriter fichier = new FileWriter(nomFichier);
        System.out.println("Début de création du Fichier\n");
        PrintWriter aCreer = new PrintWriter( fichier );
        for(int i = 0; i < nbEmploye; i++ ){
            aCreer.printf("%d %s\n", i, emp[i]);
        }
        aCreer.close();
        System.out.printf("Fin de création du Fichier %s\n", nomFichier);
    }

    public static void main(String[] args) throws IOException {
        Employee emp1 = new Employee("250 642 753", 1234.56),
                emp2 = new Employee("123 456 789"),
                emp3 = new Employee("250 343 678", 40.00, 25.75);

        Employee[] emp = {  new Employee("250 642 753", 1234.25),
                new Employee("123 456 789"),
                new Employee("250 343 654", 42, 17.25),
                new Employee("231 467 890", 1671.50),
                new Employee("478 343 689", 750.75),
                new Employee("371 238 432", 50, 20.25)
        };


        System.out.println("\t\t----------------------------");
        System.out.println("\t\t- Exercice numéro A du TP2 -");
        System.out.println("\t\t----------------------------");


        emp1.afficher("Information Employe 1");

        emp3.afficher("Information Employe 3");

        emp2.setSalHebdo(emp1.getSalHebdo() + emp3.getSalHebdo());

        emp2.afficher("Information Employe 2");

        int nbEmploye = emp.length;

        affichEmploye (emp, nbEmploye);

        gagneMoins(emp, nbEmploye, 1234.50, '5');

        gagneMoins(emp, nbEmploye, 750.00, '3');

        triEmploye(emp, nbEmploye);

        affichEmploye (emp, nbEmploye);

        creerFichier(emp, "./empTri.dta", nbEmploye);
    }
}
/*
		----------------------------
		- Exercice numéro A du TP2 -
		----------------------------
Information Employe 1
Numéro Assurence Sociale : 250 642 753
Salaire Hebdomadaire     : 1234,56

Information Employe 3
Numéro Assurence Sociale : 250 343 678
Salaire Hebdomadaire     : 1030,00

Information Employe 2
Numéro Assurence Sociale : 123 456 789
Salaire Hebdomadaire     : 2264,56

Affichage des employés

Indice  NAS-Employe   Salaire Hebdo
   0    '250 642 753'     1234,25$
   1    '123 456 789'     1000,00$
   2    '250 343 654'      724,50$
   3    '231 467 890'     1671,50$
   4    '478 343 689'      750,75$
   5    '371 238 432'     1012,50$

- Le(s) employé(s) gagant moins de 1234,50$ par semaine dont le NAS contient '5'
   0    '250 642 753'     1234,25$
   1    '123 456 789'     1000,00$
   2    '250 343 654'      724,50$

- Le(s) employé(s) gagant moins de 750,00$ par semaine dont le NAS contient '3'
   2    '250 343 654'      724,50$

Affichage des employés

Indice  NAS-Employe   Salaire Hebdo
   0    '123 456 789'     1000,00$
   1    '231 467 890'     1671,50$
   2    '250 343 654'      724,50$
   3    '250 642 753'     1234,25$
   4    '371 238 432'     1012,50$
   5    '478 343 689'      750,75$

Début de création du Fichier

Fin de création du Fichier empTri.dta */
