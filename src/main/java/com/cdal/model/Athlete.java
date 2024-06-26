package main.java.com.cdal.model;

import java.util.Map;

import main.java.com.cdal.model.exception.*;

/**
 * La classe Athlete représente un athlète qui peut participer à une épreuve.
 * Elle implémente l'interface Participer.
 */
public class Athlete implements Participer {
    private String nomAt; // Le nom de l'athlète
    private String prenomAt; // Le prénom de l'athlète
    private char sexe; // Le sexe de l'athlète
    private double force; // La force de l'athlète
    private double agilite; // L'agilité de l'athlète
    private double endurance; // L'endurance de l'athlète
    private Pays pays; // Le pays de l'athlète

    /**
     * Constructeur de la classe Athlete.
     * 
     * @param nomAt     Le nom de l'athlète
     * @param prenomAt  Le prénom de l'athlète
     * @param sexe      Le sexe de l'athlète
     * @param force     La force de l'athlète
     * @param agilite   L'agilité de l'athlète
     * @param endurance L'endurance de l'athlète
     * @param pays      Le pays de l'athlète
     */
    public Athlete(String nomAt, String prenomAt, char sexe, double force, double agilite, double endurance,
            Pays pays) {
        this.nomAt = nomAt;
        this.prenomAt = prenomAt;
        this.sexe = sexe;
        this.force = force;
        this.agilite = agilite;
        this.endurance = endurance;
        this.pays = pays;
    }

    /**
     * Méthode pour participer à une épreuve.
     * 
     * @param epreuve L'épreuve à laquelle l'athlète participe
     * @return Le résultat de la participation de l'athlète à l'épreuve
     */
    @Override
    public double participer(Epreuve epreuve) throws AthleteInvalideException {
        if (epreuve.getSexe() == this.getSexe()) {
            throw new AthleteInvalideException();
        }
        Map<Caracteristique, Double> lesCoeffs = epreuve.getSport().getCoefficient();
        double res = (lesCoeffs.get(Caracteristique.FORCE) * getForce() +
                lesCoeffs.get(Caracteristique.AGILITE) * getAgilite()
                + lesCoeffs.get(Caracteristique.ENDURANCE) * getEndurance()) /
                (lesCoeffs.get(Caracteristique.FORCE) + lesCoeffs.get(Caracteristique.AGILITE)
                        + lesCoeffs.get(Caracteristique.ENDURANCE));
        return res * 10;
    }

    // Les getters et setters pour les attributs de la classe Athlete sont
    // ci-dessous

    public String getNomAt() {
        return nomAt;
    }

    public void setNomAt(String nomAt) {
        this.nomAt = nomAt;
    }

    public String getPrenomAt() {
        return prenomAt;
    }

    public void setPrenomAt(String prenomAt) {
        this.prenomAt = prenomAt;
    }

    public char getSexe() {
        return sexe;
    }

    public void setSexe(char sexe) {
        this.sexe = sexe;
    }

    public double getForce() {
        return force;
    }

    public void setForce(double force) {
        this.force = force;
    }

    public double getAgilite() {
        return agilite;
    }

    public void setAgilite(double agilite) {
        this.agilite = agilite;
    }

    public double getEndurance() {
        return endurance;
    }

    public void setEndurance(double endurance) {
        this.endurance = endurance;
    }

    public Pays getPays() {
        return pays;
    }

    public void setPays(Pays pays) {
        this.pays = pays;
    }

    @Override
    public String toString() {
        return "Athlete [agilite=" + agilite + ", endurance=" + endurance + ", force=" + force + ", nomAt=" + nomAt
                + ", prenomAt=" + prenomAt + ", sexe=" + sexe + ", pays=" + pays.getNom() + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Athlete)) {
            return false;
        }
        Athlete tmp = (Athlete) obj;
        return this.nomAt.equals(tmp.nomAt) && this.prenomAt.equals(tmp.prenomAt) && this.sexe == tmp.sexe
                && this.force == tmp.force && this.agilite == tmp.agilite && this.endurance == tmp.endurance;
    }

    @Override
    public int hashCode() {
        return nomAt.hashCode() + prenomAt.hashCode() + (int) sexe * 11 + (int) force * 31 + (int) agilite * 51
                + (int) endurance
                        * 41;
    }

}