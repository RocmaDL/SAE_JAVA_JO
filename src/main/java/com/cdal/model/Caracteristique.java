package main.java.com.cdal.model;
/**
 * Enumération des caractéristiques d'un personnage.
 * Cette énumération définit les différentes caractéristiques que peut posséder un personnage,
 * telles que la force, l'agilité et l'endurance.
 * Chaque caractéristique est associée à un nom spécifique.
 */
public enum Caracteristique {
    FORCE("force"), // Représente la force du personnage.
    AGILITE("agilite"), // Représente l'agilité du personnage.
    ENDURANCE("endurance"); // Représente l'endurance du personnage.

    private final String nom; // Nom de la caractéristique.

    /**
     * Constructeur privé de l'énumération Caracteristique.
     * Initialise une nouvelle instance de Caracteristique avec le nom spécifié.
     * @param nom Le nom de la caractéristique.
     */
    private Caracteristique(String nom) {
        this.nom = nom;
    }

    /**
     * Retourne le nom de la caractéristique.
     * @return Le nom de la caractéristique.
     */
    public String getNom() {
        return this.nom;
    }
}