package main.java.com.cdal;

/**
 * Enumération représentant les différentes unités de mesure utilisées dans les épreuves sportives.
 * Chaque unité est associée à un nom descriptif.
 */
public enum Unite {

    /**
     * Unité de mesure pour le temps.
     */
    TEMPS("temps"),

    /**
     * Unité de mesure pour les buts.
     */
    BUT("but"),

    /**
     * Unité de mesure pour les touches (par exemple, en escrime).
     */
    TOUCHE("touches"),

    /**
     * Unité de mesure pour les points.
     */
    POINT("point");

    /**
     * Nom descriptif de l'unité de mesure.
     */
    private final String nom;

    /**
     * Constructeur privé pour initialiser l'unité de mesure avec son nom.
     * 
     * @param nom Le nom descriptif de l'unité de mesure.
     */
    private Unite(String nom) {
        this.nom = nom;
    }

    /**
     * Retourne le nom descriptif de l'unité de mesure.
     * 
     * @return Le nom de l'unité de mesure.
     */
    public String getNom() {
        return this.nom;
    }
}