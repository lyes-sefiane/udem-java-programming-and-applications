package io.github.lyes_sefiane.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

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
public class Temperature {

    private static final Logger logger = LogManager.getLogger(Temperature.class);

    private String journee;
    private int degreC;


    public Temperature() {
        //
    }

    public Temperature(String jr, int celcius) {
        journee = jr;
        degreC = celcius;
    }

    public boolean plusPetit(Temperature autre) {
        return degreC < autre.degreC;
    }

    public boolean estInferieur(Temperature autre) {
        return journee.compareTo(autre.journee) < 0;
    }

    public void afficher() {
        logger.info("{}  avec {} degres Celcius", journee, degreC);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Temperature that = (Temperature) o;
        return degreC == that.degreC && Objects.equals(journee, that.journee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(journee, degreC);
    }
}
