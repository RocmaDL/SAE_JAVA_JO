public abstract class Epreuve {
    /** La liste des athlètes participant à l'épreuve */
    protected List<Athlete> lesParticipants;
    /** Le nom de l'épreuve */
    protected String nom;
    /** Le score maximum de l'épreuve */
    protected int scoreMax;
    /** La catégorie de genre de l'épreuve */
    protected String sexe;

    /** Constructeur qui met à jour les attributs de la classe abstraite Epreuve */
    public Epreuve(String nom, int scoreMax, String sexe) {
        this.nom = nom;
        this.scoreMax = scoreMax;
        this.sexe = sexe;
    }

    /** Récupère le nom de l'épreuve */
    public String getNomEpreuve() {
        return "";
    }

    /** Récupère la catégorie de genre de l'épreuve */
    public int getSexe() {
        return 0;
    }

    /** Récupère le score maximum de l'épreuve */
    public String sexe() {
        return "";
    }

    /** Calucle le score */
    public int calculerScore() {
        return 0;
    }
}