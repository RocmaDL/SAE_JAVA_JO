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


}
