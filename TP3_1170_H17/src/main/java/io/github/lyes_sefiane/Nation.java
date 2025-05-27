package io.github.lyes_sefiane;

/**
 * Matricule UdeM : 20090833
 * @author Lyes SEFIANE
 * IFT 1170
 * Java et ses applications
 * lyes.sefiane@umontreal.ca
 * lyes.sefiane@gmail.com
 */

public class Nation  implements Comparable<Nation>{
    private char codeContinent;
    private String nomPays;
    private String capitalePays;
    private int superficiePays;
    private int populationPays;

    public Nation(char codePays, String nomPays, String capitalePays,
                  int superficiePays, int populationPays) {

        this.codeContinent = codePays;
        this.nomPays = nomPays;
        this.capitalePays = capitalePays;
        this.superficiePays = superficiePays;
        this.populationPays = populationPays;
    }

    public char getCodeContinent() {
        return codeContinent;
    }

    public void setCodeContinent(char codeContinent) {
        this.codeContinent = codeContinent;
    }

    public String getNomPays() {
        return nomPays;
    }

    public void setNomPays(String nomPays) {
        this.nomPays = nomPays;
    }

    public String getCapitalePays() {
        return capitalePays;
    }

    public void setCapitalePays(String capitalePays) {
        this.capitalePays = capitalePays;
    }

    public int getSuperficiePays() {
        return superficiePays;
    }

    public void setSuperficiePays(int superficiePays) {
        this.superficiePays = superficiePays;
    }

    public int getPopulationPays() {
        return populationPays;
    }

    public void setPopulationPays(int populationPays) {
        this.populationPays = populationPays;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return String.format("%4s %30s   %20s  %10s km²   %17s", codeContinent,
                nomPays, capitalePays, superficiePays, populationPays);
    }
    /*
     * Deux pays sont égaux, s'ils ont le même nom
     */
    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        if (this == obj){
            return true;
        }
        else
        if(this.getClass() != obj.getClass()){
            return false;
        }
        else{
            Nation autre = (Nation)obj;
            return nomPays.trim().toUpperCase().equals(
                    autre.nomPays.trim().toUpperCase());
        }
    }

    /*
     * Comparaison de deux pays se fait sur la base de leurs noms
     */
    public int compareTo(Nation autre) {
        // TODO Auto-generated method stub
        return nomPays.toUpperCase().compareTo(autre.nomPays.toUpperCase());
    }
}
