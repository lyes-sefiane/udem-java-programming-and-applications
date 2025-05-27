package io.github.lyes_sefiane;

/**
 * @author Lyes SEFIANE
 *
 */
public class Personne {
    private String naissance;
    private int nbCafe;
    /**
     * @param nbCafe
     * @param naissance
     *
     */
    public Personne(String naissance, int nbCafe) {
        this.naissance = naissance;
        this.nbCafe = nbCafe;
    }
    /* -0.5 non utilisation de this */
    public Personne(String naissance) {
        this.naissance = naissance;
        nbCafe = 0;
    }
    public String getNaissance() {
        return naissance;
    }
    public void setNaissance(String naissance) {
        this.naissance = naissance;
    }
    public int getNbCafe() {
        return nbCafe;
    }
    public void setNbCafe(int nbCafe) {
        this.nbCafe = nbCafe;
    }
    public int getRangMois(){
        return Integer.parseInt(naissance.substring(3,5));
    }
    public String getNomMois(){
        String nomMois;
        switch (getRangMois()) {
            case 1: nomMois = "janvier"; break;
            case 2: nomMois = "fevrier"; break;
            case 3: nomMois = "mars"; break;
            case 4: nomMois = "avril"; break;
            case 5: nomMois = "mai"; break;
            case 6: nomMois = "juin"; break;
            case 7: nomMois = "juillet"; break;
            case 8: nomMois = "aout"; break;
            case 9: nomMois = "septembre"; break;
            case 10: nomMois = "octobre"; break;
            case 11: nomMois = "novembre"; break;
            default: nomMois = "decembre"; break;
        }
        return nomMois;
    }
    public void afficher(String message) {
        // TODO Auto-generated method stub

        System.out.printf("%s est nee le %s %s %s et "
                        + "consomme %d tasse(s) de cafe \n",
                message,
                naissance.substring(0,2),
                getNomMois(),
                naissance.substring(6),
                nbCafe);
    }

    /*
     * Redefinition de la méthode toString()
     */
    @Override
    public String toString(){
        return String.format("'%s' %5d tasse(s)", naissance, nbCafe);
    }

}