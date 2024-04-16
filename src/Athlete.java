public class Athlete implements Participer {
    private String nomAt;
    private String prenomAt;
    private char sexe;
    private double force;
    private double agilite;
    private double endurance;

    public Athlete(String nomAt, String prenomAt, char sexe, double force, double agilite, double endurance) {
        this.nomAt = nomAt;
        this.prenomAt = prenomAt;
        this.sexe = sexe;
        this.force = force;
        this.agilite = agilite;
        this.endurance = endurance;
    }

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