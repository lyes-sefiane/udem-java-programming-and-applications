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
public class Rectangle {

    private static final Logger logger = LogManager.getLogger(Rectangle.class);
    private final double longueur;
    private double largeur;

    public Rectangle(double lo, double la) {
        longueur = lo;
        largeur = la;
    }

    public Rectangle(double cote) {
        this(cote, cote);
    }

    public Rectangle() {
        this(5.8, 3.5);
    }

    public double perimetre() {
        return 2 * (longueur + largeur);
    }

    public Rectangle plusLong(Rectangle autre) {
        if (autre.perimetre() > this.perimetre())
            return autre;
        else
            return this;
    }

    public double surface() {
        return longueur * largeur;
    }

    public double diagonale() {
        return Math.sqrt(longueur * longueur + largeur * largeur);
    }

    public double getLongueur() {
        return longueur;
    }

    public double getLargeur() {
        return largeur;
    }

    public void setLargeur(double nouvLargeur) {
        largeur = nouvLargeur;
    }

    public void afficher(String message) {
        logger.info("Informations de {} : ", message);
        logger.info("  - longueur  : {}", longueur);
        logger.info("  - largeur   : {}", largeur);
        logger.info("  - perimetre : {}", perimetre());
        logger.info("  - surface   : {}", surface());
        logger.info("  - diagonale : {}", diagonale());
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return this.surface() == rectangle.surface();
    }

    @Override
    public int hashCode() {
        return Objects.hash(longueur, largeur);
    }

    public String toString() {
        return String.format("<%5.1f | %6.1f | %6.2f | %6.1f | %6.1f>", largeur, longueur, perimetre(),
                surface(), diagonale());
    }


}