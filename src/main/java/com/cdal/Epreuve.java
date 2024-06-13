package main.java.com.cdal;

/**
 * Classe représentant une épreuve dans un contexte sportif.
 * Cette classe encapsule les détails d'une épreuve, incluant son nom, le score
 * maximum pouvant être atteint,
 * le sexe des participants (masculin ou féminin, représenté par un caractère)
 * et le sport associé à l'épreuve.
 */
public class Epreuve {

    private String nomEpreuve; // Nom de l'épreuve.
    private int scoreMax; // Score maximum pouvant être atteint dans cette épreuve.
    private char sexe; // Sexe des participants ('M' pour masculin, 'F' pour féminin).
    private Sport sport; // Sport associé à l'épreuve.

    /**
     * Constructeur de la classe Epreuve.
     * Initialise une nouvelle instance d'Epreuve avec les détails spécifiés.
     * 
     * @param nom      Le nom de l'épreuve.
     * @param scoreMax Le score maximum pouvant être atteint.
     * @param sexe     Le sexe des participants ('M' ou 'F').
     * @param sport    Le sport associé à l'épreuve.
     */
    public Epreuve(String nom, int scoreMax, char sexe, Sport sport) {
        this.nomEpreuve = nom;
        this.scoreMax = scoreMax;
        this.sexe = sexe;
        this.sport = sport;
    }

    /**
     * Retourne le nom de l'épreuve.
     * 
     * @return Le nom de l'épreuve.
     */
    public String getNomEpreuve() {
        return nomEpreuve;
    }

    /**
     * Définit le nom de l'épreuve.
     * 
     * @param nom Le nouveau nom de l'épreuve.
     */
    public void setNomEpreuve(String nom) {
        this.nomEpreuve = nom;
    }

    /**
     * Retourne le score maximum de l'épreuve.
     * 
     * @return Le score maximum.
     */
    public int getScoreMax() {
        return scoreMax;
    }

    /**
     * Définit le score maximum de l'épreuve.
     * 
     * @param scoreMax Le nouveau score maximum.
     */
    public void setScoreMax(int scoreMax) {
        this.scoreMax = scoreMax;
    }

    /**
     * Retourne le sexe des participants de l'épreuve.
     * 
     * @return Le sexe des participants ('M' ou 'F').
     */
    public char getSexe() {
        return sexe;
    }

    /**
     * Définit le sexe des participants de l'épreuve.
     * 
     * @param sexe Le sexe des participants ('M' ou 'F').
     */
    public void setSexe(char sexe) {
        this.sexe = sexe;
    }

    /**
     * Retourne le sport associé à l'épreuve.
     * 
     * @return Le sport associé.
     */
    public Sport getSport() {
        return this.sport;
    }

    /**
     * Définit le sport associé à l'épreuve.
     * 
     * @param sport Le nouveau sport associé.
     */
    public void setSport(Sport sport) {
        this.sport = sport;
    }

    @Override
    public String toString() {
        return "Epreuve [nomEpreuve=" + nomEpreuve + ", scoreMax=" + scoreMax + ", sexe=" + sexe + ", sport="
                + sport.getNom()
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
                && this.sport.getNom().equals(tmp.sport.getNom());
    }

    @Override
    public int hashCode() {
        return this.nomEpreuve.hashCode() + this.scoreMax * 11 + this.sexe * 31 + this.sport.hashCode();
    }
}
