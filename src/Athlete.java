import java.util.Map;
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

    /**
     * Constructeur de la classe Athlete.
     * @param nomAt Le nom de l'athlète
     * @param prenomAt Le prénom de l'athlète
     * @param sexe Le sexe de l'athlète
     * @param force La force de l'athlète
     * @param agilite L'agilité de l'athlète
     * @param endurance L'endurance de l'athlète
     */
    public Athlete(String nomAt, String prenomAt, char sexe, double force, double agilite, double endurance) {
        this.nomAt = nomAt;
        this.prenomAt = prenomAt;
        this.sexe = sexe;
        this.force = force;
        this.agilite = agilite;
        this.endurance = endurance;
    }

    /**
     * Méthode pour participer à une épreuve.
     * @param epreuve L'épreuve à laquelle l'athlète participe
     * @return Le résultat de la participation de l'athlète à l'épreuve
     */
    @Override
    public double participer(Epreuve epreuve){  
        Map<Caracteristique, Double> lesCoeffs = epreuve.getSport().getCoefficient();
        return (lesCoeffs.get(Caracteristique.FORCE) * getForce() * Math.random() + 
        lesCoeffs.get(Caracteristique.AGILITE) * getAgilite() * Math.random() + lesCoeffs.get(Caracteristique.ENDURANCE) * getEndurance() * Math.random() ) / 
        (lesCoeffs.get(Caracteristique.FORCE) + lesCoeffs.get(Caracteristique.AGILITE) + lesCoeffs.get(Caracteristique.ENDURANCE));
        
    }

    // Les getters et setters pour les attributs de la classe Athlete sont ci-dessous
    

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

}