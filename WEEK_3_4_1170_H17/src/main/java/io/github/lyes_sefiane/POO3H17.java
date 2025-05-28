package io.github.lyes_sefiane;

import io.github.lyes_sefiane.model.Etudiant;
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
public class POO3H17 {

    private static final Logger logger = LogManager.getLogger(POO3H17.class);

    static void afficher(Etudiant[] etud, int nbEtud) {
        logger.info(" Le contenu du tableau : ");
        for (int i = 0; i < nbEtud; i++) {
            logger.info(" {})  {}", i, etud[i]);
        }
    }


    public static void main(String[] args) {

        Etudiant etud1 = new Etudiant("Tremblay Nicole", "TREN25571990", 82.7);
        Etudiant etud2 = new Etudiant("Choquette Alain", "CHOA07121997", 88.1);
        Etudiant etud3 = new Etudiant("Roy Lise", "ROYL30611995");

        etud1.afficher("Infos du premier étudiant");

        logger.info("Coordonnées de etud1 : {}", etud1);

        logger.info("Nom et prénom en tous minuscules de etud2 : {}", etud2.getNomPreToUpperCase());

        etud3.setGlobale(etud3.getGlobale() + 5.2);
        etud3.afficher("Infos de etud3 après avoir ajouté 5.2 à sa note globale");

        Etudiant[] etudiant = {new Etudiant("Charbonneau Sylvie", "CHAS2551199233", 90.5),
                new Etudiant("Roy Pierre", "ROYP28021998", 70.3),
                new Etudiant("Sage Verinique", "SAGV12621985")};

        int nbEtud = etudiant.length;
        POO3H17.afficher(etudiant, nbEtud);

    }
}

/**
 * 2025-05-28 14:50:40 INFO  Etudiant:81 - Infos du premier étudiant :
 * 2025-05-28 14:50:40 INFO  Etudiant:82 -  - nom et prénom    : TREMBLAY NICOLE
 * 2025-05-28 14:50:40 INFO  Etudiant:83 -  - code permanent   : TREN25571990
 * 2025-05-28 14:50:40 INFO  Etudiant:84 -  - note globale     : 82.7
 * 2025-05-28 14:50:40 INFO  Etudiant:85 -  - de Sexe          : féminin
 * 2025-05-28 14:50:40 INFO  Etudiant:86 -  - né(e) au mois de : juillet
 * 2025-05-28 14:50:40 INFO  POO3H17:37 - Coordonnées de etud1 : TREMBLAY NICOLE              TREN25571990     82.7 féminin        juillet
 * 2025-05-28 14:50:40 INFO  POO3H17:39 - Nom et prénom en tous minuscules de etud2 : CHOQUETTE ALAIN
 * 2025-05-28 14:50:40 INFO  Etudiant:81 - Infos de etud3 après avoir ajouté 5.2 à sa note globale :
 * 2025-05-28 14:50:40 INFO  Etudiant:82 -  - nom et prénom    : ROY LISE
 * 2025-05-28 14:50:40 INFO  Etudiant:83 -  - code permanent   : ROYL30611995
 * 2025-05-28 14:50:40 INFO  Etudiant:84 -  - note globale     : 80.60000000000001
 * 2025-05-28 14:50:40 INFO  Etudiant:85 -  - de Sexe          : féminin
 * 2025-05-28 14:50:40 INFO  Etudiant:86 -  - né(e) au mois de : novembre
 * 2025-05-28 14:50:40 INFO  POO3H17:22 -  Le contenu du tableau :
 * 2025-05-28 14:50:40 INFO  POO3H17:24 -  0)  CHARBONNEAU SYLVIE         CHAS2551199233     90.5 féminin        janvier
 * 2025-05-28 14:50:40 INFO  POO3H17:24 -  1)  ROY PIERRE                   ROYP28021998     70.3 masculin       février
 * 2025-05-28 14:50:40 INFO  POO3H17:24 -  2)  SAGE VERINIQUE               SAGV12621985     75.4 féminin        decembre
 */