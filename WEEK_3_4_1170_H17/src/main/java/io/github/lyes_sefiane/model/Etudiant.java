package io.github.lyes_sefiane.model;

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
public class Etudiant {

    private static final Logger logger = LogManager.getLogger(Etudiant.class);

    private final String nomPre;
    private final String codePerm;
    private double globale;


    public Etudiant(String nP, String cP, double glob) {
        nomPre = nP;
        codePerm = cP;
        globale = glob;
    }

    public Etudiant(String nP, String cP) {
        nomPre = nP;
        codePerm = cP;
        globale = 75.4;
    }

    public String getNomPre() {
        return nomPre;
    }

    public String getNomPreToUpperCase() {
        return nomPre.toUpperCase();
    }

    public double getGlobale() {
        return globale;
    }

    public void setGlobale(double nouvGlobale) {
        if (nouvGlobale < 0)
            globale = 0.0;
        else if (nouvGlobale > 100)
            globale = 100.0;
        else
            globale = nouvGlobale;
    }

    public String getCodePerm() {
        return codePerm;
    }

    public String getSexe() {

        if (codePerm.charAt(6) >= '5')
            return "féminin";
        else
            return "masculin";
    }

    public int getRangMois() {
        return Integer.parseInt(codePerm.substring(6, 8)) % 50; // retour le mois de naissance
    }

    public String getNomMois() {
        String[] nomMois = {"janvier", "février", "mars", "avril", "mai", "juin", "juillet", "aout", "septembre", "octobre", "novembre", "decembre"};
        return nomMois[(getRangMois() - 1)];
    }

    public void afficher(String message) {
        logger.info("{} : ", message);
        logger.info(" - nom et prénom    : {}", getNomPreToUpperCase());
        logger.info(" - code permanent   : {}", codePerm);
        logger.info(" - note globale     : {}", globale);
        logger.info(" - de Sexe          : {}", getSexe());
        logger.info(" - né(e) au mois de : {}", getNomMois());
    }

    public String toString() {
        return String.format("%-25s %15s %8.1f %-14s %-15s",
                nomPre.toUpperCase(), codePerm, globale, getSexe(), getNomMois());
    }

}
