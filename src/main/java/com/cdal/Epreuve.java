package main.java.com.cdal;

public class Epreuve {
    private String nomEpreuve;
    private int scoreMax;
    private char sexe;
    private Sport sport;

    public Epreuve(String nom, int scoreMax, char sexe, Sport sport) {
        this.nomEpreuve = nom;
        this.scoreMax = scoreMax;
        this.sexe = sexe;
        this.sport = sport;
    }

    public String getNomEpreuve() {
        return nomEpreuve;
    }

    public void setNomEpreuve(String nom) {
        this.nomEpreuve = nom;
    }

    public int getScoreMax() {
        return scoreMax;
    }

    public void setScoreMax(int scoreMax) {
        this.scoreMax = scoreMax;
    }

    public char getSexe() {
        return sexe;
    }

    public void setSexe(char sexe) {
        this.sexe = sexe;
    }

    public Sport getSport() {
        return this.sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }

    @Override
    public String toString() {
        return "Epreuve [nomEpreuve=" + nomEpreuve + ", scoreMax=" + scoreMax + ", sexe=" + sexe + ", sport=" + sport
                + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Epreuve)) {
            return false;
        }
        Epreuve tmp = (Epreuve) obj;
        return this.nomEpreuve.equals(tmp.nomEpreuve) && this.scoreMax == tmp.scoreMax && this.sexe == tmp.sexe
                && this.sport.equals(tmp.sport);
    }

    @Override
    public int hashCode() {
        return this.nomEpreuve.hashCode() + this.scoreMax * 11 + this.sexe * 31 + this.sport.hashCode();
    }
}
