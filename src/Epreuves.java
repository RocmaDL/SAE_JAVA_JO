public class Epreuves {
    private String nomEpreuve;
    private int scoreMax;
    private char sexe;

    public Epreuves(String nom, int scoreMax, char sexe) {
        this.nom = nom;
        this.scoreMax = scoreMax;
        this.sexe = sexe;
    }

    public String getNomEpreuve() {
        return nom;
    }

    public void setNomEpreuve(String nom) {
        this.nom = nom;
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

}
