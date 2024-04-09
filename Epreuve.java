public abstract class Epreuve {
    /** Le nom du sport */
    private Sport sport;
    /** Le nom de l'épreuve */
    private String nomEpreuve;
    /** Le score maximum de l'épreuve */
    private int scoreMax;
    /** La catégorie de genre de l'épreuve */
    private String sexe;

    /** Constructeur qui met à jour les attributs de la classe abstraite Epreuve */
    public Epreuve(String nom, int scoreMax, String sexe) {
        this.nom = nom;
        this.scoreMax = scoreMax;
        this.sexe = sexe;
    }

    /** Récupère le nom de l'épreuve */
    public String getNomEpreuve() {
        return this.nom;
    }

    /** Récupère la catégorie de genre de l'épreuve */
    public String getSexe() {
        return this.sexe;
    }

    /** Récupère le score maximum de l'épreuve */
    public int getScoreMax() {
        return this.scoreMax;
    }

    /** Calcule le score */
    public int calculerScore() {
        return 0;
    }
}