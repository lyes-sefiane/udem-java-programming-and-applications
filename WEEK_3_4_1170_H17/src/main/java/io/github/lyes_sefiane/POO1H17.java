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
public class POO1H17 {

    private static final Logger logger = LogManager.getLogger(POO1H17.class);

    public static void main(String[] args) {

        Etudiant etud1 = new Etudiant("Tremblay Nicole", "TREN25571990", 82.7);
        Etudiant etud2 = new Etudiant("Choquette Alain", "CHOA07121997", 88.1);
        Etudiant etud3 = new Etudiant("Roy Lise", "ROYL30611995");

        etud1.afficher("Infos du premier étudiant");

        logger.info("Nom et prénom en tous minuscules de etud2 : {}", etud2.getNomPreToUpperCase());

        etud3.setGlobale(etud3.getGlobale() + 5.2);
        etud3.afficher("Infos de etud3 après avoir ajouté 5.2 à sa note globale");
    }
}
