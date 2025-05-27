package io.github.lyes_sefiane;

/**
 * Matricule UdeM : 20090833
 * @author Lyes SEFIANE
 * IFT 1170
 * Java et applications
 * lyes.sefiane@umontreal.ca
 * lyes.sefiane@gmail.com
 */
public class Employee {

    private String nas;
    private double salHebdo;


    public Employee(String nas, double salHebdo) {
        this.nas = nas;
        this.salHebdo = salHebdo;
    }

    public Employee(String nas) {
        this (nas, 1000.00);
    }

    public Employee(String nas, double heuresParSemaine, double tauxHoraire) {
        this(nas, (heuresParSemaine * tauxHoraire));
    }

    /**
     * @return the nas
     */
    public String getNas() {
        return nas;
    }

    /**
     * @return the salHebdo
     */
    public double getSalHebdo() {
        return salHebdo;
    }

    /**
     * @param salHebdo the salHebdo to set
     */
    public void setSalHebdo(double salHebdo) {
        this.salHebdo = salHebdo;
    }

    public void afficher(String message) {
        System.out.println(message);
        System.out.printf("Numéro Assurence Sociale : %s\n"
                        + "Salaire Hebdomadaire     : %.2f \n\n",
                nas,
                salHebdo);

    }

    /*
     * Redéfinition de la methode toString()
     * Retourne une chaine de caractères foramtée
     */
    @Override
    public String toString() {
        return String.format("   '%11s' %11.2f$", nas, salHebdo);
    }
}
