public abstract class Epreuves {
    protected String nom;
    protected int scoreMax;
    protected char sexe;
    
    public Epreuves(String nom, int scoreMax, char sexe) {
        this.nom = nom;
        this.scoreMax = scoreMax;
        this.sexe = sexe;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
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
